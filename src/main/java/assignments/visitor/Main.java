package assignments.visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");
        Directory empty = new Directory("empty");

        documents.add(new File("report.txt", 10));
        documents.add(new File("notes.txt", 5));
        documents.add(new File("budget.xlsx", 8));

        images.add(new File("photo.jpg", 12));
        images.add(new File("diagram.png", 6));

        root.add(documents);
        root.add(images);
        root.add(empty);
        root.add(new File("readme.txt", 2));

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        root.accept(sizeCalculatorVisitor);

        SearchVisitor txtSearchVisitor = new SearchVisitor(".txt");
        root.accept(txtSearchVisitor);

        SearchVisitor pdfSearchVisitor = new SearchVisitor(".pdf");
        root.accept(pdfSearchVisitor);

        System.out.println("Total size: " + sizeCalculatorVisitor.getTotalSize() + " MB");
        System.out.println("Files with .txt extension:");
        for (File file : txtSearchVisitor.getFoundFiles()) {
            System.out.println(file.getName() + " - " + file.getSizeInMb() + " MB");
        }

        System.out.println("Files with .pdf extension: " + pdfSearchVisitor.getFoundFiles().size());
    }
}
