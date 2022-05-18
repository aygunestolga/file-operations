package com.aygunestolga.fileoperations.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aygunestolga.fileoperations.model.FileDb;

public interface IFileDbService {

	FileDb store(MultipartFile file) throws IOException;
	
	FileDb getFileById(String id);
	
	List<FileDb> getFileList();
	
	void deleteFileDb(String id);
	
}
