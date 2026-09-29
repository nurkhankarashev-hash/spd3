public class SecurityAlertNotification extends Notification {

    public SecurityAlertNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notifyUser(String recipient, String content) throws NotificationException {
        String alertContent = "[SECURITY ALERT]: " + content;
        sender.sendMessage(recipient, alertContent);
    }
}