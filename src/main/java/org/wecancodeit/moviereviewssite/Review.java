package org.wecancodeit.moviereviewssite;

import java.util.List;

public class Review {

	private Long id;
	private String title;
	private String imageUrl;
	private String genre;
	private String content;
	private String year;
	private String author;
	private List<String> tags;

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	

	public String getGenre() {
		return genre;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public Review(Long id, String title, String imageUrl, String genre, String content, String year,
			String author, List<String> tags) {
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.genre = genre;
		this.content = content;
		this.year = year;
		this.author = author;
		this.tags = tags;
	}


}
