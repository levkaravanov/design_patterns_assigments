package assignments.state;

public class IntermediateState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Intermediate is refining techniques...");
        character.addExperience(25);

        if (character.getExperiencePoints() >= 100) {
            System.out.println("Experience reached 100! It's time to advance to the Expert level.");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Intermediate is meditating and focusing the mind...");
        character.addHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediate feels not ready for real fights yet. (Action not available)");
    }
}
