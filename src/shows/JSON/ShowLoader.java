package shows.JSON;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.*;

import reviews.*;
import shows.*;


/**
 * Loads shows from JSON files
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
public class ShowLoader extends DataConstants {
	
	/**
	 * Loads list of Shows from JSON files
	 * @return LinkedList of Shows for ShowList
	 */
	public static LinkedList<Show> loadShows() {
		LinkedList<Show> shows = new LinkedList<Show>();
		
		try {
			
			//Extract Movies
			FileReader reader = new FileReader(MOVIE_FILE);
			JSONParser parser = new JSONParser();
			JSONArray showsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < showsJSON.size(); i++) {
				JSONObject movieJSON = (JSONObject)showsJSON.get(i);
				
				String name = (String)movieJSON.get(NAME);
				String showTime = (String)movieJSON.get(SHOW_TIME);
				String showDate = (String)movieJSON.get(SHOW_DATE);
				String venueName = (String)movieJSON.get(VENUE);
				String location = (String)movieJSON.get(LOCATION);
				double ticketPrice = (Double)movieJSON.get(PRICE);
				
				/*LinkedList<String> actorList = new LinkedList<String>();
				JSONArray actorJSON = (JSONArray) movieJSON.get(ACTOR_LIST);
				for(int j = 0; j < actorJSON.size(); j++) {
					actorList.add((String) actorJSON.get(j));
				}*/
				String actorList = (String) movieJSON.get(ACTOR_LIST);
				
				int ageRestriction = (Integer)movieJSON.get(AGE);
				
				String movieSummary = (String) movieJSON.get(MOVIE_SUM);
				String releaseDate = (String) movieJSON.get(REL_DATE);
				String directorName = (String) movieJSON.get(DIRECTOR);
				MovieRating mpaRating = MovieRating.valueOf((String) movieJSON.get(RATING));
				String category = (String) movieJSON.get(CATEGORY);
				
				
				
				Movie movie = new Movie(name, showTime, showDate, venueName, location, ticketPrice, 
						actorList, ageRestriction, category, movieSummary, releaseDate, directorName, mpaRating);
				
				JSONArray reviewListJSON = (JSONArray) movieJSON.get(REVIEWS);
				for(int j = 0; j < reviewListJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewListJSON.get(j);
					String reviewContent = (String)reviewJSON.get(CONTENT);
					int numStars = (Integer)reviewJSON.get(NUM_STARS);
					//TODO Owner
					movie.addReview(new Review(movie, reviewContent, numStars, null));
				}
				shows.add(movie);
				
			}
			
			//Extract Plays
			reader = new FileReader(PLAY_FILE);
			showsJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i = 0; i < showsJSON.size(); i++) {
				JSONObject playJSON = (JSONObject)showsJSON.get(i);
				
				String name = (String)playJSON.get(NAME);
				String showTime = (String)playJSON.get(SHOW_TIME);
				String showDate = (String)playJSON.get(SHOW_DATE);
				String venueName = (String)playJSON.get(VENUE);
				String location = (String)playJSON.get(LOCATION);
				double ticketPrice = (Double)playJSON.get(PRICE);
				String category = (String) playJSON.get(CATEGORY);
				
				/*LinkedList<String> actorList = new LinkedList<String>();
				JSONArray actorJSON = (JSONArray) playJSON.get(ACTOR_LIST);
				for(int j = 0; j < actorJSON.size(); j++) {
					actorList.add((String) actorJSON.get(j));
				}*/
				String actorList = (String) playJSON.get(ACTOR_LIST);
				
				int ageRestriction = (Integer)playJSON.get(AGE);

				String playSummary = (String)playJSON.get(PLAY_SUM);
				
				Play play = new Play(name, showTime, showDate, venueName, location, ticketPrice, 
						actorList, ageRestriction, playSummary, category);
				JSONArray reviewListJSON = (JSONArray) playJSON.get(REVIEWS);

				for(int j = 0; j < reviewListJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewListJSON.get(j);
					String reviewContent = (String)reviewJSON.get(CONTENT);
					int numStars = (Integer)reviewJSON.get(NUM_STARS);
					//TODO Owner
					play.addReview(new Review(play, reviewContent, numStars, null));
				}
				shows.add(play);
			}
			
			//Extract Concerts
			reader = new FileReader(CONCERT_FILE);
			showsJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i = 0; i < showsJSON.size(); i++) {
				JSONObject concertJSON = (JSONObject)showsJSON.get(i);
				
				String name = (String)concertJSON.get(NAME);
				String showTime = (String)concertJSON.get(SHOW_TIME);
				String showDate = (String)concertJSON.get(SHOW_DATE);
				String venueName = (String)concertJSON.get(VENUE);
				String location = (String)concertJSON.get(LOCATION);
				double ticketPrice = (Double)concertJSON.get(PRICE);
				
				/*LinkedList<String> actorList = new LinkedList<String>();
				JSONArray actorJSON = (JSONArray) concertJSON.get(ACTOR_LIST);
				for(int j = 0; j < actorJSON.size(); j++) {
					actorList.add((String) actorJSON.get(j));
				}*/
				String actorList = (String) concertJSON.get(ACTOR_LIST);
				
				int ageRestriction = (Integer)concertJSON.get(AGE);
				
				String genre = (String)concertJSON.get(GENRE);

				Concert concert = new Concert(name, showTime, showDate, venueName, location, ticketPrice, 
						actorList, ageRestriction, genre);
				JSONArray reviewListJSON = (JSONArray) concertJSON.get(REVIEWS);

				for(int j = 0; j < reviewListJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewListJSON.get(j);
					String reviewContent = (String)reviewJSON.get(CONTENT);
					int numStars = (Integer)reviewJSON.get(NUM_STARS);
					//TODO Owner
					concert.addReview(new Review(concert, reviewContent, numStars, null));
				}
				shows.add(concert);
			}
			
			return shows;
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
