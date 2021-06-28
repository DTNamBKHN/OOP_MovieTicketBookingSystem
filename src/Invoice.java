import java.util.ArrayList;

public class Invoice {
	private String customerName;
	private ArrayList<Ticket> ticketList;
	private double totalPrice;
	
	public Invoice() {
		super();
	}

	public Invoice(String customerName, ArrayList<Ticket> ticketList, double totalPrice) {
		super();
		this.customerName = customerName;
		this.ticketList = ticketList;
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
