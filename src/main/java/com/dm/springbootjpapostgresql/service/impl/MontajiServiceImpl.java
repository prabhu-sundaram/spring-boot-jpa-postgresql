package com.dm.springbootjpapostgresql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
//import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper2;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXResponseMapper;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXRequestRepository;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXResponseRepository;

import com.dm.springbootjpapostgresql.service.MontajiService;

import jakarta.transaction.Transactional;

import com.dm.springbootjpapostgresql.model.montaji.*;
import com.dm.springbootjpapostgresql.repository.montaji.*;
import com.dm.springbootjpapostgresql.dto.montaji.*;

@Service
public class MontajiServiceImpl implements MontajiService{

// @Autowired
// private CreateCPIPRXRequestMapper createCPIPRXRequestMapper;
@Autowired
private CreateCPIPRXRequestMapper2 createCPIPRXRequestMapper;
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
    @Transactional
    public CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        CreateCPIPRXRequest createCPIPRXRequest = createCPIPRXRequestMapper.mapToEntity(createCPIPRXRequestDTO);
        createCPIPRXRequestRepository.save(createCPIPRXRequest);

        //Optional<CompanyDetails> companyDetails=companyDetailsRepository.findById(createCPIPRXRequestDTO.companyDetails.licensenumber);
        CompanyDetailsDTO companyDetailsDTO = createCPIPRXRequestDTO.getCompanyDetails();
        CompanyDetails companyDetails=companyDetailsRepository.findById(companyDetailsDTO.licensenumber).get();

        RequestDetailsDTO requestDetailsDTO = createCPIPRXRequestDTO.getRequestDetails();
        ConsignmentDetailsDTO consignmentDetailsDTO = createCPIPRXRequestDTO.getConsignmentDetails();
        ConsignmentRequestDetailsDTO consignmentRequestDetailsDTO = consignmentDetailsDTO.requestdetails;

        // Request request = Request.requestBuilder()
        //                 .requestNumber(requestDetailsDTO.requestNumber)
        //                 .requestSource(requestDetailsDTO.requestSource)
        //                 .requestType(requestDetailsDTO.requestType)
        //                 .requestDate(requestDetailsDTO.requestDate)
        //                 .requestStatus("Created")
        //                 .dtReferenceNo(requestDetailsDTO.dtReferenceNo)
        //                 .companyDetails(companyDetails)
        //                 .build();
        // request=requestRepository.save(request);


        // RequestCPIP requestCPIP = RequestCPIP.requestCPIPBuilder()
        //                         .consignmentPurposeId(consignmentRequestDetailsDTO.consignmentPurposeId)
        //                         .request(request)
        //                         .build();

        RequestCPIP requestCPIP = new RequestCPIPBuilder()
                                            .setRequestNumber(requestDetailsDTO.getRequestNumber())
                                            .setRequestSource(requestDetailsDTO.getRequestSource())
                                            .setRequestType(requestDetailsDTO.getRequestType())
                                            .setRequestDate(requestDetailsDTO.getRequestDate())
                                            .setRequestStatus("Created")
                                            .setDtReferenceNo(requestDetailsDTO.getDtReferenceNo())
                                            .setCompanyDetails(companyDetails)
                                            //.setConsignmentPurposeId(consignmentRequestDetailsDTO.getConsignmentPurposeId)
                                            .build();

        requestCPIP.setConsignmentPurposeId(consignmentRequestDetailsDTO.getConsignmentPurposeId());

        PortDetailsDTO portDetailsDTO = consignmentDetailsDTO.getPortDetails();

        ReqPortDetails reqPortDetails = ReqPortDetails.builder()
                                                        .portTypeId(portDetailsDTO.getPortTypeId())
                                                        .portOfEntryId(portDetailsDTO.getPortOfEntryId())
                                                        .billNumber(portDetailsDTO.getBillNumber())
                                                        .billDate(portDetailsDTO.getBillDate())
                                                        .arrivalDate(portDetailsDTO.getArrivalDate())
                                                        .customsDeclarationNumber(portDetailsDTO.getCustomsDeclarationNumber())
                                                        .customsDeclarationDate(portDetailsDTO.getCustomsDeclarationDate())
                                                        .packageTypeId(portDetailsDTO.getPackageTypeId())
                                                        .numberOfPackages(portDetailsDTO.getNumberOfPackages())
                                                        .transportNumber(portDetailsDTO.getTransportNumber())
                                                        .vesselName(portDetailsDTO.getVesselName())
                                                        .grossWeight(portDetailsDTO.getGrossWeight())
                                                        .remarks(portDetailsDTO.getRemarks())
                                                        .requestCPIP(requestCPIP)
                                                        .build();
        requestCPIP.setReqPortDetails(reqPortDetails);
        
