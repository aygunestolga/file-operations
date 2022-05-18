package com.aygunestolga.fileoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aygunestolga.fileoperations.model.FileDb;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String> {

	
	
}
