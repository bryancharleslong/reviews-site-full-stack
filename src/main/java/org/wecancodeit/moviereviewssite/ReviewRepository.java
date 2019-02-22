package org.wecancodeit.moviereviewssite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	HashMap<Long, Review> reviewList = new HashMap<>();
	// (id, title, imageUrl, genre, content, year, author, tags)



	public ReviewRepository() {
		List<String> tagsOne = Arrays.asList("in color", "fantasy", "rated PG-13");
		Review one = new Review(1L, "Groundhog Day", "images/groundhog.jpg", "Comedy, Fantasy, Romance",
				"It's kind of hard to pinpoint what makes 'Groundhog Day' work just right- many movies have great premises, some even a bit more ambitious than this one (though not as heartfelt, maybe) but fail. I think that 'ratedness' may play a bigger role than people imagine. For example, this movie came out a bit before my time, and because of that I missed the trailers and stuff for when the film came out. Even so, people that were around when 'Groundhog' came out in the theatres, might've also thought it was underrated, as the title 'Groundog Day' doesn't necessarily *try* to draw in huge crowds.\r\n"
						+ "\r\n"
						+ "OK...all my above rambling means one thing: I loved 'Groundhog Day', but I'm embarrassed I didn't watch it sooner. Having the typical Generation X-er mentality I assumed this film would have outdated humour- but let me assure you (and seeing Rushmore confirmed this for me) -Bill Murray and his humour will NEVER go out of style; he is fabulous. He takes just the right amount of self-deprication (not too much) and combines it with cynicism....well I don't want to try to *define* his humour- the easiest way would be to watch him in action! Also, the writing for this film is absolutely perfect.\r\n"
						+ "\r\n"
						+ "Go see for yourselves... and hope that ONE DAY the groundhog will actually NOT see his shadow......lol",
						"1993", "renaldo and clara", tagsOne);
		List<String> tagsTwo = Arrays.asList("in color", "rated R");
		Review two = new Review(2L, "The Good, the Bad and the Ugly", "images/cowboy.jpg", "Western",
				"A sprawling Western epic that follows the adventures of three gunfighters looking for $200,000 in stolen gold, Sergio Leone's `The Good, the Bad, and the Ugly' is a masterpiece, one that continues to get better and better with each viewing. In a way, it's a morality play, weighing the consequences of good and evil, but it does so in a realistic manner. Sometimes, crime does pay, at least in the short term, and sometimes good does go unrewarded. This film probably signaled the death knell of the traditional John Wayne `White Hat/Black Hat' Western.\r\n"
						+ "\r\n"
						+ "The three main characters make the film. Lee Van Cleef (`The Bad') is evil personified. Totally ruthless, he'll do whatever it takes to get what he wants. Clint Eastwood (`The Good') is the Man With No Name, not really `good' in a traditional sense . . . but he has a certain sense of honor and tries to do the right thing. (Watch the scene when he gives a dying Confederate soldier a puff of his cigar - powerful, and it sums up everything that the Man With No Name is all about, without saying a single word.) Eli Wallach (`The Ugly') is Tuco, and he's easily the most complex - if not the best - character in the film. All impulse and rage, Tuco spins wildly throughout the movie, stealing, lying, pretending to be Clint Eastwood's best friend in one scene, trying to kill him in another - Tuco truly represents `the ugly' side of people.\r\n"
						+ "\r\n"
						+ "The movie is long, but there's not a wasted scene in the film. Each one slowly lets the film unfold with a certain style and grace, revealing more about each character and what's going on. The pacing is incredible, as is the direction - Sergio Leone manages to build a lot of uncomfortable tension in the film, keeping the film from ever getting predictable. Any typical Western cliché that you can possibly think of is either given a unique twist or utterly destroyed by Leone's masterful storytelling. Of special mention is Ennio Morricone's score, which is absolutely perfect. Two scenes - one in a Union prison camp, one in the climatic gunfight in the cemetery at the end of the film - are amazing on their own, but they become absolutely astonishing with combined with Morricone's powerful score. \r\n"
						+ "\r\n"
						+ "This movie is absolutely brilliant. If you haven't seen it yet, I strongly urge to do so. Immediately. (And then, go watch `Unforgiven' . . . in a way, I think that `Unforgiven' is the sequel to `The Good, the Bad, and the Ugly - it's the story of what eventually happened to the Man With No Name.) `The Good, the Bad, and the Ugly' is easily one of the best Westerns ever made. A++",
						"1966", "MadReviewer", tagsTwo);
		List<String> tagsThree = Arrays.asList("in color", "rated R");
		Review three = new Review(3L, "The Silence of the Lambs", "images/knife.jpg", " Crime, Drama, Thriller",
				"The Silence of the Lambs, having accomplished the rare feat of winning all five of the major Academy Award categories, is a remarkable achievement in filmmaking. Gruesome, pulpish material was transformed by dedicated participants on all levels of production, and a film that would have failed in the hands of many others wound up becoming a modern masterpiece. Taut direction and a superb screenplay might be the best arguments for the film's power, but the flashiest are certainly delivered in the bravura performances of Hopkins and Foster. Their interplay -- and remember, they only share a handful of scenes together -- is nothing short of riveting.",
				"1991", "pooch-8", tagsThree);
		List<String> tagsFour = Arrays.asList("color", "fantasy", "PG-13");
		Review four = new Review(4L, "Inception", "images/top.jpg", "Action, Adventure, Sci-Fi",
				"Inception is truly one of a kind. A concept which has long gestated in Christopher Nolan's mind, his eye for drama mixed with his large scale sensibilities ring true in Blockbuster season making Inception a true original in the sea of reboots, remakes and sequels.\r\n"
						+ "\r\n"
						+ "To try and explain Inceptions many plot twists and incredibly intelligent arcs, would be a foolish task. As Nolan himself has been reluctant to. The best way to approach the film would be with an open mind, if you are prepared to be taken on a ride of a lifetime, then trust that you 100% will. If Avatar was a seminal film in technology (although coming out as a rather poor film, in my opinion), then Inception is seminal in it's storytelling. With a 148 minute running time, you would expect a lot to take place, but what you wouldn't expect is the pace of it all. I did not think at one time in the film about how long was left. I was simply blown away by the depth in every single part of the film. If my enthusiasm for the storytelling aspect of the film has left you worried about the spectacle, then don't worry. They are, as hinted in the trailer, incredible, looking real and unbelievable simultaneously. The most pleasing thing about the action set pieces, is that they are genuinely used to illustrate the story, rather than to blow stuff up a la Michael Bay.\r\n"
						+ "\r\n"
						+ "With this complex movie in it's high concept, a stellar cast is needed. And Nolan as always, delivers with just that. This is vintage DiCaprio, perhaps only equalled in The Aviator, which is even more impressive as his role as Cobb in Inception is not a showy one, needing DiCaprio to be the constant at the centre of the film. And he pulls off Cobb's emotional contradictions sublimely. The rest of the cast members all shine in parts of the films, Cillian Murphy shows off his usually non-existent tender side, Gordon-Levitt bottles his usual charm for his confidently reserved turn as the reliable Arthur, Watanabe is devilish as the seemingly ambiguous Saito, Page shows why she's the next big female star and Tom Hardy revels in being the comic relief of the film compared to his recent turns as decidedly psychopathic characters.\r\n"
						+ "\r\n"
						+ "Overall, Nolan has indeed surpassed himself. He has created a world as expansive as his Gotham, a plot dwarfing the intricacies of Memento and one which blows The Prestige's cinematic reveal out of the water. This is truly unmissable cinema. Revel in it, we've still got to wait a whole two years before Batman 3.",
						"2010", "marcusdean118", tagsFour);
		List<String> tagsFive = Arrays.asList("in black and white", "rated PG");
		Review five = new Review(5L, "Seven Samurai", "images/castle.jpg", "Adventure, Drama",
				"Donald Richie thought it was Kurosawa's finest, and suggested that it might the best Japanese film ever made. \r\n"
						+ "\r\n"
						+ "It is a film that rewards casual viewing and careful viewing and repeated viewing and viewing over time. Isn't that rather like a wonderful book, that rewards you every time you pick it up? I suppose that is the definition of greatness. \r\n"
						+ "\r\n"
						+ "How was this greatness achieved? (This is not a rhetorical question. It truly astonishes me how this film creates meaning...cutting across all boundaries of nationality, language, and culture to become a meaningful personal experience for those who view it). This creation of greatness may be a mystery, but we can point to the some features of the film's excellence: \r\n"
						+ "\r\n"
						+ "The artistic achievement: The music, the cinematography, the extensive set design, the editing and the acting in the service of a moving story all conspire to create a world that becomes ours on a deeply personal level. It is a film which influences later films and filmmakers. \r\n"
						+ "\r\n"
						+ "The narrative achievement: Based on an original concept of Kurosawa's which began as a \"day in the life\" documentary of a samurai's existence, Kurosawa developed the idea into this breathtaking film of samurai who save a village. This simple but complexly nuanced human story involves us in different social classes in an historical framework. We come to know individual peasants and samurai, and feel that we know significant things about them, their motivations, hopes and fears.\r\n"
						+ "\r\n"
						+ "The achievements of the actors: These are characters you will love, people you need to have in your life: the characters of Kyuzo, Heihachi and the unforgettable Bokuzen Hidari as a bewildered peasant..! Takeshi Shimura, as the leader of the samurai, Gambei, is the embodiment of wisdom, and calm in the storm. And, saying that Toshiro Mifune has star power is like saying the noonday sun sheds a little warmth. \r\n"
						+ "\r\n"
						+ "Toshiro: It's the cut of his jawline when he asks the village patriarch, \"Got a problem, grandad?\", and the most charming look of confusion and embarrassment playing over his face when he is told by Heihachi that he is the triangle on the samurai flag. It's his energy, speed and agility and power and intelligence. Mifune sniffing out the fuse of a gun in the woods, bouncing through the brush half-naked in an abbreviated set of armor, or carrying his ridiculously oversize sword on one shoulder, Mifune crying over a baby, and the incomparable scene of his embarrassment that turns to rage when Mifune accuses the samurai of creating the farmer's condition. \r\n"
						+ "\r\n"
						+ "Toshiro Mifune represents with extraordinary physicality the spirit of a man desperate to prove his worth: Mifune's got the animal sexuality, the physical response to emotional situations, the expressive face, the humorous and varied vocalisms to make us feel deeply what his character experiences: his struggles, his growth.(His drunken burblings as the last \"samurai\" to audition are nothing short of hilarious, and his \"fish singing\" is eerie and funny, too...also the grunted \"eh?\" that he often uses to show confusion, and the \"heh\" of disgust..such wonderful sounds, and so expressive!) Mifune's acting is wild and alive, even more than 50 years after the film's original release. \r\n"
						+ "\r\n"
						+ "Takashi Shimura: You will trust him with your life. His great, open heart, his mature calm, his honesty and compassion make him one of the greatest of all samurai on film.\r\n"
						+ "\r\n"
						+ "Fumio Hayasaka's music: Kuroasawa was lucky to have such a brilliant composer as collaborator. Themes introduce characters, and the samurai theme is surprising and memorable. If you have viewed the film, chances are, the samurai theme is playing in your mind with just a mention of the music. Hayasaka's music is muscular and nuanced: creating humor, or a counterpoint to the action, or deepening our sympathy for and understanding of the characters. \r\n"
						+ "\r\n"
						+ "Muraki's scenography: There is no doubt that the places shown in the film are real. The achievement of Kurosawa's longtime collaborator provide a real world for the action.\r\n"
						+ "\r\n"
						+ "The filmography is ground-breaking: the multiple cameras, slow-motion and attention to light and composition make each frame worthy of an 8X10 glossy. How can individual moments of such beauty be sustained throughout the movement of the film? It is an astonishing feat. And, best of all, no image degenerates into interior design or vacuous prettiness...everything forwards the movement of the cinematic experience. When the film ends, we feel as if we have lived it! \r\n"
						+ "\r\n"
						+ "It is with great respect and humility that I offer my thanks to the memory of Mr. Kurosawa. His great work leads us to treasure humanity and its struggles, to develop our own abilities to feel compassion, encourages us to try to make good choices, to be socially and morally responsible, to embrace life.",
						"1954", "yippeiokiyay", tagsFive);
		List<String> tagsSix = Arrays.asList("in color", "rated R");
		Review six = new Review(6L, "Saving Private Ryan", "images/tank.jpg", "Drama, War",
				"To think that this movie did not win Best Picture is a crime. Director Steven Spielberg uses all of his talent and resources to give to the world the greatest war film ever made.\r\n"
						+ "\r\n"
						+ "Though it's true that this is not the type of movie you want to sit down with the family and eat popcorn, the emotional drive of the picture, the story's poignant messages, and the fantastic acting of the cast draws you into a world that is both dangerous and unpredictable.\r\n"
						+ "\r\n"
						+ "Spielberg is able to take you into action and make you feel as if you are a participant in the movie and not just a viewer. This is Tom Hanks' best movie he ever did. Forget his performances in Philadelphia and Forrest Gump (though they were also good); he should have received another Oscar for the role of Capt. John Miller, a leader who must act strong in front of his men, but must also hide his emotions from them. It would have been well-deserved if he won again.\r\n"
						+ "\r\n"
						+ "I give this movie my highest recommendation. Saving Private Ryan is a movie that makes you realize how life is precious and how honor and duty, though they are deep philosophical concepts that are praised in war, can put you in jeopardy of losing your life for something you may not believe in.",
						"1998", "morales123", tagsSix);
		List<String> tagsSeven = Arrays.asList("in black and white", "rated PG");
		Review seven = new Review(7L, "Casablanca", "images/plane.jpg", "Drama, Romance, War",
				"Spoilers ahead, but then again, who isn't familiar with Casablanca, even if one hasn't seen it?\r\n"
						+ "\r\n"
						+ "I've been watching 'Casablanca' over and over again since I bought the Special Edition DVD, and is there any film out there one can watch again and again without ever being tired of it? And does any film appeal to a broader audience? Just everything about it seems to be as close to perfection as it only can be.\r\n"
						+ "\r\n"
						+ "But what exactly is so special about it? Is it its great genre mix, never equaled by another film? When we think of 'Casablanca' first, we remember it as a romantic film (well, most of us do). But then again, its also a drama involving terror, murder and flight. One can call it a character study, centering on Rick. And there are quite a few moments of comedic delight, just think of the pickpocket (\"This place is full of vultures, vultures everywhere!\") or the elderly couple on the last evening before their emigration to the US (\"What watch?\").\r\n"
						+ "\r\n"
						+ "But 'Casablanca' is not only great as a whole, it still stands on top if we break it apart and look at single lines of dialog, scenes or performances alone. Is there any other film which has more quotable dialog than 'Casablanca'? 'Pulp Fiction' is on my mind here, and 'All About Eve' and 'Sunset Blvd.' come close, too, but still I think 'Casablanca' tops everything else. And not only is the dialog great, it's unforgettably delivered, especially by Humphrey Bogart (\"I was misinformed.\") and Claude Rains (\"I am shocked, shocked to find that gambling is going on here\"). Many of scenes have become a part of film history; the duel of 'Die Wacht am Rhein' and 'La Marseillaise' is probably one of the greatest scenes ever shot (the only I can think of that would rival it for the #1 spot is Hynkel and the globe from Chaplin's 'The Great Dictator'), and the last scene is probably even familiar to the few people who've never seen 'Casablanca'. Am I the only one who is absolutely convinced that the film wouldn't have become what it is today if Rick and Ilsa would have ended up as the lucky couple?\r\n"
						+ "\r\n"
						+ "About the performances: So much has been said about the uniqueness of Humphrey Bogart's and Ingrid Bergman's chemistry as Rick and Ilsa, about Claude Rains' terrific turn as Renault, about the scene-stealing performances by Peter Lorre (one of the 10 all-time greatest actors) as Ugarte and Sydney Greenstreet as Ferrari and about Dooley Wilson stopping the show as Sam. I'd love to emphasize here two other performances, one that is not mentioned quite as often and one which is blatantly overlooked: Conrad Veidt as Major Strasser had a really difficult task here, as his character is the only evil one, but still Strasser is not a one-dimensional character, and it took more than 50 years until another actor gave an equally (maybe even more) impressive performance as a Nazi, Ralph Fiennes in 'Schindler's List'. But why no one ever mentions S. K. Sakall, who plays Carl, the jolly waiter at Rick's Café Américain, is beyond me. He has definitely more screen time than Lorre, Greenstreet and Wilson, and probably about as much as Veidt, and he's a joy whenever he's on the screen. I simply love his reaction when the pickpocket (\"Vultures everywhere!\") accidentally bumps into him, or the reaction to the \"What watch\"-dialog. Or how he says he gave Strasser the best table, \"being a German, he would have taken it anyway\". His performance is simply criminally overlooked.\r\n"
						+ "\r\n"
						+ "So is there a weakest link in 'Casablanca'? Every film, no matter how close to perfection, has a minor flaw or two, so one can find them in 'Casablanca', too, if one really tries hard. So yes, one might ask how much sense the entire mumbo jumbo about the letters of transit makes. One might point out that Paul Henreid, although his performance is certainly good, doesn't come close to the greatness of any of his co-stars. However, the film is so close to perfection that I'm almost ashamed that I'm so desperately trying to find less-than-perfect elements.\r\n"
						+ "\r\n"
						+ "So whatever films will come, how many sequels will overflow the screen, and how much junk we will have to sit through, one thing is certain if we're desperate to see a great film: We'll always have Casablanca!",
						"1942", "RWiggum", tagsSeven);
		reviewList.put(1L, one);
		reviewList.put(2L, two);
		reviewList.put(3L, three);
		reviewList.put(4L, four);
		reviewList.put(5L, five);
		reviewList.put(6L, six);
		reviewList.put(7L, seven);
	}

	// constructor for testing purposes.
	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);
		}
	}

	public Review findOne(Long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAll() {
		return reviewList.values();
	}
	//not currently used, could be used for template with a list of all tags
	@SuppressWarnings("null")
	public List<String> allTags() {
		List<String> allTags = null;
		Collection<Review> allReviews = reviewList.values();
		for (Review review : allReviews) {
			List<String> tags = review.getTags();
			for (String tag : tags) {
				if (!allTags.contains(tag)) {
					allTags.add(tag);
				}
			}
		}
		return allTags;
	}

	public Collection<Review> findAllWithTag(String tag) {
		ArrayList<Review> reviewsWithTag = new ArrayList<>();
		for (Review review : reviewList.values()) {
			List<String> tags = review.getTags();
			if (tags.contains(tag)) {
				reviewsWithTag.add(review);
			}
		}
		return reviewsWithTag;
	}

}
