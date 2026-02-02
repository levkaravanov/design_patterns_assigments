package assignments.composite;

public class Main {
    public static void main(String[] args) {
        Department root = new Department("Organization");
        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");

        root.add(engineering);
        root.add(sales);

        engineering.add(new Employee("Alice", 5000));
        engineering.add(new Employee("Bob", 4500));
        sales.add(new Employee("Carol", 4000));

        System.out.println("Total salary: " + root.getTotalSalary());
        System.out.print(root.toXml(""));
    }
}
