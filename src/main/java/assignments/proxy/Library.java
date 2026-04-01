package assignments.proxy;

import java.time.LocalDate;
import java.util.HashMap;

public class Library {
    private final HashMap<String, LibraryDocument> documents = new HashMap<>();

    public void addPublicDocument(String id, LocalDate creationDate, String content) {
        documents.put(id, new Document(id, creationDate, content));
    }

    public void addProtectedDocument(String id, LocalDate creationDate, String content, User... allowedUsers) {
        Document document = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(document);
        AccessControlService accessControlService = AccessControlService.getInstance();

        for (User user : allowedUsers) {
            accessControlService.grantAccess(id, user.getUsername());
        }

        documents.put(id, proxy);
    }

    public LibraryDocument getDocument(String id) {
        return documents.get(id);
    }
}
