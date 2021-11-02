
import java.sql.Timestamp;
import java.util.*;
public class User extends Auction{
	String reputation;//or int? Idk, not specified what type it is.
	String accountID;
	double funds;
	String password;
	ArrayList<Bid> userBids = new ArrayList<Bid>();

	public User (String userID, String pass, double amt) {
		accountID = userID;
		password = pass;
		funds = amt;
	}
	
	public void makeBid (double bidPrice, Item item) { 
		if (bidPrice <= funds){
			Bid newBid = new Bid(item, bidPrice, this.getTimeStamp());
			userBids.add(newBid);
			item.bidsOnItem.add(newBid);
		}else {
			System.out.println("INSUFFICIENT FUNDS!");
		}
	}
	
	public void listItem (Double price, String accountID, String listing, String listingInfo, String category) {
		Item newItem = new Item(price, accountID, listing, listingInfo, category);
		super.createAuction(newItem);
	}
	
	public double checkFunds () {
		return funds;
	}
	
	public void giveReputation (String rep) {
		reputation = rep;
	}
	
	public void deposit(double amt) {
		funds += amt;
	}
	
	public void withdraw (double amt) {
		funds -= amt;
	}
	
	public Date getTimeStamp () {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return (ts);
	}
}
