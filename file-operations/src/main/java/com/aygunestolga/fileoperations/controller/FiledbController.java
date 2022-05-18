package com.aygunestolga.fileoperations.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aygunestolga.fileoperations.model.FileDb;
import com.aygunestolga.fileoperations.service.FileDbService;

@RestController
@RequestMapping("file")
public class FiledbController {
	
	@Autowired
	private FileDbService fileDbService;
	
	@PostMapping
	public FileDb uploadFile(@RequestParam ("file") MultipartFile file) throws IOException {
		return fileDbService.store(file);
	}
	
	@GetMapping("/{id}")
	public FileDb getFile(@PathVariable String id) {
		return fileDbService.getFileById(id);
	}
	
	@GetMapping("/list")
	public List<FileDb> getFileList(){
		return fileDbService.getFileList();
	}

}
