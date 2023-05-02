package com.linedata.project.management.std.model;

public class JiraLabel {
	private Long id;
	private Long numJira;
	private String message;
	private String etiquette;

	public Long getNumJira() {
		return numJira;
	}

	public void setNumJira(Long numJira) {
		this.numJira = numJira;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
