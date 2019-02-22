package org.wecancodeit.moviereviewssite;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.moviereviewssite.ReviewController;
@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review firstReview;
	
	@Mock
	private Review secondReview;
	
	@MockBean
	private ReviewRepository repository;
	
	@Test
	public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToAllReviewsView() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception {
		Collection<Review> allReviews = asList(firstReview, secondReview);
		when(repository.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	@Test
	public void shouldBeOkForOneReview() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleReviewView() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldPutASingleReviewIntoModel() throws Exception {
		when(repository.findOne(1L)).thenReturn(firstReview);
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews", is(firstReview)));
	}
	@Test
	public void shouldPutReviewsWithTagIntoModel() throws Exception {
		Collection<Review> allReviewsWithTag = asList(firstReview);
		when(repository.findAllWithTag("color")).thenReturn(allReviewsWithTag);
		mvc.perform(get("/show-tag?tag=color")).andExpect(model().attribute("reviews", is(allReviewsWithTag)));
	}

}
