import java.util.*;
public class Bid {
	Item item;
	Double bidPrice;
	Date timeStamp;
	
	public Bid (Item item, Double bidPrice, Date timeStamp) {
		this.item = item;
		this.bidPrice = bidPrice;
		this.timeStamp = timeStamp;
	}
}
