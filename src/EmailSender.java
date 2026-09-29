public class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String recipient,String message) throws NotificationException{
        System.out.println("Email sent to " + recipient + ": " + message);
    }

}