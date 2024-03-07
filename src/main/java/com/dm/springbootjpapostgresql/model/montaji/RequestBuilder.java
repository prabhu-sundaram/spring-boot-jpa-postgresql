package com.dm.springbootjpapostgresql.model.montaji;

import java.util.Date;

public abstract class RequestBuilder<T extends Request> {

    protected String requestNumber;
    protected String requestSource;
    protected String requestType;
    protected Date requestDate;
    protected Date creationDate;
    protected String requestStatus;
    protected String dtReferenceNo;
    protected CompanyDetails companyDetails;

    public abstract T build();

    public RequestBuilder<T> setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
        return this;
    }

    public RequestBuilder<T> setRequestSource(String requestSource) {
        this.requestSource = requestSource;
        return this;
    }

    public RequestBuilder<T> setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public RequestBuilder<T> setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    public RequestBuilder<T> setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public RequestBuilder<T> setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
        return this;
    }

    public RequestBuilder<T> setDtReferenceNo(String dtReferenceNo) {
        this.dtReferenceNo = dtReferenceNo;
        return this;
    }

    public RequestBuilder<T> setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
        return this;
    }

    public T buildRequest() {
        T request = doBuild();
        request.setRequestNumber(requestNumber);
        return request;
    }

    protected abstract T doBuild();
}
