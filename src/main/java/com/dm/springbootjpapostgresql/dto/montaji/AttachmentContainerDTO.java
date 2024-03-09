package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class AttachmentContainerDTO {
    public String attachmentType;
    public ArrayList<AttachmentDTO> attachments;

}