/**
 * Manages the list of shows in the system
 * @author Michael Norton (CSCE 247-001) //TODO team name
 * @edited Francis Villanueva
 *
 */
package shows;

import java.util.LinkedList;

import reviews.Review;

/**
 * Keeps track of the shows in the system
 * @author Brody Norton
 * @editor Francis Villanueva
 */
public class ShowList {
	private LinkedList<Show> shows;
  
	public ShowList() {
		shows = new LinkedList<Show>();
	}
	/**
	 * Inserts a show into the list of shows
	 * @param show The show to be inserted
	 */
	private void addShow(Show show) {
		shows.add(show);
	}
  
	/**
	 * Removes a show from the list
	 * @param show The show to be removed
	 */
	private void removeShow(Show show) {
		shows.remove(show);
	}
  
	/**
	 * Searches for a show based on its category
	 * @param category to be searched for
	 * @return show matching category
	 */
	public Show categorySearch(String category) {
		for(int i = 0; i < shows.size(); i++) {
			if(shows.get(i).getCategory().equals(category)) {
				return shows.get(i);
			}
		}
		return null;
	}
  
  /**
   * Searches for a show by its title
   * @param name of the show
   * @return show with name
   */
	public Show nameSearch(String name) {
	  for(int i = 0; i < shows.size(); i++) {
		  if(shows.get(i).getName().equals(name)) {
			  return shows.get(i);
		  }
	  }
	  return null;
	}
  
  /**
   * Searches for a show based on its review
   * @param review
   * @return Show matching review
   */
	public Show reviewSearch(Review review) {
		for(int i = 0; i < shows.size(); i++) {
			for(int j = 0; j < shows.get(i).getReviews().size(); j++)
				if(shows.get(i).getReviews().contains(review)) {
					return shows.get(i);
				}
		}
		return null;
	}
  
	/**
	 * Searches for a show based on its showtime
	 * @param showtime
	 * @return
	 */
	public Show showTimeSearch(String showTime) {
		for(int i = 0; i < shows.size(); i++) {
			if(shows.get(i).getShowTime().equals(showTime)) {
				return shows.get(i);
			}
	    }
	    return null;
  }
}
