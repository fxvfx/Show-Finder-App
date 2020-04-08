package Carts;

import Lists.List;
import Lists.Ticket;
import seats.SeatTracker;

/**
 * 
 * @author Tariq Scott
 *
 */

public class ShoppingCart extends SeatTracker implements List  {
	double netCheckoutPrice;
	
	 
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
	 
	   public double getTotal() {
	   		netCheckoutPrice = buyConcession + buyTicket() - addCoupon();
	   		double total = netCheckoutPrice;
	   		return total;
	   }

	@Override
	public double calculateTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem() {
		// TODO Auto-generated method stub
		
	}
 	 
}
