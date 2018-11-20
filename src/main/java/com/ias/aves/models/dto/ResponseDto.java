package com.ias.aves.models.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {
	
	private boolean status;
	private String menssage;
	
	public ResponseDto() {
		super();
	}
	
	public ResponseDto(boolean status, String menssage) {
		super();
		this.status = status;
		this.menssage = menssage;
	}

	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMenssage() {
		return menssage;
	}
	
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	private static final long serialVersionUID = 1L;	
}
