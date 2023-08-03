import java.util.Objects;

public class User {
    private final String username;

    public User(String username) {
        this.username = username;
    }

     public String getUsername() {
         return username;
     }

     // Wichtig, um benutzerdefinierte Objekte zu vergleichen
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
