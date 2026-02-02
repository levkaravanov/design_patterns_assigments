package assignments.composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrgUnit {
    private final String name;
    private final List<OrgUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrgUnit unit) {
        children.add(unit);
    }

    @Override
    public void remove(OrgUnit unit) {
        children.remove(unit);
    }

    @Override
    public int getTotalSalary() {
        int total = 0;
        for (OrgUnit child : children) {
            total += child.getTotalSalary();
        }
        return total;
    }

    @Override
    public String toXml(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("<department name=\"").append(name).append("\">\n");
        String childIndent = indent + "  ";
        for (OrgUnit child : children) {
            sb.append(child.toXml(childIndent));
        }
        sb.append(indent).append("</department>\n");
        return sb.toString();
    }
}
