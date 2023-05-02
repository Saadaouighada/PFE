package org.primefaces.showcase.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.linedata.project.management.std.model.JiraLabel;

public class Theme {
	Log log=LogFactory.getLog(Theme.class);
	private int id;
	private String displayName;
	private String name;
	private String url;
	private String displayNameFull;
	private String filePath;
	private Date dateDeb;
	private Date dateFin;
	private boolean ficheExclus;
	private List<JiraLabel> selectedLabels;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Theme() {
	}

	public Theme(int id, String displayName, String name, String url) {
		this.id = id;
		this.displayName = displayName;
		this.name = name;
		this.url = url;
		if (displayName != null && name!=null) {
			this.displayNameFull= displayName.concat(" - ").concat(name);
		} 
		log.info("Theme.Theme()xxxxxxxxxxxxxxxxxxxxxxx  displayName="+this.displayName+"   name="+this.name+"displayNameFull="+this.displayNameFull);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		log.info("Theme.getDisplayName()" + displayName	+ "###### name=" + name);
			return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getDisplayNameFull() {
		log.info("Theme.getDisplayNameFull()" + displayName	+ "###²²²### name=" + name);
			return this.displayNameFull;
	}

	public void setDisplayNameFull(String displayNameFull) {
		this.displayNameFull = displayNameFull;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isFicheExclus() {
		return ficheExclus;
	}

	public void setFicheExclus(boolean ficheExclus) {
		this.ficheExclus = ficheExclus;
	}

	public List<JiraLabel> getSelectedLabels() {
		return selectedLabels;
	}

	public void setSelectedLabels(List<JiraLabel> selectedLabels) {
		this.selectedLabels = selectedLabels;
	}
}
