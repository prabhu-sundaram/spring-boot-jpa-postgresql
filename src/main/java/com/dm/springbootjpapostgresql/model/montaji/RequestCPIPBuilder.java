package com.dm.springbootjpapostgresql.model.montaji;

import java.util.List;

public class RequestCPIPBuilder extends RequestBuilder<RequestCPIP> {

    private String consignmentPurposeId;
    private ReqPortDetails reqPortDetails;
    private List<Container> containers;
    private PreApproval preApproval;

    public RequestCPIPBuilder setConsignmentPurposeId(String consignmentPurposeId) {
        this.consignmentPurposeId = consignmentPurposeId;
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
        return requestCPIP;
    }

    @Override
    public RequestCPIP build() {
        RequestCPIP requestCPIP = buildRequest();
        requestCPIP.setConsignmentPurposeId(consignmentPurposeId);
        requestCPIP.setReqPortDetails(reqPortDetails);
        requestCPIP.setContainers(containers);
        requestCPIP.setPreApproval(preApproval);
        return requestCPIP;
    }
}
