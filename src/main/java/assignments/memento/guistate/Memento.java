package assignments.memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;
    private final LocalDateTime savedAt;
    private String actionType;


    public Memento(int[] options, boolean isSelected, String actionType) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.savedAt = LocalDateTime.now();
        this.actionType = actionType;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return actionType + " | " + savedAt.format(formatter)
                + " | colors: [" + options[0] + ", " + options[1] + ", " + options[2] + "]"
                + " | checkbox: " + isSelected;
    }

    @Override
    public String toString() {
        return getDescription();
    }

}
