package com.dm.springbootjpapostgresql.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;
import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.collection.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.collection.montaji.ResponseObj;
//import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXRequestMapper2;
import com.dm.springbootjpapostgresql.mapper.CreateCPIPRXResponseMapper;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXRequestRepository;
import com.dm.springbootjpapostgresql.repository.CreateCPIPRXResponseRepository;

import com.dm.springbootjpapostgresql.service.MontajiService;
import com.dm.springbootjpapostgresql.utils.StringToClobConverter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import com.dm.springbootjpapostgresql.model.montaji.*;
import com.dm.springbootjpapostgresql.repository.montaji.*;
import com.dm.springbootjpapostgresql.dto.montaji.*;
import com.dm.springbootjpapostgresql.exception.AttachmentValidationException;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;

import com.dm.springbootjpapostgresql.utils.StringToClobConverter;

@Service
public class MontajiServiceImpl implements MontajiService{

private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

private final String uploadPath = "src/main/resources/attachments";

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
UserRepository userRepository;
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
@Autowired
private HttpServletRequest request;    
@Autowired
StringToClobConverter stringToClobConverter;

    @Override
    @Transactional
    public CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) throws AttachmentValidationException, IOException {
        // Access the request headers
        String contentType = request.getHeader("Content-Type");
        String accept = request.getHeader("Accept");
        String method = request.getMethod();

        // Log the headers and potentially the body using a logger
        logger.info("Request received: Content-Type={}, Accept={},method={}", contentType, accept,method);

        //CreateCPIPRXRequest createCPIPRXRequest = createCPIPRXRequestMapper.mapToEntity(createCPIPRXRequestDTO);
        //createCPIPRXRequestRepository.save(createCPIPRXRequest);

        //Optional<CompanyDetails> companyDetails=companyDetailsRepository.findById(createCPIPRXRequestDTO.companyDetails.licensenumber);
        CompanyDetailsDTO companyDetailsDTO = createCPIPRXRequestDTO.getCompanyDetails();
        // CompanyDetails companyDetails=companyDetailsRepository.findById(companyDetailsDTO.getLicensenumber())
        // .orElseThrow(() -> new ResourceNotFoundException("CompanyDetails", "licenseNumber", companyDetailsDTO.getLicensenumber()));
        CompanyDetails companyDetails=companyDetailsRepository.findByImporterCode(companyDetailsDTO.getImporterCode())
        .orElseThrow(() -> new ResourceNotFoundException("CompanyDetails", "importerCode", companyDetailsDTO.getImporterCode()));        

        RequestDetailsDTO requestDetailsDTO = createCPIPRXRequestDTO.getRequestDetails();
        
        User user = userRepository.findByUserName(requestDetailsDTO.getCreatedBy()).orElse(null);
        //User user2 = UserRepository.findSingleUserByUserName(requestDetailsDTO.getCreatedBy()).orElse(null);

        ConsignmentDetailsDTO consignmentDetailsDTO = createCPIPRXRequestDTO.getConsignmentDetails();
        ConsignmentRequestDetailsDTO consignmentRequestDetailsDTO = consignmentDetailsDTO.getRequestdetails();

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
                                            .setUser(user)
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

        List<Attachment> attachmentList = new ArrayList<>();
        List<AttachmentContainerDTO> attachmentContainerDTOs=createCPIPRXRequestDTO.getAttachments();

        for(AttachmentContainerDTO attachmentContainerDTO : attachmentContainerDTOs)
        {
            List<AttachmentDTO> attachmentDTOs = attachmentContainerDTO.getAttachments();
            for(AttachmentDTO attachmentDTO : attachmentDTOs)
            { 
            
            if (attachmentDTO.getFileName() == null || attachmentDTO.getFileType() == null /*|| attachmentDTO.getFileContent() == null*/) {
                throw new AttachmentValidationException("Missing required fields: fileName, fileType, fileContent");
            }
        
            // Validate file type (optional)
            if (!isValidFileType(attachmentDTO.getFileType())) {
                throw new AttachmentValidationException("Unsupported file type: " + attachmentDTO.getFileType());
            }
        
            // Extract base64 content and decode
            String base64Image = attachmentDTO.getFileContent().split(",")[1]; // Assuming data:application/pdf;base64, base64 content format
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
        
            // Create file path with appropriate extension based on fileType
            String filePath = uploadPath + File.separator + attachmentDTO.getFileName();
        
            // Store the image in the server
            File file = new File(filePath);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(decodedBytes);
            } catch (IOException e) {
                throw new IOException("Error saving attachment: " + e.getMessage());
            }            

                Clob fileContentClob = stringToClobConverter.convertToDatabaseColumn(attachmentDTO.getFileContent());
                Attachment attachment = Attachment.builder()
                                                    .attachmentType(attachmentContainerDTO.getAttachmentType())
                                                    .fileName(attachmentDTO.getFileName())
                                                    .fileType(attachmentDTO.getFileType())
                                                    .fileContent(fileContentClob)
                                                    .request(requestCPIP)
                                                    .build();
                attachmentList.add(attachment);
            }
        }

        requestCPIP.setAttachments(attachmentList);
        
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
        ResponseObj response = new ResponseObj();
        response.setRequestNumber("CPIP-221221-009434");
        response.setDtReferenceNo("DTREF005690351");
        createCPIPRXResponse.setResponse(response);
        
        //createCPIPRXResponseRepository.save(createCPIPRXResponse);        
        System.out.println("End of MontajiServiceImpl");
        return createCPIPRXResponseMapper.mapToDTO(createCPIPRXResponse);        
    }
    private boolean isValidFileType(String fileType) {
        return fileType.equals("image/png") || fileType.equals("image/jpeg") || fileType.equals("application/jpeg") || fileType.equals("application/pdf"); // Add more supported types as needed
    }    
}
