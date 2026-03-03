package assignments.state;

public class MasterState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Master knows every technique. Training is no longer necessary.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Master transcends space and time during meditation...");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Master wins the fight with a single, flawless strike! (No health lost)");
        character.addExperience(10);
    }
}
