import java.util.*;
public class Block {
	ArrayList<Item> bids;
	Date startTime;
	Date endTime;
	
	public Block (Date startTime, Date endTime) {
		bids = new ArrayList<Item>();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Item getItem (String itemName) {
		for (Item obj : bids) {
			if (obj.listing.equals(itemName)) {
				return obj;
			}
		}
		return null;
	}
	
}
