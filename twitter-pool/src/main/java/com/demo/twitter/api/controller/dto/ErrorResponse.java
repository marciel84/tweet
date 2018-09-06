package com.demo.twitter.api.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.demo.twitter.api.controller.enums.ErrorType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Tipo dpo erro")
	private ErrorType errorType;
	
	@ApiModelProperty(value="Motivo do erro")
	private List<String> reason;

	public ErrorResponse(ErrorType errorType, List<String> reason) {
		super();
		this.errorType = errorType;
		this.reason = reason;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public List<String> getReason() {
		return reason;
	}
	public void setReason(List<String> reason) {
		this.reason = reason;
	}
}
