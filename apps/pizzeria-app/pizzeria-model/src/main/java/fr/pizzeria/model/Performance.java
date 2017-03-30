package fr.pizzeria.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "service", nullable = false)
	private String service;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "tempsExecution")
	private long tempsExecution;

	public Performance(String service, Date date, long tempsExecution) {
		super();
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	public Performance() {
		// for my dear JPA
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
