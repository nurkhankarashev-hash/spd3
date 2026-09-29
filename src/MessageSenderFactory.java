public class MessageSenderFactory {

    public static MessageSender createSender(String type) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailSender();
        } else if ("TELEGRAM".equalsIgnoreCase(type)) {
            return new TelegramSender();
        } else if ("SMS".equalsIgnoreCase(type)) {
            OldSmsGateway legacyGateway = new OldSmsGateway();
            return new SmsGatewayAdapter(legacyGateway);
        }
        throw new IllegalArgumentException("Unknown sender type: " + type);
    }
}