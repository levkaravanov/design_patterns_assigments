package assignments.proxy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        Library library = new Library();
        library.addPublicDocument("doc-1", LocalDate.of(2026, 3, 1), "Public document content");
        library.addProtectedDocument("doc-2", LocalDate.of(2026, 3, 15), "Protected financial report", alice, bob);
        library.addProtectedDocument("doc-3", LocalDate.of(2026, 3, 20), "Protected strategy notes", alice);

        LibraryDocument publicDocument = library.getDocument("doc-1");
        LibraryDocument protectedDocument = library.getDocument("doc-2");
        LibraryDocument restrictedDocument = library.getDocument("doc-3");

        System.out.println(publicDocument.getId() + " created: " + publicDocument.getCreationDate());
        System.out.println(publicDocument.getId() + " content for " + charlie.getUsername() + ": "
                + publicDocument.getContent(charlie));

        System.out.println(protectedDocument.getId() + " created: " + protectedDocument.getCreationDate());
        System.out.println(protectedDocument.getId() + " content for " + bob.getUsername() + ": "
                + protectedDocument.getContent(bob));

        try {
            System.out.println(restrictedDocument.getId() + " content for " + charlie.getUsername() + ": "
                    + restrictedDocument.getContent(charlie));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for " + charlie.getUsername() + " to " + restrictedDocument.getId());
        }
    }
}
