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
		if (currentBlock.getItem(item)==null) {
			System.out.println("ERROR: NO BIDS FOR ITEMS YET");
		}
		Item obj = currentBlock.getItem(item);
		double highest = 0;
		for (int i = 0; i<obj.bidsOnItem.size(); i++) {
			if (obj.bidsOnItem.get(i).bidPrice > highest) {
				highest = obj.bidsOnItem.get(i).bidPrice;
			}
		}
		return highest;
	}
	
	public void signupUser (String ID, User user) {
		users.put(ID, user);
	}
	
	public void addItemToBlock (Item item) {
		currentBlock.bids.add(item);
	}
	
	public ArrayList<String> filter(String category) {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i<currentBlock.bids.size(); i++) {
			if (currentBlock.bids.get(i).category.equals(category)) {
				output.add(currentBlock.bids.get(i).listing);
			}
		}
		return output;
	}
	
	public void newBlock() {//this can be changed depending on how big we want the blocks to be
		if (currentBlock.bids.size()>50) {
			Block block1 = currentBlock;
			blocks.add(block1);
			currentBlock = new Block(getTimeStamp(), getTimeStamp());
		}
	}
	
	public void endAuction(String item) {
		endBlock = currentBlock;
		Item obj = currentBlock.getItem(item);
		double highest = 0;
		String winner ="";
		for (int i = 0; i<obj.bidsOnItem.size(); i++) {
			if (obj.bidsOnItem.get(i).bidPrice > highest) {
				highest = obj.bidsOnItem.get(i).bidPrice;
				winner = obj.bidsOnItem.get(i).bidderID;
			}
		}
		if (!winner.equals("")) {
			System.out.println("Dear "+ winner + ", you have won "+item+ " which you bid for $" + highest+". " );
			if (transactionSuccess(item, winner, highest))
				System.out.println("The transaction succeeded.");
			else
				System.out.println("The transaction failed.");
		}else {
			System.out.println("NO WINNER FOR " + obj.listing);
		}
	}
	
	public boolean transactionSuccess(String item, String bidderID, double highestPrice) {
		User winner = users.get(bidderID);
		Item obj = currentBlock.getItem(item);
		User seller = users.get(obj.seller);
		double amt = highestPrice;
		System.out.println(amt);
		double royalty = amt*0.05;
		if (winner.checkFunds()>=amt+royalty) {
			winner.funds -= amt + royalty;
			winner.funds += amt*0.02;
			seller.funds += amt + royalty;
			return true;
		}
		return false;
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
