
public class Ticket {
	private int id;
	private Movie movie;
	private double price;
	private static int nextID = 0;
	public Ticket() {
		id = nextID++;
	}
	public Ticket(Movie movie, double price) {
		this();
		this.movie = movie;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
