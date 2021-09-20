package sender;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Main {

    static String consumerKeyStr = "api key";
    static String consumerSecretStr = "api secret";
    static String accessTokenStr = "consumer key";
    static String accessTokenSecretStr = "consumer secret";

    public static void main(String[] args) {

        try {

            HttpResponse<String> response = Unirest.get("https://icanhazdadjoke.com/")
                    .header("accept", "text/plain")
                    .asString();
            Twitter twitter = new TwitterFactory().getInstance();

            twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr,
                    accessTokenSecretStr);

            twitter.setOAuthAccessToken(accessToken);

            twitter.updateStatus(response.getBody());

            System.out.println("Successfully updated the status in Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

}
