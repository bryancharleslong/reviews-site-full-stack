package org.wecancodeit.moviereviewssite;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	GenreRepository genreRepo;

	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value = "id") long id, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(id);
		if (review.isPresent()) {
			model.addAttribute("review", review.get());
			return "review";
		}
		throw new ReviewNotFoundException();
	}

	@RequestMapping("/show-tags")
	public String findAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tag")
	public String findAllReviewWithTag(@RequestParam(value = "tag") String tagName, Model model)
			throws TagNotFoundException {
		Optional<Tag> tag = tagRepo.findByName(tagName);
		if (tag.isPresent()) {
			Collection<Review> reviewsWithTag = reviewRepo.findByTagsName(tagName);
			model.addAttribute("reviews", reviewsWithTag);
			return "tag";
		}
		throw new TagNotFoundException();
	}

	@RequestMapping("/show-genres")
	public String findAllGenres(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "genres";
	}

	@RequestMapping("/genre")
	public String findOneGenre(@RequestParam(value = "id") long id, Model model) throws GenreNotFoundException {
		Optional<Genre> genre = genreRepo.findById(id);
		if (genre.isPresent()) {
			Collection<Review> reviewsWithGenre = reviewRepo.findByGenre(genre.get());
			model.addAttribute("reviews", reviewsWithGenre);
			return "genre";
		}
		throw new GenreNotFoundException();
	}

	@GetMapping("/")
	public String getReviews() {
		return "redirect:/show-reviews";
	}
}
