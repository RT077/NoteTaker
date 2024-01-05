package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class NoteTaker {
	@Id
	private int id;
	@Column(length = 1500)
	private String title;
	@Column(length = 15000)
	private String conten;
	private Date addesDate;

	public NoteTaker() {
		super();
	}

	public NoteTaker(String title, String conten, Date addesDate) {
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.conten = conten;
		this.addesDate = addesDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConten() {
		return conten;
	}

	public void setConten(String conten) {
		this.conten = conten;
	}

	public Date getAddesDate() {
		return addesDate;
	}

	public void setAddesDate(Date addesDate) {
		this.addesDate = addesDate;
	}

	@Override
	public String toString() {
		return "NoteTaker [id=" + id + ", title=" + title + ", conten=" + conten + ", addesDate=" + addesDate + "]";
	}

}
