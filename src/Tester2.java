import java.util.*;
public class Tester2 {//Normal Run
	public static void main (String[] args) {
		Auction sotheby = new Auction();
        
		User jeff = new User("jeffbezos", "blahblah", 10);
		sotheby.signupUser(jeff.accountID, jeff);
		User theiss = new User("mrtheiss", "HELIUMTOTHEMOON", 15);
		sotheby.signupUser(theiss.accountID, theiss);
		User colin = new User("colinyuan", "DOGECOIN", 6);
		sotheby.signupUser(colin.accountID, colin);
		User elon = new User("elonmusk", "TOTHEMOON", 0);
		sotheby.signupUser(elon.accountID, elon);
		System.out.println("USERS " + sotheby.users);
		
		Item Tesla = elon.listItem(1000, "TESLA", "MODEL S PLAID", "CAR");
		sotheby.addItemToBlock(Tesla);
		System.out.println("ITEM: TESLA LISTED BY " + Tesla.seller);
		
		Item Benz = jeff.listItem(5, "BENZ", "BENZ SEDAN", "CAR");
		sotheby.addItemToBlock(Benz);
		System.out.println("ITEM: BENZ LISTED BY " + Benz.seller);
		
		System.out.println("ALL BIDS ONGOING: "+sotheby.currentBlock.bids);

		jeff.makeBid(9, Benz);
		theiss.makeBid(11, Benz);
		colin.makeBid(6, Benz);
		System.out.println("BIDS FOR BENZ: "+ Benz.bidsOnItem);
		System.out.println("AUCTION ENDED FOR ITEM: BENZ !");
		//System.out.println("FILTER - CAR: "+ sotheby.filter("CAR"));
		sotheby.endAuction("BENZ");
		
		System.out.println(theiss.accountID + " funds: " + theiss.funds);
		System.out.println(jeff.accountID +" funds: " + jeff.funds);
		System.out.println(elon.accountID+" funds: " + elon.funds);
		
	}
}
