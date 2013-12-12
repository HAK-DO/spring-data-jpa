package com.github.dybskiy.redactor.model;

import lombok.Data;

@Data
public class RedactorImage {

	private String thumb;
	private String image;
	private String title;
	private String folder;

	@Override
	public String toString() {
		return "Image [thumb=" + thumb + ", image=" + image + ", title=" + title + ", folder=" + folder + "]";
	}
}
