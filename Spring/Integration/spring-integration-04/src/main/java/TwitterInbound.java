import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sulfur on 11.03.16.
 */
public class TwitterInbound {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("/twitter-inbound.xml");

        Thread.sleep(5 * 60 * 1000);
    }
}