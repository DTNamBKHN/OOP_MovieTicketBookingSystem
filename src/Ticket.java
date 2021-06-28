
public class Ticket {
	private Movie movie;
	private double price;
	public Ticket() {
		super();
	}
	public Ticket(Movie movie, double price) {
		super();
		this.movie = movie;
		this.price = price;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
