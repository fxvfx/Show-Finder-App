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
	
	protected String tickets; //this should be a object of type TicketList
	// we won't be implementing these for now
//	protected String concessions;
//	protected String coupons;

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

//	public void setConcessions(String concessions) {
//		this.concessions = concessions;
//	}
//
//	public void setCoupons(String coupons) {
//		this.coupons = coupons;
//	}
	
	 public String showTickets(TicketList myTickets) { //this is good!  just include a method header
	  	return "Your tickets are " + myTickets;
	  }
	 /* 
	  public String showConcessions(ConcessionList myConcessions) {
	  	return "Your concessions are" + myConcessions();
	  	}	
	  	
	  public String showCoupons(CouponsList myCoupons) {
	  		return "Your coupons are" + showCoupons();
	  	}
	 */
}
