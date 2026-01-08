package com.dm.springbootjpapostgresql.service;

import org.springframework.web.multipart.MultipartFile;

import com.dm.springbootjpapostgresql.model.document.Photo;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}