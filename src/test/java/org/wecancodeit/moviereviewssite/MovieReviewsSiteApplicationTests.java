package org.wecancodeit.moviereviewssite;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieReviewsSiteApplicationTests {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private ReviewController reviewController;

	@Test
	public void contextLoads() {
		assertThat(reviewRepo).isNotNull();
		assertThat(reviewController).isNotNull();
	}

}

