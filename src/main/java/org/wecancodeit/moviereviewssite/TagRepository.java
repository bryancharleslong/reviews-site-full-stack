package org.wecancodeit.moviereviewssite;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Optional<Tag> findByName(String string);

}
