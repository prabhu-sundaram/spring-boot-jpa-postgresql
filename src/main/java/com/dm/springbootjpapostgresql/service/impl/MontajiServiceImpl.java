package com.dm.springbootjpapostgresql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXResponseMapper;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXRequestRepository;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXResponseRepository;

import com.dm.springbootjpapostgresql.service.MontajiService;

import com.dm.springbootjpapostgresql.model.montaji.*;
import com.dm.springbootjpapostgresql.repository.montaji.*;
import com.dm.springbootjpapostgresql.dto.montaji.*;

@Service
public class MontajiServiceImpl implements MontajiService{

@Autowired
private CreateCPIPRXRequestMapper createCPIPRXRequestMapper;
@Autowired
private CreateCPIPRXResponseMapper createCPIPRXResponseMapper;

@Autowired
CreateCPIPRXRequestRepository createCPIPRXRequestRepository;
@Autowired
CreateCPIPRXResponseRepository createCPIPRXResponseRepository;

@Autowired
CompanyDetailsRepository companyDetailsRepository;
@Autowired
RequestRepository requestRepository;
@Autowired
RequestCPIPRepository requestCPIPRepository;
@Autowired
ReqPortDetailsRepository reqPortDetailsRepository;
@Autowired
ContainerRepository containerRepository;
@Autowired
ContainerProductRepository containerProductRepository;
@Autowired
ProductBatchRepository productBatchRepository;
@Autowired
PreApprovalRepository preApprovalRepository;

    @Override
    public CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        CreateCPIPRXRequest createCPIPRXRequest = createCPIPRXRequestMapper.mapToEntity(createCPIPRXRequestDTO);
        createCPIPRXRequestRepository.save(createCPIPRXRequest);

        //Optional<CompanyDetails> companyDetails=companyDetailsRepository.findById(createCPIPRXRequestDTO.companyDetails.licensenumber);
        CompanyDetailsDTO companyDetailsDTO = createCPIPRXRequestDTO.companyDetails;
        CompanyDetails companyDetails=companyDetailsRepository.findById(companyDetailsDTO.licensenumber).get();

        RequestDetailsDTO requestDetailsDTO = createCPIPRXRequestDTO.requestDetails;

        Request request=Request.builder()
                                .requestNumber(requestDetailsDTO.requestNumber)
                                .dtReferenceNo(requestDetailsDTO.dtReferenceNo)
                                .requestSource(requestDetailsDTO.requestSource)
                                .requestDate(requestDetailsDTO.requestDate)
                                .requestStatus("Created")
                                .companyDetails(companyDetails)
                                .build();

        ConsignmentDetailsDTO consignmentDetailsDTO=createCPIPRXRequestDTO.consignmentDetails;
        ConsignmentRequestDetailsDTO consignmentRequestDetailsDTO = consignmentDetailsDTO.requestdetails;

        RequestCPIP requestCPIP=RequestCPIP.builder()
                                        .consignmentPurposeId(consignmentRequestDetailsDTO.consignmentPurposeId)
                                        .request(request)
                                        .build();


        PortDetailsDTO portDetailsDTO=consignmentDetailsDTO.portDetails;
        ReqPortDetails reqPortDetails = ReqPortDetails.builder()
                                                        .portTypeId(portDetailsDTO.portTypeId)
                                                        .portOfEntryId(portDetailsDTO.portOfEntryId)
                                                        //.portOfEntryDesc(portDetailsDTO.portOfEntryDesc)
                                                        .countryOfOriginId(0)
                                                        .billNumber(portDetailsDTO.billNumber)
                                                        .billDate(portDetailsDTO.billDate)
                                                        .arrivalDate(portDetailsDTO.arrivalDate)
                                                        .customsDeclarationNumber(portDetailsDTO.customsDeclarationNumber)
                                                        .customsDeclarationDate(portDetailsDTO.customsDeclarationDate)
                                                        .packageTypeId(portDetailsDTO.packageTypeId)
                                                        .numberOfPackages(portDetailsDTO.numberOfPackages)
                                                        .transportNumber(portDetailsDTO.transportNumber)
                                                        .vesselName(portDetailsDTO.vesselName)
                                                        .grossWeight(portDetailsDTO.grossWeight)
                                                        .remarks(portDetailsDTO.remarks)
                                                        .requestCPIP(requestCPIP)
                                                        .build();
        requestCPIP.setReqPortDetails(reqPortDetails);
        
