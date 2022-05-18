package com.aygunestolga.fileoperations.utils;

public class FileDbUtils {

	public static boolean validateType(String type) {
		// burada gelen dosyanın tipinin kontrolü yapılacak
		if (type != "png" || type != "jpeg") {
			/*
			 * eğer ki buraya girerse işlemler!
			 *
			 */
			return false;
		} else {
			return true;
		}

	}

	public static boolean validateSize() {
		// burada gelen dosyanın tipinin kontrolü yapılacak
		return true;
	}

}
