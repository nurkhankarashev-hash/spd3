public class Main {
    public static void main(String[] args) {
        try {
            MessageSender smsSender = MessageSenderFactory.createSender("SMS");
            MessageSender emailSender = MessageSenderFactory.createSender("EMAIL");

            Notification alertNotification = new SecurityAlertNotification(smsSender);
            alertNotification.notifyUser("+77071234567", "Unauthorized login attempt!");

            Notification promoNotification = new MarketingNotification(emailSender);
            promoNotification.notifyUser("user@example.com", "Get 20% discount today!");

        } catch (NotificationException e) {
    System.err.println("Notification failed: " + e.getMessage());
}
    }
}