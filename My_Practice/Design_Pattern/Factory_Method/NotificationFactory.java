package Design_Pattern.Factory_Method;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NotificationFactory {

    public Notification createNotification(String msg, String c){
        System.out.println(msg);
        String channel = c;
        if (channel == null || channel.isEmpty()){
            List<String> l = Arrays.asList("SMS","EMAIL","PUSH");
            Random rand = new Random();
            channel = l.get(rand.nextInt(l.size()));
        }

        if ("SMS".equalsIgnoreCase(channel)){
            return new SMSNotification();
        }else if ("EMAIL".equalsIgnoreCase(channel)){
            return new EmailNotification();
        }else if ("PUSH".equalsIgnoreCase(channel)){
            return new PushNotification();
        }
        return null;
    }
}
