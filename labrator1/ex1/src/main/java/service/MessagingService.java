package service;

import utils.NotificationManger;

public class MessagingService {

    private final NotificationManger notificationManger;

    public MessagingService(NotificationManger notificationManger) {
        this.notificationManger = notificationManger;
    }

    public void sendMessage() {
        notificationManger.sendNotification();
    }
}
