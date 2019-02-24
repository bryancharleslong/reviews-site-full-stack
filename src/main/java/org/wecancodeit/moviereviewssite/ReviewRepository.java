package org.wecancodeit.moviereviewssite;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	Collection<Review> findByTagsContains(Tag tag);

	Collection<Review> findByGenre(Genre genre);

	Collection<Review> findByTagsName(String string);
	
}
