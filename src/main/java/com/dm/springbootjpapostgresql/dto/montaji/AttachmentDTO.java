package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.Date;

import lombok.Getter;

@Getter
public class AttachmentDTO {
    private String fileName;
    private String fileType;
    //private Date uploadedTimeStamp;
    //private String attachmentRefNo;    
    private String fileContent;
}
