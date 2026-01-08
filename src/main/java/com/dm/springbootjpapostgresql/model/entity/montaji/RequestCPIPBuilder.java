package com.dm.springbootjpapostgresql.model.entity.montaji;

import java.util.List;

public class RequestCPIPBuilder extends RequestBuilder<RequestCPIP> {

    private String consignmentPurposeId;
    private int noOfContainers;
    private int noOfContainers2;
    private int productCount;
    private ReqPortDetails reqPortDetails;
    private List<Container> containers;
    private PreApproval preApproval;

    public RequestCPIPBuilder setConsignmentPurposeId(String consignmentPurposeId) {
        this.consignmentPurposeId = consignmentPurposeId;
        return this;
    }

    public RequestCPIPBuilder setNoOfContainers(int noOfContainers) {
        this.noOfContainers = noOfContainers;
        return this;
    }    

    public RequestCPIPBuilder setNoOfContainers2(int noOfContainers2) {
        this.noOfContainers2 = noOfContainers2;
        return this;
    }  

    public RequestCPIPBuilder setProductCount(int productCount) {
        this.productCount = productCount;
        return this;
    }      

    public RequestCPIPBuilder setReqPortDetails(ReqPortDetails reqPortDetails) {
        this.reqPortDetails = reqPortDetails;
        return this;
    }

    public RequestCPIPBuilder setContainers(List<Container> containers) {
        this.containers = containers;
        return this;
    }

    public RequestCPIPBuilder setPreApproval(PreApproval preApproval) {
        this.preApproval = preApproval;
        return this;
    }

    @Override
    protected RequestCPIP doBuild() {
        RequestCPIP requestCPIP = new RequestCPIP();
        requestCPIP.setRequestSource(requestSource);
        requestCPIP.setRequestType(requestType);
        requestCPIP.setRequestDate(requestDate);
        requestCPIP.setCreationDate(creationDate);
        requestCPIP.setRequestStatus(requestStatus);
        requestCPIP.setDtReferenceNo(dtReferenceNo);
        requestCPIP.setCompanyDetails(companyDetails);
        requestCPIP.setUser(user);
        return requestCPIP;
    }

    @Override
    public RequestCPIP build() {
        RequestCPIP requestCPIP = buildRequest();
        requestCPIP.setConsignmentPurposeId(consignmentPurposeId);
        requestCPIP.setNoOfContainers(noOfContainers);
        requestCPIP.setNoOfContainers2(noOfContainers2);
        requestCPIP.setProductCount(productCount);
        requestCPIP.setReqPortDetails(reqPortDetails);
        requestCPIP.setContainers(containers);
        requestCPIP.setPreApproval(preApproval);
        return requestCPIP;
    }
}
