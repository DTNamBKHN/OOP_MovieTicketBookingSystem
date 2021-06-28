import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
	private int id;
	private String name;
	private Date releaseDate;
	
	public Movie(int id, String name, String releaseDate) {
		super();
		this.id = id;
		this.name = name;
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		Date date;
		try {
			date = formatter.parse(releaseDate);
			this.releaseDate = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getStringReleaseDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		String strDate = new String();
		strDate = dateFormat.format(this.releaseDate); 
		return strDate;
	}

	public void setReleaseDate(String releaseDate) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		Date date;
		try {
			date = formatter.parse(releaseDate);
			this.releaseDate = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
