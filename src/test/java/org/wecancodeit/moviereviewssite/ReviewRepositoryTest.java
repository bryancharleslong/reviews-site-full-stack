package org.wecancodeit.moviereviewssite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;


public class ReviewRepositoryTest {

	ReviewRepository underTest;
	Long firstReviewId = 1L;
	List<String> tagsOne = Arrays.asList("color", "fantasy", "PG-13");
	private Review firstReview = new Review(firstReviewId, "firstTitle", "firstImageUrl", "firstCategory",
			"firstContent", "firstDate", "firstSynopsis", tagsOne);
	Long secondReviewId = 2L;
	List<String> tagsTwo = Arrays.asList("black and white", "PG");
	private Review secondReview = new Review(secondReviewId, "secondTitle", "secondImageUrl", "secondCategory",
			"secondContent", "secondDate", "secondSynopsis", tagsTwo);

	@Test
	public void shouldFindAReview() {
		underTest = new ReviewRepository(firstReview);
		Review result = underTest.findOne(firstReviewId);
		assertThat(result, is(firstReview));
	}
	
	@Test
	public void shouldFindASecondReview() {
		underTest = new ReviewRepository(secondReview);
		Review result = underTest.findOne(secondReviewId);
		assertThat(result, is(secondReview));
	}
	
	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(firstReview, secondReview);
		Collection<Review> result = underTest.findAll();
		assertThat(result, containsInAnyOrder(firstReview, secondReview));
	}
	
	@Test
	public void shouldFindReviewWithTag() {
		underTest = new ReviewRepository(firstReview, secondReview);
		Collection<Review> result = underTest.findAllWithTag("color");
		System.out.println(result);
		assertThat(result, contains(firstReview));
		assertThat(result, not(contains(secondReview)));
	}

}
