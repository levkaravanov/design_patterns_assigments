package assignments.visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