        List<ContainerDTO> containerDTOList = createCPIPRXRequestDTO.getContainers();

        List<Container> containerList = new ArrayList<>();
        
        for (ContainerDTO containerDTO : containerDTOList) {
            Container container = Container.builder()
                                            .serialNo(containerDTO.getSerialNo())
                                            .containerTypeId(containerDTO.getContainerTypeId())
                                            .containerNumber(containerDTO.getContainerNumber())
                                            .storageTemperatureId(containerDTO.getStorageTemperatureId())
                                            .containerTotalQuantity(containerDTO.getContainerTotalQuantity())
                                            .productsCount(containerDTO.getProductsCount())
                                            .containerTotalWeight(containerDTO.getContainerTotalWeight())
                                            .requestCPIP(requestCPIP)
                                            .build();
            
                List<ProductDTO> productDTOList=containerDTO.getProducts();
                List<ContainerProduct> containerProductList = new ArrayList<>();
        
                for (ProductDTO productDTO : productDTOList) {
                    ContainerProduct containerProduct = ContainerProduct.builder()
                                                                        .barcode(productDTO.getBarcode())
                                                                        .productId(productDTO.getProductId())
                                                                        .groupId(productDTO.getGroupId())
                                                                        .categoryId(productDTO.getCategoryId())
                                                                        .subCategoryId(productDTO.getSubCategoryId())
                                                                        .countryId(productDTO.getCountryId())
                                                                        .brandId(productDTO.getBrandId())
                                                                        .noOfBatches(productDTO.getNoOfBatches())
                                                                        .productTotalQuantity(productDTO.getProductTotalQuantity())
                                                                        .productUnitWeight(productDTO.getProductUnitWeight())
                                                                        .productTotalWeight(productDTO.getProductTotalWeight())
                                                                        .container(container)
                                                                        .build();

                        List<BatchDTO> batchDTOList=productDTO.getBatches();
                        List<ProductBatch> productBatchList=new ArrayList<>();

                        for (BatchDTO batchDTO : batchDTOList) {
                            ProductBatch productBatch = ProductBatch.builder()
                                                                    .serialNo(batchDTO.getSerialNo())
                                                                    .itemsUnitWeight(batchDTO.getItemsUnitWeight())
                                                                    .itemsQuantity(batchDTO.getItemsQuantity())
                                                                    .itemsTotalWeight(batchDTO.getItemsTotalWeight())
                                                                    .containerProduct(containerProduct)
                                                                    .build();
                            
                            productBatchList.add(productBatch);
                        }                        
                    
                        //productBatchRepository.saveAll(productBatchList);
                        containerProduct.setBatches(productBatchList);
                    containerProductList.add(containerProduct);
                }

                //containerProductRepository.saveAll(containerProductList);
                container.setProducts(containerProductList);

            containerList.add(container);
        }        
      
        
        
        //containerRepository.saveAll(containerList);
        requestCPIP.setContainers(containerList);

        
        List<AttachmentContainerDTO> attachmentContainerDTOs=createCPIPRXRequestDTO.getAttachments();
        
        PreApprovalDTO preApprovalDTO=createCPIPRXRequestDTO.getPreApproval();
        PreApproval preApproval=PreApproval.builder()
                                            .dip(preApprovalDTO.getDip())
                                            .dipWarehouseId(preApprovalDTO.getDipWarehouseId())
                                            .releaseWithDetention(preApprovalDTO.getReleaseWithDetention())
                                            .releaseWithDetentionWarehouseId(preApprovalDTO.getReleaseWithDetentionWarehouseId())
                                            .sampleDetention(preApprovalDTO.getSampleDetention())
                                            .sampleDetentionWarehouseId(preApprovalDTO.getSampleDetentionWarehouseId())
                                            .requestCPIP(requestCPIP)
                                            .build();
        requestCPIP.setPreApproval(preApproval);

        //preApprovalRepository.save(preApproval);

        requestCPIPRepository.save(requestCPIP);
     
        CreateCPIPRXResponse createCPIPRXResponse = new CreateCPIPRXResponse();
        createCPIPRXResponse.setIsSuccess("true");
        createCPIPRXResponse.setErrorCode("000");
        createCPIPRXResponse.setErrorDescription("No Error");
        createCPIPRXResponse.setData(null);
        ResponseDTO response = new ResponseDTO();
        response.setRequestNumber("CPIP-221221-009434");
        response.setDtReferenceNo("DTREF005690351");
        createCPIPRXResponse.setResponse(response);
        
        createCPIPRXResponseRepository.save(createCPIPRXResponse);        

        return createCPIPRXResponseMapper.mapToDTO(createCPIPRXResponse);        
    }
    
}
