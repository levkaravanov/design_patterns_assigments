package assignments.composite;

public class Employee extends OrgUnit {
    private final String name;
    private final int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getTotalSalary() {
        return salary;
    }

    @Override
    public String toXml(String indent) {
        return indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>\n";
    }
}
