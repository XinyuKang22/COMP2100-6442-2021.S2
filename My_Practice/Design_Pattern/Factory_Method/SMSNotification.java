package Design_Pattern.Factory_Method;

import Design_Pattern.Factory_Method.Notification;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}
