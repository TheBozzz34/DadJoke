package sender;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Main {

    static String consumerKeyStr = "HvAIEaygT9WyiaYCkWFRRXUCl";
    static String consumerSecretStr = "4aIZIp1j4KD7Vtrg5p8VFKpkK1sg4P9NBbPuExMVWndxqgUo99";
    static String accessTokenStr = "1439779035480043523-0p7JpsePNpsZ7N4E7ZJnLeYN9lXLm3";
    static String accessTokenSecretStr = "wUYpgB163m84IhEdwuZ1rg1YUJz9fNLhaDH4KP6sK7lJR";

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
