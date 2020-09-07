package com.example.asus.graduationproject.JavaBean;

import java.util.List;
import java.util.Map;

public class Sickness {
	private String category;
	private List<String> sicknesses;
	private List<ExamData> item;
	private Map<String, String> guidence;
	public String getCategory() {
		return category;
	}
	public List<String> getSicknesses() {
		return sicknesses;
	}
	public void setSicknesses(List<String> sicknesses) {
		this.sicknesses = sicknesses;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<ExamData> getItem() {
		return item;
	}
	public void setItem(List<ExamData> item) {
		this.item = item;
	}

	public Map<String, String> getGuidence() {
		return guidence;
	}

	public void setGuidence(Map<String, String> guidence) {
		this.guidence = guidence;
	}
}
