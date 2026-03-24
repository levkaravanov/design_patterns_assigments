package assignments.memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Model model;
    private final Gui gui;
    private final List<IMemento> history; // Memento undo history
    private final List<IMemento> redoHistory; // Memento redo history
    private final List<IMemento> stateHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.stateHistory = new ArrayList<>();

        stateHistory.add(model.createMemento("INITIAL"));
    }

    public void setOption(int optionNumber, int choice) {
        history.add(model.createMemento());
        redoHistory.clear();

        model.setOption(optionNumber, choice);

        stateHistory.add(model.createMemento("CHANGE"));
        gui.updateHistoryView();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        history.add(model.createMemento());
        redoHistory.clear();

        model.setIsSelected(isSelected);

        stateHistory.add(model.createMemento("CHANGE"));
        gui.updateHistoryView();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            redoHistory.add(model.createMemento());

            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();

            stateHistory.add(model.createMemento("UNDO"));
            gui.updateHistoryView();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            history.add(model.createMemento());

            System.out.println("Memento found in redo history");
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();

            stateHistory.add(model.createMemento("REDO"));
            gui.updateHistoryView();
        }
    }

    public List<IMemento> getHistory() {
        return new ArrayList<>(stateHistory);
    }

    public void restoreFromHistory(IMemento memento) {
        history.add(model.createMemento());
        redoHistory.clear();

        model.restoreState(memento);
        gui.updateGui();

        stateHistory.add(model.createMemento("RESTORE"));
        gui.updateHistoryView();
    }

}
