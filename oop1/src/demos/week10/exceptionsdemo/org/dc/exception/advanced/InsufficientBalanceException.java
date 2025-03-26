package demos.week10.exceptionsdemo.org.dc.exception.advanced;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
