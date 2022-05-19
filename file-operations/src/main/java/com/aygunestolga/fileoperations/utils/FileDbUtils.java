package com.aygunestolga.fileoperations.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public class FileDbUtils {

	public static boolean removeDirectoryRecursive(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					if (!removeDirectoryRecursive(files[i]))
						return false;
				} else {
					if (!files[i].delete())
						return false;
				}
			}
			directory.delete();
		}
		return true;
	}

	public static byte[] getFile(String filePath) {
		File file = new File(filePath);
		if (file.exists())
			try {
				return Files.readAllBytes(file.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		return new byte[] {};
	}

	public static File saveFile(String fileName, byte[] fileContent) {
		File file = new File(fileName);
		removeFileIfExists(file);
		try {
			file.createNewFile();
			Runtime.getRuntime().exec("chmod 777 "
					+ file.getPath());
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(fileContent);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return file;
	}

	public static boolean removeFileIfExists(String fileName) {
		File file = new File(fileName);
		return removeFileIfExists(file);
	}

	public static boolean removeFileIfExists(File file) {
		if (file.exists())
			return file.delete();
		return false;
	}


}
