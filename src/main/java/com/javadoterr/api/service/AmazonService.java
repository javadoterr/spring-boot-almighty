package com.javadoterr.api.service;

import org.springframework.web.multipart.MultipartFile;

import com.javadoterr.api.model.User;

public interface AmazonService {
	
	public String uploadFile(MultipartFile file, User user);

}
