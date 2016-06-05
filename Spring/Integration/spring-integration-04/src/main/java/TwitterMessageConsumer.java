
import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

/**
 * Created by sulfur on 11.03.16.
 */
@Component
public class TwitterMessageConsumer {

    private static Logger log = Logger.getLogger(TwitterMessageConsumer.class);

    @ServiceActivator
    public void consume(Message<Tweet> message) {
        // get message payload
        Tweet tweet = message.getPayload();
        // log the received tweets
        log.info("Fetched Tweet Text from @" + tweet.getFromUser()+" # " + tweet.getText() );
    }
}
