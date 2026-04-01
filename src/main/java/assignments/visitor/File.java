package assignments.visitor;

public class File implements FileSystemElement {
    private final String name;
    private final int sizeInMb;

    public File(String name, int sizeInMb) {
        this.name = name;
        this.sizeInMb = sizeInMb;
    }

    public String getName() {
        return name;
    }

    public int getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
