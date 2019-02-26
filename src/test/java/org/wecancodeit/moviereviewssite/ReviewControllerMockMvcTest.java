package org.wecancodeit.moviereviewssite;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	
	@Mock
	private Tag firstTag;
	
	@Mock
	private Tag secondTag;
	
	@Mock
	private Genre firstGenre;
	
	@Mock
	private Genre secondGenre;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private TagRepository tagRepo;
	
	@MockBean
	private GenreRepository genreRepo;
	
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
		when(reviewRepo.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	@Test
	public void shouldNotBeOkForOneReview() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldBeOkForOneReview() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(firstReview));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleReviewView() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(firstReview));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldPutASingleReviewIntoModel() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(firstReview));
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("review", is(firstReview)));
	}
	
	@Test
	public void shouldNotBeOkForTag() throws Exception {
		mvc.perform(get("/tag?tag=name")).andExpect(status().isNotFound());
	}
	
	@Test 
	public void shouldBeOkForOneTag() throws Exception{
		when(tagRepo.findByName("name")).thenReturn(Optional.of(firstTag));
		when(reviewRepo.findByTagsName("name")).thenReturn(asList( firstReview,secondReview));
		mvc.perform(get("/tag?tag=name")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleTagView() throws Exception {
		when(tagRepo.findByName("name")).thenReturn(Optional.of(firstTag));
		Collection<Review> reviewsWithTag = asList( firstReview,secondReview);
		when(reviewRepo.findByTagsName("name")).thenReturn(reviewsWithTag);
		mvc.perform(get("/tag?tag=name")).andExpect(view().name(is("tag")));
	}
	
	@Test
	public void shouldPutReviewsWithTagIntoModel() throws Exception {
		when(tagRepo.findByName("name")).thenReturn(Optional.of(firstTag));
		Collection<Review> reviewsWithTag = asList( firstReview,secondReview);
		when(reviewRepo.findByTagsName("name")).thenReturn(reviewsWithTag);
		mvc.perform(get("/tag?tag=name")).andExpect(model().attribute("reviews", is(reviewsWithTag)));
	}
	
	@Test
	public void shouldBeOkForAllTags() throws Exception {
		mvc.perform(get("/show-tags")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToAllTagsView() throws Exception {
		mvc.perform(get("/show-tags")).andExpect(view().name(is("tags")));
	}
	
	@Test
	public void shouldPutAllTagsIntoModel() throws Exception {
		Collection<Tag> allTags = asList(firstTag, secondTag);
		when(tagRepo.findAll()).thenReturn(allTags);
		mvc.perform(get("/show-tags")).andExpect(model().attribute("tags", is(allTags)));
	}
	
	@Test
	public void shouldBeOkForAllGenres() throws Exception {
		mvc.perform(get("/show-genres")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToAllGenresView() throws Exception {
		mvc.perform(get("/show-genres")).andExpect(view().name(is("genres")));
	}
	
	@Test
	public void shouldPutAllGenresIntoModel() throws Exception {
		Collection<Genre> allGenres = asList(firstGenre, secondGenre);
		when(genreRepo.findAll()).thenReturn(allGenres);
		mvc.perform(get("/show-genres")).andExpect(model().attribute("genres", is(allGenres)));
	}
	
	@Test
	public void shouldNotBeOkForSingleGenre() throws Exception {
		mvc.perform(get("/genre?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldBeOkForSingleGenre() throws Exception {
		when(genreRepo.findById(1L)).thenReturn(Optional.of(firstGenre));
		mvc.perform(get("/genre?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleGenreView() throws Exception {
		when(genreRepo.findById(1L)).thenReturn(Optional.of(firstGenre));
		Collection<Review> reviewsWithGenre = asList( firstReview,secondReview);
		when(reviewRepo.findByGenre(firstGenre)).thenReturn(reviewsWithGenre);
		mvc.perform(get("/genre?id=1")).andExpect(view().name(is("genre")));
	}
	
	@Test
	public void shouldAddReviewsWithGenreToModel() throws Exception {
		when(genreRepo.findById(1L)).thenReturn(Optional.of(firstGenre));
		Collection<Review> reviewsWithGenre = asList( firstReview,secondReview);
		when(reviewRepo.findByGenre(firstGenre)).thenReturn(reviewsWithGenre);
		mvc.perform(get("/genre?id=1")).andExpect(model().attribute("reviews", is(reviewsWithGenre)));
	}

}
