package utils;

public class SmsNotificationManagerImpl implements NotificationManger{
    @Override
    public void sendNotification() {
        System.out.println("Sending notification via SMS ....");
    }
}
