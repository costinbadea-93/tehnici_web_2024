package utils;

public class EmailNotificationMangerImpl implements NotificationManger{
    @Override
    public void sendNotification() {
        System.out.println("Sending notification via Email ....");
    }
}
