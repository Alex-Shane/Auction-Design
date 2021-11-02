import java.sql.Timestamp;
import java.util.*;
public class Auction {
	double highestBid;
	ArrayList<Block> blocks;
	Block currentBlock; 
	Block endBlock;
	Map<String, User> users;
	
	public Auction () {
		blocks = new ArrayList<Block>();
		users = new HashMap<String, User>();
		currentBlock = new Block(getTimeStamp(), getTimeStamp());
	}
	
	public double getHighestBid (String item) {
		Item obj = currentBlock.getItem(item);
		double highest = 0;
		for (int i = 0; i<obj.bidsOnItem.size(); i++) {
			if (obj.bidsOnItem.get(i).bidPrice > highest) {
				highest = obj.bidsOnItem.get(i).bidPrice;
			}
		}
		return highest;
	}
	
	public void createAuction(Item item) {
		currentBlock.bids.add(item);
	}
	
	public void newBlock() {
		
	}
	
	public void endAuction() {
		
	}
	
	public Date getTimeStamp () {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return (ts);
	}
	
	public void addUser (User user) {
		users.put(user.accountID, user);
	}
}
