package br.com.supplyme.SuppleMe.model;

import javax.persistence.Entity;

@Entity
public class Images {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
