package org.wecancodeit.moviereviewssite;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewRest{
	
	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Resource
	private GenreRepository genreRepo;
	
	@GetMapping("/restReviews")
	public Collection<String> getReviews(){
		Collection<Review> reviews = reviewRepo.findAllByOrderByTitleAsc();
		ArrayList<String> titles = new ArrayList<String>();
		for(Review review: reviews) {
			titles.add(review.getTitle());
		}
		return (Collection<String>)titles;
	}
	
	@PostMapping("/restReviews")
	public Collection <String> newReview(@RequestBody String newTitle){
		
		Genre newGenre = new Genre("new");
		genreRepo.save(newGenre);
		Review newReview = new Review(newTitle, "imageUrl", "content", "year", "author", newGenre);
		reviewRepo.save(newReview);
		
		Collection<Review> reviews = reviewRepo.findAllByOrderByTitleAsc();
		ArrayList<String> titles = new ArrayList<String>();
		for(Review review: reviews) {
			titles.add(review.getTitle());
		}
		return (Collection<String>)titles;
	}
	
}