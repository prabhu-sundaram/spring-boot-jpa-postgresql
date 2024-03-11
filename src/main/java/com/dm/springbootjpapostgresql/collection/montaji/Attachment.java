package com.dm.springbootjpapostgresql.collection.montaji;

import java.util.Date;

import lombok.Setter;

@Setter
public class Attachment {
    private String fileName;
    private String fileType;
    private Date uploadedTimeStamp;
    private String attachmentRefNo;    
}
