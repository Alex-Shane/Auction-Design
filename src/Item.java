import java.util.*;
public class Item {
	Double price;
	String seller;
	String listing;
	String listingInfo;
	String category;
	ArrayList<Bid> bidsOnItem = new ArrayList<Bid>();
 	
	public Item (Double price, String accountID, String listing, String listingInfo, String category) {
		this.price = price;
		this.seller = accountID;
		this.listing = listing;
		this.listingInfo = listingInfo;
		this.category = category;
	}
	
}
