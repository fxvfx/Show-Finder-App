package Carts;

import tickets.*;

/**
 * 
 * @author Tariq Scott
 *
 */

public class ShoppingCart {
	private double netCheckoutPrice;
	private TicketList cartTickets;
//	private ConcessionList cartConcessions;
//	private CouponList cartCoupons;
	
	 
	  /*public void addCoupon(Coupon coupon) {
	  	 coupon.add();
	  }
	  
	  public void buyConcession(Concession concession) {
	  	 concession.add();
	  }*/
	  
		//TODO can't work on these two at the moment
		/*
	  Ticket buyTicket(SeatTracker ticket) {

	 }
	 
	 Ticket removeTicket(SeatTracker ticket) {
	 	ticket.remove();
	 		} */
	
	/**
	 * 
	 * @return:
	 * 
	 * TODO: getTotal() should return the total price of everything in the ShoppingCart; the calculating
	 * part I'll leave up to you (but it involves looping through cartTickets and getting the price of
	 * everything)
	 */
	public double getTotal() {
		double total = 0.0;
		
		//calculate total here
		
		netCheckoutPrice = total;
		return netCheckoutPrice;
	}
	
	/**
	 * 
	 * @param amount:
	 * @param show:
	 * 
	 * TODO: make sure they can't buy 0 tickets, but otherwise pass the two parameters into
	 * show.tickets.buyTicket() method
	 */
	public void buyTicket(int amount, Show show) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param show:
	 * 
	 * TODO: call the show's SeatTracker object to buy all the tickets
	 */
	public void buyTheater(Show show) {
		
	}
	
	/**
	 * 
	 * @param show:
	 * @param seatID:
	 * 
	 * TODO: remove the ticket from this.tickets, then use show's SeatTracker object to add the ticket
	 * back to the show
	 */
	public void removeTicket(Show show, String seatID) {
		
	}
	
	//not worrying about this right now
//	public void refundTicket(Show show, String seatID) {
//		
//	}
 	 
}
