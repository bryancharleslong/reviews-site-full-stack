package org.wecancodeit.moviereviewssite;

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

	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value = "id") Long id, Model model) {
		Optional<Review> review = reviewRepo.findById(id);
		if (review.isPresent()) {
			model.addAttribute("review", review.get());
		}
		return "review";
	}

	@RequestMapping("/show-tag")
	public String findAllReviewWithTag(@RequestParam(value = "tag") String tag, Model model) {
		model.addAttribute("reviews", reviewRepo.findByTagsName(tag));
		return "tagReviews";
	}

	@GetMapping("/")
	public String getReviews() {
		return "redirect:/show-reviews";
	}
}
