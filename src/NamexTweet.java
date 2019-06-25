/**
 * @(#)NamexTweet.java
 *
 * NamexTweet application
 *
 * @author 
 * @version 1.00 2019/6/1
 */

import java.io.IOException;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class NamexTweet {
    
    private final static String CONSUMER_KEY = "hvMF7DEaB8nccbFmqZeM4SUmi";
    private final static String CONSUMER_KEY_SECRET = "ChjPEu5FlevxxLiPOFoIDO6CuxRE3sBEOxNPQMe2ClyimrR2E9";
    
public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "gK0q9H8Hv5XkmTuF37f2otbiVwSCCxoDnIZlo4AZAWHzK";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1143426186728443904-62g0pPZEL7ufjYHuB3vLonj0f2wymE";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
