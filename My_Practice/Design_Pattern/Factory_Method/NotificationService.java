package Design_Pattern.Factory_Method;

import Design_Pattern.Factory_Method.Notification;
import Design_Pattern.Factory_Method.NotificationFactory;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("Hi, this is my notification!", "");
        notification.notifyUser();
    }
}
