package assignments.state;

public class GameCharacter {
    private String name;
    private int experiencePoints;
    private int healthPoints;

    private State currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.currentState = new NoviceState();
    }

    public void train() {
        System.out.println("Training...");
        currentState.train(this);
    }

    public void meditate() {
        System.out.println("Meditating...");
        currentState.meditate(this);
    }

    public void fight() {
        System.out.println("Fighting...");
        currentState.fight(this);
    }

    public void setState(State state) {
        this.currentState = state;
        System.out.println(">> Level up! Current state: " + state.getClass().getSimpleName());
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void addExperience(int points) {
        this.experiencePoints += points;
        System.out.println(name + " received " + points + " XP! (Total: " + experiencePoints + ")");
    }

    public void addHealth(int points) {
        this.healthPoints += points;
        System.out.println(name + " restored " + points + " HP! (Total: " + healthPoints + ")");
    }

    public void reduceHealth(int points) {
        this.healthPoints -= points;
        System.out.println(name + " lost " + points + " HP! (Remaining: " + healthPoints + ")");
    }

    public void printStatus() {
        System.out.println(String.format("[%s] Experience: %d | Health: %d | Level: %s",
                name, experiencePoints, healthPoints, currentState.getClass().getSimpleName()));
    }

}
