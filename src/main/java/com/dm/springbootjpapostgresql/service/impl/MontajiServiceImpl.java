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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;

import com.dm.springbootjpapostgresql.service.MontajiService;
import com.dm.springbootjpapostgresql.utils.StringToClobConverter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import com.dm.springbootjpapostgresql.repository.jpa.montaji.*;
import com.dm.springbootjpapostgresql.repository.mongo.CreateCPIPRXRequestRepository;
import com.dm.springbootjpapostgresql.repository.mongo.CreateCPIPRXResponseRepository;
import com.dm.springbootjpapostgresql.dto.montaji.*;
import com.dm.springbootjpapostgresql.exception.BaseException;
import com.dm.springbootjpapostgresql.exception.MontajiAttachmentValidationException;
import com.dm.springbootjpapostgresql.exception.MontajiCompanyValidationException;
import com.dm.springbootjpapostgresql.exception.MontajiDuplicateReuestException;
import com.dm.springbootjpapostgresql.exception.MontajiEmptyRequestDateException;
import com.dm.springbootjpapostgresql.exception.MontajiIOException;
import com.dm.springbootjpapostgresql.exception.MontajiInvalidApplicantDMUserIdException;
import com.dm.springbootjpapostgresql.exception.MontajiInvalidDtReferenceNoException;
import com.dm.springbootjpapostgresql.exception.MontajiInvalidRequestSourceException;
import com.dm.springbootjpapostgresql.exception.MontajiInvalidRequestTypeException;
import com.dm.springbootjpapostgresql.exception.MontajiMismatchUserCompanyException;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.mapper.mongo.montaji.CreateCPIPRXRequestMapper;
import com.dm.springbootjpapostgresql.mapper.mongo.montaji.CreateCPIPRXRequestMapper2;
import com.dm.springbootjpapostgresql.mapper.mongo.montaji.CreateCPIPRXResponseMapper;
import com.dm.springbootjpapostgresql.mapper.mongo.montaji.CreateCPIPRXResponseMapper2;
import com.dm.springbootjpapostgresql.model.entity.montaji.*;
import com.dm.springbootjpapostgresql.utils.StringToClobConverter;
import com.dm.springbootjpapostgresql.utils.IdGenerator;
import com.dm.springbootjpapostgresql.utils.IdGenerator2;
import com.dm.springbootjpapostgresql.utils.IdGenerator3;

//Mongo starts
import com.dm.springbootjpapostgresql.model.document.montaji.CreateCPIPRXRequest;
import com.dm.springbootjpapostgresql.model.document.montaji.CreateCPIPRXResponse;
import com.dm.springbootjpapostgresql.model.document.montaji.ResponseObj;

//Mongo ends

@Service
public class MontajiServiceImpl implements MontajiService{

private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

//private final String uploadPath = "src/main/resources/attachments";
@Value("${attachment.location}")
private String uploadPath;

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
@Autowired
IdGenerator2    idGenerator2;
@Autowired
private IdGenerator3 idGenerator3;

//Mongo starts
@Autowired
private CreateCPIPRXRequestMapper createCPIPRXRequestMapper;
@Autowired
private CreateCPIPRXRequestMapper2 createCPIPRXRequestMapper2;
@Autowired
private CreateCPIPRXResponseMapper createCPIPRXResponseMapper;
@Autowired
private CreateCPIPRXResponseMapper2 createCPIPRXResponseMapper2;

@Autowired
CreateCPIPRXRequestRepository createCPIPRXRequestRepository;
@Autowired
CreateCPIPRXResponseRepository createCPIPRXResponseRepository;
//Mongo ends


