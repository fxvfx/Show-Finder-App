package shows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	public void testToString() {
		Movie movie = new Movie("Mulan", "7:00", "August 20 2020", "Carolina Theater", "Columbia",
				5.0, "Yifei Liu", 13, "Action Adventure", "Live action Disney remake", "July 24 2020",
				"Niki Caro", MovieRating.PG13);
		String movieString = "Show information:\n\nShow name: Mulan\nCategory: Action Adventure\nShow time: 7:00\n"
				+ "Show date: August 20 2020\nVenue name: Carolina Theater\nLocation: Columbia\n"
				+ "Ticket price: 5.0\nActor list: Yifei Liu\n"
				+ "Age restriction: 13\n\nNumber of seats still available: 25\n\n"
				+ "Reviews:\n\nMovie Summary: Live action Disney remake\nRelease Date: July 24 2020\n"
				+ "Director: Niki Caro\nRating: PG13";
		assertEquals(movie.toString(), movieString);
	}

	@Test
	public void testGetMovieSummary() {
		Movie movie = new Movie("Mulan", "7:00", "August 20 2020", "Carolina Theater", "Columbia",
				5.0, "Yifei Liu", 13, "Action Adventure", "Live action Disney remake", "July 24 2020",
				"Niki Caro", MovieRating.PG13);
		assertEquals(movie.getMovieSummary(), "Live action Disney remake");
	}

	@Test
	public void testGetReleaseDate() {
		Movie movie = new Movie("Mulan", "7:00", "August 20 2020", "Carolina Theater", "Columbia",
				5.0, "Yifei Liu", 13, "Action Adventure", "Live action Disney remake", "July 24 2020",
				"Niki Caro", MovieRating.PG13);
		assertEquals(movie.getReleaseDate(), "July 24 2020");
	}

	@Test
	public void testGetDirectorName() {
		Movie movie = new Movie("Mulan", "7:00", "August 20 2020", "Carolina Theater", "Columbia",
				5.0, "Yifei Liu", 13, "Action Adventure", "Live action Disney remake", "July 24 2020",
				"Niki Caro", MovieRating.PG13);
		assertEquals(movie.getDirectorName(), "Niki Caro");
	}

	@Test
	public void testGetMpaRating() {
		Movie movie = new Movie("Mulan", "7:00", "August 20 2020", "Carolina Theater", "Columbia",
				5.0, "Yifei Liu", 13, "Action Adventure", "Live action Disney remake", "July 24 2020",
				"Niki Caro", MovieRating.PG13);
		assertEquals(movie.getMpaRating(), MovieRating.PG13);
	}

}
