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
	private static ShowList showList = null;
	private static LinkedList<Show> shows;
  
	private ShowList() {
		shows = new LinkedList<Show>();
	}
	
	public static ShowList getInstance() {
		if(showList == null) {
			showList = new ShowList();
		}
		
		return showList;
	}
	
	public LinkedList<Show> getShows() {
		return shows;
	}
	/**
	 * Inserts a show into the list of shows
	 * @param show The show to be inserted
	 */
	public void addShow(Show show) {
		shows.add(show);
	}
  
	/**
	 * Removes a show from the list
	 * @param show The show to be removed
	 */
	public void removeShow(Show show) {
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
   * Searches for a show based on a snippet of its review
   * @param review a snippet of the review
   * @return Show matching review
   * TODO: doesn't currently work
   */
	public Show reviewSearch(String review) {
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
