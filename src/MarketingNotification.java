public class MarketingNotification extends Notification {

    public MarketingNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notifyUser(String recipient, String content) throws NotificationException {
        String promoContent = "[PROMO]: " + content;
        sender.sendMessage(recipient, promoContent);
    }
}