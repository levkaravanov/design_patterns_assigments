package assignments.decorator;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encrypted = new StringBuilder(message).reverse().toString();
        super.print(encrypted);
    }
}
