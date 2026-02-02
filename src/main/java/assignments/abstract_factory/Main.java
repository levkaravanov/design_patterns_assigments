package assignments.abstract_factory;

public class Main {
    public static void main(String[] args) {
        UIFactory factory;
        if (args.length > 0 && args[0].equalsIgnoreCase("B")) {
            factory = new BFactory();
        } else {
            factory = new AFactory();
        }

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Name");
        Checkbox checkbox = factory.createCheckbox("I agree");

        button.display();
        textField.display();
        checkbox.display();

        button.setText("Submit");
        button.display();
    }
}