        List<ContainerDTO> containerDTOList = createCPIPRXRequestDTO.containers;

        List<Container> containerList = new ArrayList<>();
        
        for (ContainerDTO containerDTO : containerDTOList) {
            Container container = Container.builder()
                .serialNo(containerDTO.serialNo)
                .containerTypeId(containerDTO.containerTypeId)
                .containerNumber(containerDTO.containerNumber)
                .storageTemperatureId(containerDTO.storageTemperatureId)
                .containerTotalQuantity(containerDTO.containerTotalQuantity)
                .productsCount(containerDTO.productsCount)
                .containerTotalWeight(containerDTO.containerTotalWeight)
                .requestCPIP(requestCPIP)
                .build();
            
                List<ProductDTO> productDTOList=containerDTO.products;
                List<ContainerProduct> containerProductList = new ArrayList<>();
        
                for (ProductDTO productDTO : productDTOList) {
                    ContainerProduct containerProduct = ContainerProduct.builder()
                        .barcode(productDTO.barcode)
                        .productId(productDTO.productId)
                        .groupId(productDTO.groupId)
                        .categoryId(productDTO.categoryId)
                        .subCategoryId(productDTO.subCategoryId)
                        .countryId(productDTO.countryId)
                        .brandId(productDTO.brandId)
                        .noOfBatches(productDTO.noOfBatches)
                        .productTotalQuantity(productDTO.productTotalQuantity)
                        .productUnitWeight(productDTO.productUnitWeight)
                        .productTotalWeight(productDTO.productTotalWeight)
                        .container(container)
                        .build();

                        List<BatchDTO> batchDTOList=productDTO.batches;
                        List<ProductBatch> productBatchList=new ArrayList<>();

                        for (BatchDTO batchDTO : batchDTOList) {
                            ProductBatch productBatch = ProductBatch.builder()
                                .serialNo(batchDTO.serialNo)
                                .itemsUnitWeight(batchDTO.itemsUnitWeight)
                                .itemsQuantity(batchDTO.itemsQuantity)
                                .itemsTotalWeight(batchDTO.itemsTotalWeight)
                                .containerProduct(containerProduct)
                                .build();
                            
                            productBatchList.add(productBatch);
                        }                        
                    
                        productBatchRepository.saveAll(productBatchList);
                        containerProduct.setBatches(productBatchList);
                    containerProductList.add(containerProduct);
                }

                containerProductRepository.saveAll(containerProductList);
                container.setProducts(containerProductList);

            containerList.add(container);
        }        
      
        
        
        containerRepository.saveAll(containerList);
        requestCPIP.setContainers(containerList);

        
        List<AttachmentContainerDTO> attachmentContainerDTOs=createCPIPRXRequestDTO.attachments;
        
        PreApprovalDTO preApprovalDTO=createCPIPRXRequestDTO.preApproval;
        PreApproval preApproval=PreApproval.builder()
                                            .dip(preApprovalDTO.dip)
                                            .dipWarehouseId(preApprovalDTO.dipWarehouseId)
                                            .releaseWithDetention(preApprovalDTO.releaseWithDetention)
                                            .releaseWithDetentionWarehouseId(preApprovalDTO.releaseWithDetentionWarehouseId)
                                            .sampleDetention(preApprovalDTO.sampleDetention)
                                            .sampleDetentionWarehouseId(preApprovalDTO.sampleDetentionWarehouseId)
                                            .requestCPIP(requestCPIP)
                                            .build();
        requestCPIP.setPreApproval(preApproval);

        preApprovalRepository.save(preApproval);

        requestCPIPRepository.save(requestCPIP);
        requestRepository.save(request);
     



        CreateCPIPRXResponse createCPIPRXResponse = new CreateCPIPRXResponse();
        createCPIPRXResponse.isSuccess="true";
        createCPIPRXResponse.errorCode="000";
        createCPIPRXResponse.errorDescription="No Error";
        createCPIPRXResponse.data=null;
        ResponseDTO response = new ResponseDTO();
        response.requestNumber="CPIP-221221-009434";
        response.dtReferenceNo="DTREF005690351";
        createCPIPRXResponse.setResponse(response);
        
        createCPIPRXResponseRepository.save(createCPIPRXResponse);        

        return createCPIPRXResponseMapper.mapToDTO(createCPIPRXResponse);        
    }
    
}
