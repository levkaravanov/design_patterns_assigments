package assignments.proxy;

import java.time.LocalDate;

public interface LibraryDocument {
    String getId();
    LocalDate getCreationDate();
    String getContent(User user);
}
