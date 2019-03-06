package org.wecancodeit.moviereviewssite;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String imageUrl;
	@ManyToOne
	private Genre genre;
	@Lob
	private String content;
	private String year;
	private String author;
	@ManyToMany
	private Collection<Tag> tags;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Genre getGenre() {
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

	public Collection<Tag> getTags() {
		return tags;
	}

	protected Review() {
	}

	public Review(String title, String imageUrl, String content, String year, String author, Genre genre, Tag... tags) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.content = content;
		this.year = year;
		this.author = author;
		this.genre = genre;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
