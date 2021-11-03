import java.sql.Timestamp;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Tester {
	public static void main (String[] args) {
		Auction sotheby = new Auction();
       // int timeRemain = 300000;
        //Timer timer = new Timer();
//        class Helper extends TimerTask
//        {
//            public void run()
//            {
//                Sotheby.endAuction("TESLA CAR");
//            }
//        }
       // TimerTask task = new Helper();
          
      //  timer.schedule(task, timeRemain);//5 mins initial time limit. This is added on with each bid in the last 45 seconds. 
        
		User jeff = new User("jeffbezos", "blahblah", 1000);
		sotheby.signupUser(jeff.accountID, jeff);
		User theiss = new User("mrtheiss", "HELIUMTOTHEMOON", 1500);
		sotheby.signupUser(theiss.accountID, theiss);
		User colin = new User("colinyuan", "DOGECOIN", 10.0);
		sotheby.signupUser(colin.accountID, colin);
		User elon = new User("elonmusk", "TOTHEMOON", 0);
		sotheby.signupUser(elon.accountID, elon);
		System.out.println("USERS " + sotheby.users);
		
		Item Tesla = jeff.listItem(1000, "TESLA", "MODEL S PLAID", "CAR");
		sotheby.addItemToBlock(Tesla);
		System.out.println("ITEM: TESLA LISTED BY " + Tesla.seller);
		
		Item Benz = jeff.listItem(10000, "BENZ", "BENZ SEDAN", "CAR");
		sotheby.addItemToBlock(Benz);
		System.out.println("ITEM: BENZ LISTED BY " + Benz.seller);
		
		System.out.println("ALL BIDS ONGOING: "+sotheby.currentBlock.bids);
		jeff.makeBid(500.00, Tesla);
		theiss.makeBid(0.99, Tesla);
		colin.makeBid(1000, Tesla);//fail case - insufficient funds
		System.out.println("BIDS FOR TESLA: "+ Tesla.bidsOnItem);
		System.out.println("FILTER - CAR: "+ sotheby.filter("CAR"));
		sotheby.endAuction("TESLA");
		System.out.println("AUCTION ENDED FOR ITEM: TESLA !");
		System.out.println(theiss.accountID + " funds: " + theiss.funds);
		System.out.println(jeff.accountID +" funds: " + jeff.funds);
		System.out.println(elon.accountID+" funds: " + elon.funds);
		
		
		
	}
}
