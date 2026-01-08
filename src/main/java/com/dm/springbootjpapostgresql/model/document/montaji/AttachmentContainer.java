package com.dm.springbootjpapostgresql.model.document.montaji;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class AttachmentContainer {
    private String attachmentType;
    private ArrayList<Attachment> attachments;

}