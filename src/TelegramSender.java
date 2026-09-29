public class TelegramSender implements MessageSender {
    @Override
    public void sendMessage(String recipient, String message) throws NotificationException {
        System.out.println("Telegram message sent to " + recipient + ": " + message);
    }
}