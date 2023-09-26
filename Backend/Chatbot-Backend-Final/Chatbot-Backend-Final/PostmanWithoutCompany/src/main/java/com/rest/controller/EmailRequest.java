package com.rest.controller;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {
	private String remail;
	private MultipartFile file;
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public EmailRequest(String remail, MultipartFile file) {
		super();
		this.remail = remail;
		this.file = file;
	}
	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}