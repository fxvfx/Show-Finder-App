package Carts;
/**
 * 
 * @author Tariq Scott
 *
 */
public class Cart {
	
	/*TicketList myTickets;
	ConcessionsList myConcessions;
	CouponsList myCoupons;
	 */	
	
	protected String tickets;
	protected String concessions;
	protected String coupons;

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public void setConcessions(String concessions) {
		this.concessions = concessions;
	}

	public void setCoupons(String coupons) {
		this.coupons = coupons;
	}
	
	 /* public String showTickets(TicketList myTickets) {
	  	return + "Your tickets are" + myTickets;
	  }
	  
	  public String showConcessions(ConcessionList myConcessions) {
	  	return "Your concessions are" + myConcessions();
	  	}	
	  	
	  public String showCoupons(CouponsList myCoupons) {
	  		return "Your coupons are" + showCoupons();
	  	}
	 */
}
