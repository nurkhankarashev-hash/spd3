public interface MessageSender {

    void sendMessage(String recipent,String message) throws NotificationException;
}