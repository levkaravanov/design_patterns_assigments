package assignments.proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService INSTANCE = new AccessControlService();
    private final Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public void grantAccess(String documentId, String username) {
        permissions.computeIfAbsent(documentId, key -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        Set<String> allowedUsers = permissions.get(documentId);
        if (allowedUsers == null) {
            return false;
        }
        return allowedUsers.contains(username);
    }
}
