package assignments.composite;

public abstract class OrgUnit {
    public void add(OrgUnit unit) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrgUnit unit) {
        throw new UnsupportedOperationException();
    }

    public abstract int getTotalSalary();

    public abstract String toXml(String indent);
}
