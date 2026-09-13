public class ATMPinValidator {

    static void checkPinLength(String pin) {
        int length = pin.length();
        if (length != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");   // Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");  // PIN length OK.
    }
}