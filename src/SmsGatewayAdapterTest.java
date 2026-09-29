public class SmsGatewayAdapterTest {

    public static void main(String[] args) {
        System.out.println("=== RUNNING TESTS ===");

        try {
            testSendMessage_Success();
            System.out.println("[PASSED] Test 1: Successful SMS sending (Status 200)");
        } catch (Exception e) {
            System.err.println("[FAILED] Test 1: " + e.getMessage());
        }

        try {
            testSendMessage_ThrowsExceptionOn400();
            System.out.println("[PASSED] Test 2: Error handling for Status 400");
        } catch (Exception e) {
            System.err.println("[FAILED] Test 2: " + e.getMessage());
        }

        try {
            testSendMessage_ThrowsExceptionOn500();
            System.out.println("[PASSED] Test 3: Error handling for Status 500");
        } catch (Exception e) {
            System.err.println("[FAILED] Test 3: " + e.getMessage());
        }

        System.out.println("=== ALL TESTS COMPLETED ===");
    }

    public static void testSendMessage_Success() throws NotificationException {
        OldSmsGateway gateway = new OldSmsGateway();
        SmsGatewayAdapter adapter = new SmsGatewayAdapter(gateway);

        adapter.sendMessage("+77071234567", "Test Message");
    }

    public static void testSendMessage_ThrowsExceptionOn400() {
        OldSmsGateway fakeGateway = new OldSmsGateway() {
            @Override
            public int sendRawSms(long phoneNumber, byte[] payload) {
                return 400; 
            }
        };

        SmsGatewayAdapter adapter = new SmsGatewayAdapter(fakeGateway);

        boolean exceptionThrown = false;
        try {
            adapter.sendMessage("+77071234567", "Test Message");
        } catch (NotificationException e) {
            exceptionThrown = true;
        }

        if (!exceptionThrown) {
            throw new RuntimeException("Expected NotificationException for status 400, but none was thrown!");
        }
    }

    public static void testSendMessage_ThrowsExceptionOn500() {
        OldSmsGateway fakeGateway = new OldSmsGateway() {
            @Override
            public int sendRawSms(long phoneNumber, byte[] payload) {
                return 500; 
            }
        };

        SmsGatewayAdapter adapter = new SmsGatewayAdapter(fakeGateway);

        boolean exceptionThrown = false;
        try {
            adapter.sendMessage("+77071234567", "Test Message");
        } catch (NotificationException e) {
            exceptionThrown = true;
        }

        if (!exceptionThrown) {
            throw new RuntimeException("Expected NotificationException for status 500, but none was thrown!");
        }
    }
}