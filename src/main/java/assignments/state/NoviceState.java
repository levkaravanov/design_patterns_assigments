package assignments.state;

public class NoviceState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Novice is training hard on dummies...");
        character.addExperience(20);

        if (character.getExperiencePoints() >= 50) {
            System.out.println("Experience reached 50! It's time to advance to the next level.");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novice tries to meditate, but constantly gets distracted. (Action not available)");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novice is too weak for real fights. (Action not available)");
    }
}
