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
	public static ArrayList<Customer> customerList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		movieList = new ArrayList<Movie>();
		ticketList = new ArrayList<Ticket>();
		invoiceList = new ArrayList<Invoice>();
		

		TicketBookingEX.readMovieFile();
		TicketBookingEX.readTicketFile();
		while(true)
			TicketBookingEX.menu();
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
			TicketBookingEX.showMovieData();
			TicketBookingEX.addMoviesList();
			TicketBookingEX.showMovieData();
			break;
		case 2:
			TicketBookingEX.showMovieData();
			TicketBookingEX.editMoviesList();
			TicketBookingEX.showMovieData();
			break;
		case 3:
			TicketBookingEX.showMovieData();
			TicketBookingEX.removeMoviesList();
			TicketBookingEX.showMovieData();
			break;
		case 4: 
			TicketBookingEX.showTicketData();
			TicketBookingEX.addTicketsList();
			TicketBookingEX.showTicketData();
			break;
		case 5:
			TicketBookingEX.showTicketData();
			TicketBookingEX.editTicketsList();
			TicketBookingEX.showTicketData();
			break;
		case 6:
			TicketBookingEX.showTicketData();
			TicketBookingEX.removeTicketsList();
			TicketBookingEX.showTicketData();
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
	
	public static void showTicketData() {
		for (int i = 0; i < ticketList.size(); i++) {
			System.out.println(ticketList.get(i).getId()+"-"+ticketList.get(i).getMovie().getName()+"-"+ticketList.get(i).getPrice());
		}
		System.out.println("********************************************");
	}
	
	public static boolean saveTicketFile() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		String strDate = new String();
		try {
            FileWriter writer = new FileWriter("ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Ticket ticket: ticketList) {
				strDate = dateFormat.format(ticket.getMovie().getReleaseDate());  
				bufferedWriter.write(ticket.getId()+"@"+ticket.getMovie().getId()+"@"+ticket.getMovie().getName()+"@"+strDate+"@"+ticket.getPrice());
	            bufferedWriter.newLine();
			}
            
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public static boolean readTicketFile(){
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		try {
            FileReader reader = new FileReader("ticket.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
            	Ticket ticket = new Ticket();
            	Movie movie = new Movie();
            	String[] arrOfStr = line.split("@", 5);
            	  
                for (int i = 0; i < arrOfStr.length; i++) {
                	if (i == 0) {
                		continue;
                	}
                	else if (i == 1)
                		movie.setId(Integer.parseInt(arrOfStr[i]));
                	else if (i == 2)
                		movie.setName(arrOfStr[i]);
                	else if (i == 3) {
                		Date date = formatter.parse(arrOfStr[i]);
                		movie.setReleaseDate(date);
                	}
                	else {
                		ticket.setPrice(Double.parseDouble(arrOfStr[i]));
                	}
                }
                ticket.setMovie(movie);
                ticketList.add(ticket);
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
	
	public static void showMovieData() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		String strDate = new String();
		for (int i = 0; i < movieList.size(); i++) {
			strDate = dateFormat.format(movieList.get(i).getReleaseDate()); 
			System.out.println(movieList.get(i).getId()+"-"+movieList.get(i).getName()+"-"+strDate);
		}
		System.out.println("********************************************");
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
                	if (i == 0) {
                		continue;
                	}
//                		movie.setId(Integer.parseInt(arrOfStr[i]));
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
	
	public static void addMoviesList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String name = sc.nextLine();
		System.out.println("Enter release date time: ");
		String date = sc.nextLine();
		Movie movie = new Movie(name, date);
		movieList.add(movie);
		TicketBookingEX.saveMovieFile();
	}
	
	public static void editMoviesList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index: ");
		int index = sc.nextInt();
		Movie movie = movieList.get(index);
		System.out.println("Want to edit movie name? (y/n)");
		sc.nextLine();
		String choice = sc.nextLine();
		if (choice.equals("y")) {
			System.out.println("Enter new movie name: ");
			String name = sc.nextLine();
			movie.setName(name);
		}
		System.out.println("Want to edit release date time? (y/n)");
		String choice2 = sc.nextLine();
		if (choice2.equals("y")) {
			System.out.println("Enter new release date time: ");
			String date = sc.nextLine();
			movie.setReleaseDate(date);
		}
		TicketBookingEX.saveMovieFile();
	}
	
	public static void removeMoviesList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index: ");
		int index = sc.nextInt();
		movieList.remove(index);
		TicketBookingEX.saveMovieFile();
	}
	
	public static void addTicketsList() {
		Movie findMovie = new Movie();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String name = sc.nextLine();
		boolean checkExist = false;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getName().equals(name)) {
				checkExist = true;
				findMovie = movieList.get(i);
				break;
			}
		}
		if (checkExist == false) {
			System.out.println("Can't add ticket because there is no movie has name " + name);
		}
		else {
			System.out.println("Enter price: ");
			Double price = sc.nextDouble();
			Ticket ticket = new Ticket(findMovie, price);
			ticketList.add(ticket);
			TicketBookingEX.saveTicketFile();
		}
	}
	
	public static void editTicketsList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index: ");
		int index = sc.nextInt();
		Ticket ticket = ticketList.get(index);
		System.out.println("Enter new price: ");
		Double price = sc.nextDouble();
		ticket.setPrice(price);
		TicketBookingEX.saveTicketFile();
	}
	
	public static void removeTicketsList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index: ");
		int index = sc.nextInt();
		ticketList.remove(index);
		TicketBookingEX.saveTicketFile();
	}
	
	public static void
}
