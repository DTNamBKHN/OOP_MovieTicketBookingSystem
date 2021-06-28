import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TicketBookingEX {
	public static ArrayList<Movie> movieList;
	public static ArrayList<Ticket> ticketList;
	public static ArrayList<Invoice> invoiceList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		movieList = new ArrayList<Movie>();
		ticketList = new ArrayList<Ticket>();
		invoiceList = new ArrayList<Invoice>();
		
		if (TicketBookingEX.readMovieFile() == true)
			System.out.println("read file successfully");
		else
			System.out.println("Failed in reading file");
		TicketBookingEX.showMovieData();
		
		Movie movie = new Movie(6, "Spider Man", "13-4-2021 20:59:26");
		movieList.add(movie);
		TicketBookingEX.showMovieData();
		TicketBookingEX.saveMovieFile();
	}
	
	public static void menu() {
		System.out.println("1. Add a movie");
		System.out.println("2. Edit a movie");
		System.out.println("3. Remove a movie");
		System.out.println("4. Add a ticket");
		System.out.println("5. Edit a ticket");
		System.out.println("6. Remove a ticket");
		System.out.println("7. Search a ticket by movie name");
		System.out.println("8. Book a ticket");
		System.out.println("9. Exit");
		System.out.println("*************************************");
		System.out.print("Your choice: ");
		int choice = new Scanner(System.in).nextInt();
		switch(choice)
		{
		case 1: 
			TicketBookingEX.addMoviesList(null);
			break;
		case 2:
			TicketBookingEX.editMoviesList(null);
			break;
		case 3:
			TicketBookingEX.removeMoviesList(null);
			break;
		case 4: 
			TicketBookingEX.addTicketsList(null);
			break;
		case 5:
			TicketBookingEX.editTicketsList(null);
			break;
		case 6:
			TicketBookingEX.removeTicketsList(null);
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			System.err.println("Bye!!!");
			System.exit(0);
			break;
		}
	}
	
	public static void showMovieData() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		String strDate = new String();
		for (int i = 0; i < movieList.size(); i++) {
			strDate = dateFormat.format(movieList.get(i).getReleaseDate()); 
			System.out.println(movieList.get(i).getId()+"-"+movieList.get(i).getName()+"-"+strDate);
		}
	}
	
	public static boolean saveMovieFile() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		String strDate = new String();
		try {
            FileWriter writer = new FileWriter("movie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Movie movie: movieList) {
				strDate = dateFormat.format(movie.getReleaseDate());  
				bufferedWriter.write(movie.getId()+"-"+movie.getName()+"-"+strDate);
	            bufferedWriter.newLine();
			}
            
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public static boolean readMovieFile(){
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		try {
            FileReader reader = new FileReader("movie.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
            	Movie movie = new Movie();
            	String[] arrOfStr = line.split("-", 3);
            	  
                for (int i = 0; i < arrOfStr.length; i++) {
                	if (i == 0)
                		movie.setId(Integer.parseInt(arrOfStr[i]));
                	else if (i == 1)
                		movie.setName(arrOfStr[i]);
                	else {
                		Date date = formatter.parse(arrOfStr[i]);
                		movie.setReleaseDate(date);
                	}
                }
                movieList.add(movie);
            }
            bufferedReader.close();
            reader.close();
            return true;
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addMoviesList(Movie movie) {
		
	}
	
	public static void editMoviesList(Movie movie) {
		
	}
	
	public static void removeMoviesList(Movie movie) {
		
	}
	
	public static void addTicketsList(Ticket ticket) {
		
	}
	
	public static void editTicketsList(Ticket ticket) {
		
	}
	
	public static void removeTicketsList(Ticket ticket) {
		
	}
}
