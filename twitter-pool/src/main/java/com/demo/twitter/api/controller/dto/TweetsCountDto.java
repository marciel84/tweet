package com.demo.twitter.api.controller.dto;

public class TweetsCountDto {
	
	private String dataHora;
	private int total;
	
	public TweetsCountDto(String dataHora, int total) {
		super();
		this.dataHora = dataHora;
		this.total = total;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	

}
