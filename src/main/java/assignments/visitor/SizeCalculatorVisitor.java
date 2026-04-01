package assignments.visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize;

    @Override
    public void visit(File file) {
        totalSize += file.getSizeInMb();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}