    @Override
    @Transactional
    public CreateCPIPRXResponseDTO createCPIPRX(CreateCPIPRXRequestDTO createCPIPRXRequestDTO) {
        // Access the request headers
        String contentType = request.getHeader("Content-Type");
        String accept = request.getHeader("Accept");
        String method = request.getMethod();

        // Log the headers and potentially the body using a logger
        logger.info("Request received: Content-Type={}, Accept={},method={}", contentType, accept,method);

        // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO = new CreateCPIPRXResponseDTO();

        //Optional<CompanyDetails> companyDetails=companyDetailsRepository.findById(createCPIPRXRequestDTO.companyDetails.licensenumber);
        CompanyDetailsDTO companyDetailsDTO = createCPIPRXRequestDTO.getCompanyDetails();

        // // CompanyDetails companyDetails=companyDetailsRepository.findById(companyDetailsDTO.getLicensenumber())
        // // .orElseThrow(() -> new ResourceNotFoundException("CompanyDetails", "licenseNumber", companyDetailsDTO.getLicensenumber()));
        // // CompanyDetails companyDetails=companyDetailsRepository.findByImporterCode(companyDetailsDTO.getImporterCode())
        // // .orElseThrow(() -> new ResourceNotFoundException("CompanyDetails", "importerCode", companyDetailsDTO.getImporterCode()));        
        // Optional<CompanyDetails> companyDetailsOptional=companyDetailsRepository.findByImporterCode(companyDetailsDTO.getImporterCode());

        // CompanyDetails companyDetails;

        // if(companyDetailsOptional.isPresent())
        // {
        //     companyDetails=companyDetailsOptional.get();
        // }
        // else
        // {
        //     // createCPIPRXErrorResponseDTO.setIsSuccess("false");
        //     // createCPIPRXErrorResponseDTO.setErrorCode("002");
        //     // createCPIPRXErrorResponseDTO.setErrorDescription("Please Verify Company Details");
        //     // createCPIPRXErrorResponseDTO.setData(null);
        //     // createCPIPRXErrorResponseDTO.setResponse(null);      
        //     CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
        //                                                                                 .isSuccess("false")
        //                                                                                 .errorCode("002")
        //                                                                                 .errorDescription("Please Verify Company Details")
        //                                                                                 .data(null)
        //                                                                                 .response(null)
        //                                                                                 .build();                
        //     return createCPIPRXErrorResponseDTO;
        // }

        if(companyDetailsDTO.getLicensenumber()==null || companyDetailsRepository.findById(companyDetailsDTO.getLicensenumber()).isEmpty())
        throw new MontajiCompanyValidationException("License number " + companyDetailsDTO.getLicensenumber());

        if(companyDetailsDTO.getImporterCode()==null || companyDetailsRepository.findByImporterCode(companyDetailsDTO.getImporterCode()).isEmpty())
        throw new MontajiCompanyValidationException("Importer code " + companyDetailsDTO.getImporterCode());

        Optional<CompanyDetails> companyDetailsOptional=companyDetailsRepository.findByImporterCode(companyDetailsDTO.getImporterCode());

        CompanyDetails companyDetails = null;

        if(companyDetailsOptional.isPresent())
        {
            companyDetails=companyDetailsOptional.get();
        }

        //--------------------------------
        
        RequestDetailsDTO requestDetailsDTO = createCPIPRXRequestDTO.getRequestDetails();
        
        if(requestDetailsDTO.getRequestSource()==null||requestDetailsDTO.getRequestSource().isEmpty()||!requestDetailsDTO.getRequestSource().equals("DT"))
        {
            // createCPIPRXErrorResponseDTO.setIsSuccess("false");
            // createCPIPRXErrorResponseDTO.setErrorCode("101");
            // createCPIPRXErrorResponseDTO.setErrorDescription("Please Enter Valid RequestSource");
            // createCPIPRXErrorResponseDTO.setData(null);
            // createCPIPRXErrorResponseDTO.setResponse(null);    
            // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
            //                                                                             .isSuccess("false")
            //                                                                             .errorCode("101")
            //                                                                             .errorDescription("Please Enter Valid RequestSource")
            //                                                                             .data(null)
            //                                                                             .response(null)
            //                                                                             .build();               
            // return createCPIPRXErrorResponseDTO;
            throw new MontajiInvalidRequestSourceException(requestDetailsDTO.getRequestSource());
        }
        if(requestDetailsDTO.getDtReferenceNo()==null||requestDetailsDTO.getDtReferenceNo().isEmpty())
        {
            // createCPIPRXErrorResponseDTO.setIsSuccess("false");
            // createCPIPRXErrorResponseDTO.setErrorCode("102");
            // createCPIPRXErrorResponseDTO.setErrorDescription("Please Enter Valid dtReferenceNo");
            // createCPIPRXErrorResponseDTO.setData(null);
            // createCPIPRXErrorResponseDTO.setResponse(null);
            // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
            //                                                                             .isSuccess("false")
            //                                                                             .errorCode("102")
            //                                                                             .errorDescription("Please Enter Valid dtReferenceNo")
            //                                                                             .data(null)
            //                                                                             .response(null)
            //                                                                             .build();           
            // return createCPIPRXErrorResponseDTO;   
            throw new MontajiInvalidDtReferenceNoException(requestDetailsDTO.getDtReferenceNo());
        }        

        //Optional<Request> request=requestRepository.findByDtReferenceNo(requestDetailsDTO.getDtReferenceNo());
        List<Request> requests=requestRepository.findByDtReferenceNo(requestDetailsDTO.getDtReferenceNo());
        if(!requests.isEmpty())
        {
            // Request request = requests.get(0);
            // if(request!=null)
            // {
                // createCPIPRXErrorResponseDTO.setIsSuccess("false");
                // createCPIPRXErrorResponseDTO.setErrorCode("103");
                // createCPIPRXErrorResponseDTO.setErrorDescription("Request is already created with given dtReferenceNo");
                // createCPIPRXErrorResponseDTO.setData(null);
                // createCPIPRXErrorResponseDTO.setResponse(null);
                // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
                //                                                                             .isSuccess("false")
                //                                                                             .errorCode("103")
                //                                                                             .errorDescription("Request is already created with given dtReferenceNo")
                //                                                                             .data(null)
                //                                                                             .response(null)
                //                                                                             .build();             
                // return createCPIPRXErrorResponseDTO;  
            // }
            throw new MontajiDuplicateReuestException(requestDetailsDTO.getDtReferenceNo());
        }
        //User user = userRepository.findByUserName(requestDetailsDTO.getCreatedBy()).orElse(null);
        //User user2 = UserRepository.findSingleUserByUserName(requestDetailsDTO.getCreatedBy()).orElse(null);
        Optional<User> userOptional = userRepository.findByUserName(requestDetailsDTO.getApplicantDMUserId());
        User user;

        if(userOptional.isPresent())
        {
            user=userOptional.get();
        }
        else
        {
            // createCPIPRXErrorResponseDTO.setIsSuccess("false");
            // createCPIPRXErrorResponseDTO.setErrorCode("104");
            // createCPIPRXErrorResponseDTO.setErrorDescription("Please Enter applicantDMUserId");
            // createCPIPRXErrorResponseDTO.setData(null);
            // createCPIPRXErrorResponseDTO.setResponse(null);
            // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
            //                                                                             .isSuccess("false")
            //                                                                             .errorCode("104")
            //                                                                             .errorDescription("Please Enter valid applicantDMUserId")
            //                                                                             .data(null)
            //                                                                             .response(null)
            //                                                                             .build();            
            // return createCPIPRXErrorResponseDTO; 
            throw new MontajiInvalidApplicantDMUserIdException(requestDetailsDTO.getApplicantDMUserId());
        }

        if (userOptional.isPresent() && companyDetailsOptional.isPresent()) {
            User user2 = userOptional.get();
            logger.info("user2: " + user2.getCompanyDetails().getLicenseNumber());
            CompanyDetails companyDetails2 = companyDetailsOptional.get();
            logger.info("companyDetails2: " + companyDetails2.getLicenseNumber());
            Boolean isUserSameCompany=user2.getCompanyDetails().equals(companyDetails2);
            logger.info("isUserSameCompany: " + isUserSameCompany);

            if(!isUserSameCompany)
            {
                // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
                //                                                                             .isSuccess("false")
                //                                                                             .errorCode("105")
                //                                                                             .errorDescription("User and Company are not matching")
                //                                                                             .data(null)
                //                                                                             .response(null)
                //                                                                             .build();            
                // return createCPIPRXErrorResponseDTO; 
                throw new MontajiMismatchUserCompanyException();
            }

        }

        if(requestDetailsDTO.getRequestType()==null||requestDetailsDTO.getRequestType().isEmpty()
            ||(!requestDetailsDTO.getRequestType().equals("CPIP") && !requestDetailsDTO.getRequestType().equals("CPRX")))
        {
            // createCPIPRXErrorResponseDTO.setIsSuccess("false");
            // createCPIPRXErrorResponseDTO.setErrorCode("105");
            // createCPIPRXErrorResponseDTO.setErrorDescription("Please Enter Valid Request Type");
            // createCPIPRXErrorResponseDTO.setData(null);
            // createCPIPRXErrorResponseDTO.setResponse(null);
            // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
            //                                                                             .isSuccess("false")
            //                                                                             .errorCode("106")
            //                                                                             .errorDescription("Please Enter Valid Request Type")
            //                                                                             .data(null)
            //                                                                             .response(null)
            //                                                                             .build();               
            // return createCPIPRXErrorResponseDTO;  
            throw new MontajiInvalidRequestTypeException(requestDetailsDTO.getRequestType());
        }
        if(requestDetailsDTO.getRequestDate()==null)
        {
            // createCPIPRXErrorResponseDTO.setIsSuccess("false");
            // createCPIPRXErrorResponseDTO.setErrorCode("106");
            // createCPIPRXErrorResponseDTO.setErrorDescription("Please Enter Request Date");
            // createCPIPRXErrorResponseDTO.setData(null);
            // createCPIPRXErrorResponseDTO.setResponse(null);
            // CreateCPIPRXResponseDTO createCPIPRXErrorResponseDTO=CreateCPIPRXResponseDTO.builder()
            //                                                                             .isSuccess("false")
            //                                                                             .errorCode("107")
            //                                                                             .errorDescription("Please Enter Request Date")
            //                                                                             .data(null)
            //                                                                             .response(null)
            //                                                                             .build();               
            // return createCPIPRXErrorResponseDTO;  
            throw new MontajiEmptyRequestDateException();
        }        
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

        String requestNumber=IdGenerator.generateUniqueId2("CPIP");
        String requestNumber2=idGenerator2.generateRequestNo("CPIP");
        String requestNumber3=idGenerator3.generateRequestNo("CPIP");

        RequestCPIP requestCPIP = new RequestCPIPBuilder()
                                            .setRequestNumber(requestNumber3)
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
        int noOfContainers=createCPIPRXRequestDTO.getContainers().size();
        requestCPIP.setNoOfContainers(noOfContainers);

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
                                            //.productsCount(containerDTO.getProductsCount())
                                            .containerTotalWeight(containerDTO.getContainerTotalWeight())
                                            .requestCPIP(requestCPIP)
                                            .build();
            
            int noOfProducts=containerDTO.getProducts().size();
            container.setNoOfProducts(noOfProducts);

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
                                                                        //.noOfBatches(productDTO.getNoOfBatches())
                                                                        .productTotalQuantity(productDTO.getProductTotalQuantity())
                                                                        .productUnitWeight(productDTO.getProductUnitWeight())
                                                                        .productTotalWeight(productDTO.getProductTotalWeight())
                                                                        .container(container)
                                                                        .build();

                    int noOfBatches=productDTO.getBatches().size();
                    containerProduct.setNoOfBatches(noOfBatches);

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

        // int consignmentProductCount=containerList.;
        // requestCPIP.setConsignmentProductCount(0);
        
        
        //containerRepository.saveAll(containerList);
        requestCPIP.setContainers(containerList);

        List<Attachment> attachmentList = new ArrayList<>();
        List<AttachmentContainerDTO> attachmentContainerDTOs=createCPIPRXRequestDTO.getAttachments();

        for(AttachmentContainerDTO attachmentContainerDTO : attachmentContainerDTOs)
        {
            List<AttachmentDTO> attachmentDTOs = attachmentContainerDTO.getAttachments();
            for(AttachmentDTO attachmentDTO : attachmentDTOs)
            { 
            
            if (attachmentDTO.getFileName() == null || attachmentDTO.getFileType() == null || attachmentDTO.getFileContent() == null) {
                throw new MontajiAttachmentValidationException("Missing required fields: fileName, fileType, fileContent");
            }
        
            // Validate file type (optional)
            if (!isValidFileType(attachmentDTO.getFileType())) {
                throw new MontajiAttachmentValidationException("Unsupported file type: " + attachmentDTO.getFileType());
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
            } catch (IOException ex) {
                //throw new IOException("Error saving attachment: " + e.getMessage());
                throw new MontajiIOException("Error saving attachment", ex);
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

        //store in oracle db
        requestCPIPRepository.save(requestCPIP);
     
        // CreateCPIPRXResponseDTO createCPIPRXResponseDTO = new CreateCPIPRXResponseDTO();
        // createCPIPRXResponseDTO.setIsSuccess("true");
        // createCPIPRXResponseDTO.setErrorCode("000");
        // createCPIPRXResponseDTO.setErrorDescription("No Error");
        // createCPIPRXResponseDTO.setData(null);

        // ResponseObjDTO response = new ResponseObjDTO();
        // response.setRequestNumber(requestNumber3);
        // response.setDtReferenceNo(requestDetailsDTO.getDtReferenceNo());
        // response.setRequestType("CPIP");
        // response.setStatus("Submitted");
        // response.setPayment(null);
        // createCPIPRXResponseDTO.setResponse(response);      
        
        ResponseObjDTO response=ResponseObjDTO.builder()
                                            .requestNumber(requestNumber3)
                                            .dtReferenceNo(requestDetailsDTO.getDtReferenceNo())
                                            .requestType("CPIP")
                                            .status("Submitted")
                                            .payment(null)
                                            .build();
        

        CreateCPIPRXResponseDTO createCPIPRXResponseDTO=CreateCPIPRXResponseDTO.builder()
                                                                                .isSuccess("true")
                                                                                .errorCode("000")
                                                                                .errorDescription("No Error")
                                                                                .data(null)
                                                                                .response(response)
                                                                                .build();

        System.out.println("End of MontajiServiceImpl");

        return createCPIPRXResponseDTO;        
    }
    private boolean isValidFileType(String fileType) {
        return fileType.equals("image/png") || fileType.equals("image/jpeg") 
        || fileType.equals("application/jpeg") || fileType.equals("application/pdf")
        || fileType.equals("file/plain") || fileType.equals("file/json");
    }    

    @Override
    @Transactional
    public CreateCPIPRXResponseDTO createCPIPRXMongo(CreateCPIPRXRequestDTO createCPIPRXRequestDTO)
    {

        //map request dto to request entity
        CreateCPIPRXRequest createCPIPRXRequest = createCPIPRXRequestMapper2.mapToEntity(createCPIPRXRequestDTO);
        
        //store request in mongo db
        createCPIPRXRequestRepository.save(createCPIPRXRequest);       
        
        CreateCPIPRXResponse createCPIPRXResponse = new CreateCPIPRXResponse();
        createCPIPRXResponse.setIsSuccess("true");
        createCPIPRXResponse.setErrorCode("000");
        createCPIPRXResponse.setErrorDescription("No Error");
        createCPIPRXResponse.setData(null);
        ResponseObj response = new ResponseObj();
        response.setRequestNumber("CPIP-1000");
        response.setDtReferenceNo("DTREF1000");
        createCPIPRXResponse.setResponse(response);
        
        //store response in mongo db
        createCPIPRXResponseRepository.save(createCPIPRXResponse);     

        //map response entity to response dto
        CreateCPIPRXResponseDTO createCPIPRXResponseDTO=createCPIPRXResponseMapper2.mapToDTO(createCPIPRXResponse);
        //CreateCPIPRXResponseDTO createCPIPRXResponseDTO = CreateCPIPRXResponseMapper2.INSTANCE.mapToDTO(createCPIPRXResponse);


        return createCPIPRXResponseDTO;           
    }

}
