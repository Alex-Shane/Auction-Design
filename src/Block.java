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
		for (int i = 0; i<bids.size(); i++) {
			if (bids.get(i).listing.equals(itemName)) {
				return bids.get(i);
			}
		}
		return null;
	}
	
}
