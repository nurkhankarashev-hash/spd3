public class OldSmsGateway {
    public int sendRawSms(long phoneNumber, byte[] payload) {
        if (phoneNumber <= 0) {
            return 400; 
        }
        System.out.println("Sending SMS to +" + phoneNumber + ": " + new String(payload));
        return 200; 
    }
}