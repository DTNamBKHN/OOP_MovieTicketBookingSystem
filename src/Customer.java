import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String name;
	private String phoneNumber;
	public Customer() {
		super();
	}
	public Customer(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Ticket searchATicketByMovieName(ArrayList<Ticket> ticketList) {
		Ticket findTicket = new Ticket();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String name = sc.nextLine();
		boolean checkExist = false;
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getMovie().getName().equals(name)) {
				checkExist = true;
				findTicket = ticketList.get(i);
				break;
			}
		}
		if (checkExist == false) {
			System.out.println("There is no movie has name " + name);
			return null;
		}
		else {
			System.out.println("Ticket's id: " + findTicket.getId());
			System.out.println("Release date time: " + findTicket.getMovie().getStringReleaseDate());
			return findTicket;
		}
	}
	
	public void bookATicket(Invoice invoice, ArrayList<Ticket> ticketList) {
		Ticket findTicket = new Ticket();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String name = sc.nextLine();
		boolean checkExist = false;
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getMovie().getName().equals(name)) {
				checkExist = true;
				findTicket = ticketList.get(i);
				break;
			}
		}
		if (checkExist == false) {
			System.err.println("There is no movie has name " + name);
		}
		else {
			
//			ArrayList<Ticket> ticketListOfInvoice = new ArrayList<Ticket>();
			ArrayList<Ticket> ticketListOfInvoice = invoice.getTicketList();
			if (ticketListOfInvoice == null) {
				ticketListOfInvoice = new ArrayList<Ticket>();
			}
			invoice.setCustomerName(this.getName());
			ticketListOfInvoice.add(findTicket);
			invoice.setTicketList(ticketListOfInvoice);
			
			Double totalPrice = (double) 0;
			for (int i = 0; i < ticketListOfInvoice.size(); i++) {
				totalPrice += ticketListOfInvoice.get(i).getPrice();
			}
			invoice.setTotalPrice(totalPrice);
			System.out.println("Book successfully");
		}
	}
}
