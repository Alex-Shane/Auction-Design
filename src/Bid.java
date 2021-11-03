import java.util.*;
public class Bid {
	String bidderID;
	Item item;
	Double bidPrice;
	Date timeStamp;
	
	public Bid (String bidderID, Item item, Double bidPrice, Date timeStamp) {
		this.bidderID = bidderID;
		this.item = item;
		this.bidPrice = bidPrice;
		this.timeStamp = timeStamp;
	}
}
