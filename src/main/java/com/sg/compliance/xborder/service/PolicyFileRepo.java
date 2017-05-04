package com.sg.compliance.xborder.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by narisp on 4/28/17.
 */
@Component
public class PolicyFileRepo {

	public void saveFile(Long id, MultipartFile file) {
		Path path = Paths.get(getAbsoluteFilePath(id, file.getOriginalFilename()));
		try {
			Files.write(path, file.getBytes());
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public byte[] getFile(Long id, String originalFilename) {
		Path path = Paths.get(getAbsoluteFilePath(id, originalFilename));
		try {
			return Files.readAllBytes(path);
		} catch (IOException io) {
			io.printStackTrace();
			return null;
		}
	}

	private String getAbsoluteFilePath(Long id, String originalFileName) {
		String fileStoreDirectory = System.getProperty("user.home") + File.separator + "xborder-file-store";
		createFolder(fileStoreDirectory);
		return fileStoreDirectory + File.separator + id + "_" + originalFileName;
	}

	private void createFolder(String fileStoreDirectory) {
		Path folder = Paths.get(fileStoreDirectory);
		if (!Files.exists(folder)) {
			try {
				Files.createDirectories(folder);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
