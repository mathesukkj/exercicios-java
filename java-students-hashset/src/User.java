import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
    private int code;

    public User(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + code;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (code != other.code)
            return false;
        return true;
    }

    public static Set<User> readUsers(Scanner s, int qty) {
        Set<User> set = new HashSet<>();

        for (int i = 0; i < qty; i++) {
            System.out.print("How many students for Course " + (i + 1) + "? ");
            int n = s.nextInt();
            for (int j = 0; j < n; j++) {
                set.add(new User(s.nextInt()));
            }
        }

        return set;
    }

}
