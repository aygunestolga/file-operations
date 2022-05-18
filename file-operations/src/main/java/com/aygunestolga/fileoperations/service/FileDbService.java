package com.aygunestolga.fileoperations.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aygunestolga.fileoperations.model.FileDb;
import com.aygunestolga.fileoperations.repository.FileDbRepository;
import com.aygunestolga.fileoperations.utils.FileDbUtils;

@Service
public class FileDbService implements IFileDbService{

	@Autowired
	private FileDbRepository fileDbRepository;
	
	@Override
	public FileDb store(MultipartFile file) throws IOException {
		

		String fileName = file.getOriginalFilename();
		FileDb fileDb = new FileDb(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());
		
		String type = "png";
		if(FileDbUtils.validateType(type)) {
			/*
			 * işlemler
			 */
		}else {
			
		}
		
		return fileDbRepository.save(fileDb);
		
	}
	
	@Override
	public FileDb getFileById(String id) {
		
		Optional<FileDb> fileOptional = fileDbRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}
	
	@Override
	public List<FileDb> getFileList(){
		return fileDbRepository.findAll();
	}

	@Override
	public void deleteFileDb(String id) {
		fileDbRepository.deleteById(id);
		
	}
	
	
}
