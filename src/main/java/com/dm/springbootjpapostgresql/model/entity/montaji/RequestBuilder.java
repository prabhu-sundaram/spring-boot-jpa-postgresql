package com.dm.springbootjpapostgresql.model.entity.montaji;

import java.time.LocalDateTime;
import java.util.List;

public abstract class RequestBuilder<T extends Request> {

    protected String requestNumber;
    protected String requestSource;
    protected String requestType;
    protected LocalDateTime requestDate;
    protected LocalDateTime creationDate;
    protected String requestStatus;
    protected String dtReferenceNo;
    protected List<Attachment> attachments;
    protected CompanyDetails companyDetails;
    protected User user;
    public Object setUser;

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

    public RequestBuilder<T> setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    public RequestBuilder<T> setCreationDate(LocalDateTime creationDate) {
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

    public RequestBuilder<T> setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }    

    public RequestBuilder<T> setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
        return this;
    }

    public RequestBuilder<T> setUser(User user) {
        this.user = user;
        return this;
    }    

    public T buildRequest() {
        T request = doBuild();
        request.setRequestNumber(requestNumber);
        return request;
    }

    protected abstract T doBuild();
}
