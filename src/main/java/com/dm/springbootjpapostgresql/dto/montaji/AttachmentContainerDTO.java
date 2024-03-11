package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class AttachmentContainerDTO {
    private String attachmentType;
    private ArrayList<AttachmentDTO> attachments;

}