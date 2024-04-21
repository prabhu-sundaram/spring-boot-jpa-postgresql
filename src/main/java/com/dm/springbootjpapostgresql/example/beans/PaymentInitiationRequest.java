//-----------------------------------ae.gov.dm.PaymentGateway.dao.PaymentInitiationRequest.java-----------------------------------

package com.dm.springbootjpapostgresql.example.beans;

import java.util.List;

public class PaymentInitiationRequest {

private String channel;
private String reqTimeStamp;
private String paymentGatewayCode;
private String paymentcallbackurl;
private List<String> paymentVoucherDtl = null;
private String payeeName;
private String payeeMobile;
private String payeeemail;

public String getChannel() {
return channel;
}

public void setChannel(String channel) {
this.channel = channel;
}

public String getReqTimeStamp() {
return reqTimeStamp;
}

public void setReqTimeStamp(String reqTimeStamp) {
this.reqTimeStamp = reqTimeStamp;
}

public String getPaymentGatewayCode() {
return paymentGatewayCode;
}

public void setPaymentGatewayCode(String paymentGatewayCode) {
this.paymentGatewayCode = paymentGatewayCode;
}

public String getPaymentcallbackurl() {
return paymentcallbackurl;
}

public void setPaymentcallbackurl(String paymentcallbackurl) {
this.paymentcallbackurl = paymentcallbackurl;
}

public List<String> getPaymentVoucherDtl() {
return paymentVoucherDtl;
}

public void setPaymentVoucherDtl(List<String> paymentVoucherDtl) {
this.paymentVoucherDtl = paymentVoucherDtl;
}

public String getPayeeName() {
return payeeName;
}

public void setPayeeName(String payeeName) {
this.payeeName = payeeName;
}

public String getPayeeMobile() {
return payeeMobile;
}

public void setPayeeMobile(String payeeMobile) {
this.payeeMobile = payeeMobile;
}

public String getPayeeemail() {
return payeeemail;
}

public void setPayeeemail(String payeeemail) {
this.payeeemail = payeeemail;
}

}