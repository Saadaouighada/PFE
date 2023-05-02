package com.linedata.project.management.std.model;

public class GitRepositoryInfo {

	String username;
	String password;
	String url;
	String localRepository;

	public GitRepositoryInfo(String username, String password, String url, String localRepository) {
		super();
		this.username = username;
		this.password = password;
		this.url = url;
		this.localRepository = localRepository;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocalRepository() {
		return localRepository;
	}

	public void setLocalRepository(String localRepository) {
		this.localRepository = localRepository;
	}

}
