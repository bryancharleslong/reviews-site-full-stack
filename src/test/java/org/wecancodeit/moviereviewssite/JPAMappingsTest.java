package org.wecancodeit.moviereviewssite;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private GenreRepository genreRepo;

	@Test
	public void shouldSaveAndLoadATag() {
		Tag tag = new Tag("tag name");
		tag = tagRepo.save(tag);
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Tag> result = tagRepo.findById(tagId);
		tag = result.get();
		assertThat(tag.getName(), is("tag name"));
	}

	@Test
	public void shouldSaveAndLoadAGenre() {
		Genre genre = new Genre("genre name");
		genre = genreRepo.save(genre);
		long genreId = genre.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Genre> result = genreRepo.findById(genreId);
		genre = result.get();
		assertThat(genre.getName(), is("genre name"));
	}

	@Test
	public void shouldSaveAndLoadReview() {
		Genre genre = genreRepo.save(new Genre("genre name"));
		Tag tag = tagRepo.save(new Tag("tag name"));
		Review review = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre, tag));
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTitle(), is("title"));
	}

	@Test
	public void shouldGenerateReviewId() {
		Genre genre = genreRepo.save(new Genre("genre name"));
		Tag tag = tagRepo.save(new Tag("tag name"));
		Review review = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre, tag));
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(reviewId, is(greaterThan(0L)));
	}

	@Test
	public void shouldEstablishReviewToTagsRelationship() {
		Tag tag1 = tagRepo.save(new Tag("one"));
		Tag tag2 = tagRepo.save(new Tag("two"));
		Genre genre = genreRepo.save(new Genre("genre name"));

		Review review = new Review("title", "imageUrl", "content", "year", "author", genre, tag1, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTags(), containsInAnyOrder(tag1, tag2));
	}

	@Test
	public void shouldEstablishReviewToGenreRelationship() {
		Genre genre = genreRepo.save(new Genre("genre name"));
		Review review = new Review("title", "imageUrl", "content", "year", "author", genre);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getGenre(), is(genre));
	}
	
	@Test
	public void shouldFindTagByName() {
		Tag tag1 = tagRepo.save(new Tag("one"));
		entityManager.flush();
		entityManager.clear();
		Optional<Tag> result = tagRepo.findByName("one");
		tag1 = result.get();
		assertThat(tag1.getName(),is("one"));
	}

	@Test
	public void shouldFindReviewsForTag() {
		Tag tag1 = tagRepo.save(new Tag("one"));
		Tag tag2 = tagRepo.save(new Tag("two"));
		Genre genre = genreRepo.save(new Genre("genre name"));
		Review review1 = new Review("title", "imageUrl", "content", "year", "author", genre, tag1, tag2);
		Review review2 = new Review("title", "imageUrl", "content", "year", "author", genre, tag1);
		reviewRepo.save(review1);
		reviewRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		Collection<Review> reviewsForTag = reviewRepo.findByTagsContains(tag1);
		assertThat(reviewsForTag, containsInAnyOrder(review1, review2));
	}
	@Test
	public void shouldFindReviewsForTagName() {
		Tag tag1 = tagRepo.save(new Tag("one"));
		Tag tag2 = tagRepo.save(new Tag("two"));
		Genre genre = genreRepo.save(new Genre("genre name"));
		Review review1 = new Review("title", "imageUrl", "content", "year", "author", genre, tag1, tag2);
		Review review2 = new Review("title", "imageUrl", "content", "year", "author", genre, tag1);
		reviewRepo.save(review1);
		reviewRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		Collection<Review> reviewsForTag = reviewRepo.findByTagsName("one");
		assertThat(reviewsForTag, containsInAnyOrder(review1, review2));
	}

	@Test
	public void shouldFindReviewsForGenre() {
		Genre genre1 = genreRepo.save(new Genre("genre one"));
		Genre genre2 = genreRepo.save(new Genre("genre two"));
		Review review1 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre1));
		Review review2 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre1));
		Review review3 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre2));

		entityManager.flush();
		entityManager.clear();
		
		Collection<Review> reviewsForGenre = reviewRepo.findByGenre(genre1);
		assertThat(reviewsForGenre,containsInAnyOrder(review1, review2));
		assertThat(reviewsForGenre, not(hasItem(review3)));
		
	}
	@Test
	public void shouldFindReviewsForGenreId() {
		Genre genre1 = genreRepo.save(new Genre("genre one"));
		Genre genre2 = genreRepo.save(new Genre("genre two"));
		Review review1 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre1));
		Review review2 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre1));
		Review review3 = reviewRepo.save(new Review("title", "imageUrl", "content", "year", "author", genre2));
		long genre1Id = genre1.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Collection<Review> reviewsForGenre = reviewRepo.findByGenreId(genre1Id);
		assertThat(reviewsForGenre,containsInAnyOrder(review1, review2));
		assertThat(reviewsForGenre, not(hasItem(review3)));
	}

}
