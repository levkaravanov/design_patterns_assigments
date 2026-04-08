package assignments.builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        gamingDirector.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        officeDirector.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();

        System.out.println("Gaming computer:");
        System.out.println(gamingComputer);
        System.out.println();
        System.out.println("Office computer:");
        System.out.println(officeComputer);
    }
}
