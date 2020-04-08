package shows.JSON;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.*;

import reviews.Review;
import reviews.ReviewList;
import shows.*;

/**
 * Writes shows to JSON file
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
public class ShowWriter extends DataConstants {
	
	public static void saveShows() {
		ShowList showList = ShowList.getInstance();
		LinkedList<Show> friends = showList.getShows();
	
		JSONArray jsonMovies = new JSONArray();
		JSONArray jsonPlays = new JSONArray();
		JSONArray jsonConcerts = new JSONArray();
		
		for(int i = 0; i < friends.size(); i++) {
			if(friends.get(i) instanceof Movie) {
				jsonMovies.add(getMovieJSON((Movie) friends.get(i)));
			} else if(friends.get(i) instanceof Play) {
				jsonPlays.add(getPlayJSON((Play) friends.get(i)));
			} else if(friends.get(i) instanceof Concert) {
				jsonConcerts.add(getConcertJSON((Concert) friends.get(i)));
			}
		}
		saveMovies(jsonMovies);
		savePlays(jsonPlays);
		saveConcerts(jsonConcerts);
	}
	
	public static void saveMovies(JSONArray jsonFriends) {
		
		try(FileWriter file = new FileWriter(MOVIE_FILE)) {
			file.write(jsonFriends.toJSONString());
			file.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void savePlays(JSONArray jsonFriends) {
		
			try(FileWriter file = new FileWriter(PLAY_FILE)) {
			file.write(jsonFriends.toJSONString());
			file.flush();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void saveConcerts(JSONArray jsonFriends) {
		
			try(FileWriter file = new FileWriter(CONCERT_FILE)) {
			file.write(jsonFriends.toJSONString());
			file.flush();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static JSONObject getMovieJSON(Movie movie) {
		JSONObject movieDetails = new JSONObject();
		movieDetails.put(ACTOR_LIST, movie.getActorList());
		movieDetails.put(AGE, movie.getAgeRestriction());
		movieDetails.put(CATEGORY, movie.getCategory());
		movieDetails.put(DIRECTOR, movie.getDirectorName());
		movieDetails.put(LOCATION,movie.getLocation());
		movieDetails.put(RATING, movie.getMpaRating().toString());
		movieDetails.put(MOVIE_SUM, movie.getMovieSummary());
		movieDetails.put(NAME, movie.getName());
		movieDetails.put(PRICE, movie.getTicketPrice());
		movieDetails.put(REL_DATE, movie.getReleaseDate());
		movieDetails.put(SHOW_DATE, movie.getShowDate());
		movieDetails.put(SHOW_TIME, movie.getShowTime());
		movieDetails.put(VENUE, movie.getVenueName());
		
		LinkedList<Review> reviews = movie.getReviews().getReviews();
		JSONArray reviewsDetails = new JSONArray();
		for(Review r : reviews) {
			JSONObject reviewDetails = new JSONObject();
			reviewDetails.put(CONTENT, r.getReviewContent());
			reviewDetails.put(NUM_STARS, r.getNumStars());
			//TODO owner
			
			reviewsDetails.add(reviewDetails);
		}
		
		movieDetails.put(REVIEWS, reviews);
		
		return movieDetails;
	}
	
	public static JSONObject getPlayJSON(Play play) {
		JSONObject playDetails = new JSONObject();
		playDetails.put(ACTOR_LIST, play.getActorList());
		playDetails.put(AGE, play.getAgeRestriction());
		playDetails.put(CATEGORY, play.getCategory());
		playDetails.put(LOCATION,play.getLocation());
		playDetails.put(PLAY_SUM, play.getPlaySummary());
		playDetails.put(NAME, play.getName());
		playDetails.put(PRICE, play.getTicketPrice());
		playDetails.put(SHOW_DATE, play.getShowDate());
		playDetails.put(SHOW_TIME, play.getShowTime());
		playDetails.put(VENUE, play.getVenueName());
		
		LinkedList<Review> reviews = play.getReviews().getReviews();
		JSONArray reviewsDetails = new JSONArray();
		for(Review r : reviews) {
			JSONObject reviewDetails = new JSONObject();
			reviewDetails.put(CONTENT, r.getReviewContent());
			reviewDetails.put(NUM_STARS, r.getNumStars());
			//TODO owner
			
			reviewsDetails.add(reviewDetails);
		}
		
		playDetails.put(REVIEWS, reviews);
		
		return playDetails;
	}
	
	public static JSONObject getConcertJSON(Concert concert) {
		JSONObject concertDetails = new JSONObject();
		concertDetails.put(ACTOR_LIST, concert.getActorList());
		concertDetails.put(AGE, concert.getAgeRestriction());
		concertDetails.put(CATEGORY, concert.getCategory());
		concertDetails.put(LOCATION,concert.getLocation());
		concertDetails.put(GENRE, concert.getGenre());
		concertDetails.put(NAME, concert.getName());
		concertDetails.put(PRICE, concert.getTicketPrice());
		concertDetails.put(SHOW_DATE, concert.getShowDate());
		concertDetails.put(SHOW_TIME, concert.getShowTime());
		concertDetails.put(VENUE, concert.getVenueName());
		
		LinkedList<Review> reviews = concert.getReviews().getReviews();
		JSONArray reviewsDetails = new JSONArray();
		for(Review r : reviews) {
			JSONObject reviewDetails = new JSONObject();
			reviewDetails.put(CONTENT, r.getReviewContent());
			reviewDetails.put(NUM_STARS, r.getNumStars());
			//TODO owner
			
			reviewsDetails.add(reviewDetails);
		}
		
		concertDetails.put(REVIEWS, reviews);
		
		return concertDetails;
	}
}
