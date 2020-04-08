package Show;
/**
 * 
 * @author tariqscott
 *
 */
public class Movie extends Show {

	private Movie movie;
	
	public Movie(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public int getTicketCount() {
		return movie.getTicketCount();
	}

	@Override
	public int getReviewList() {
		return movie.getReviewList();
	}
	
	public String toString() {
		return movie + " is about";
	}
}