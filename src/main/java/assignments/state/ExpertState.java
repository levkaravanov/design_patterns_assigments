package assignments.state;

public class ExpertState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Expert is perfecting their ultimate moves...");
        character.addExperience(30);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Expert meditates deeply, feeling the flow of energy...");
        character.addHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Expert engages in a fierce battle!");
        character.reduceHealth(30);
        character.addExperience(40);
        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperiencePoints() >= 150) {
            System.out.println("Experience reached 150! It's time to advance to the Master level.");
            character.setState(new MasterState());
        }
    }
}
