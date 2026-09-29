public class SmsGatewayAdapter implements MessageSender{
    private OldSmsGateway oldSmsGateway;
    public SmsGatewayAdapter(OldSmsGateway oldSmsGateway){
        this.oldSmsGateway=oldSmsGateway;
    }

    @Override
    public void sendMessage(String recipient, String message) throws NotificationException {
        long phoneNumber = Long.parseLong(recipient.replace("+", ""));
        byte[] payload = message.getBytes();
        int status = oldSmsGateway.sendRawSms(phoneNumber, payload);
        if (status != 200) {
            throw new NotificationException("Failed to send SMS, gateway status: " + status);
        }
    }
}