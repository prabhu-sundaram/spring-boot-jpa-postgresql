package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Getter;

@Getter
public class AttachmentDTO {
    public String fileName;
    public String fileType;
    public Date uploadedTimeStamp;
    public String attachmentRefNo;    
}
