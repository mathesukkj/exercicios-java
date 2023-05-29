import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("How many courses? ");
            int qtyCourses = s.nextInt();
            if (qtyCourses <= 0) {
                throw new Exception("ERRO! Digite um valor maior que 0.");
            }
            System.out.println();

            Set<?> set = User.readUsers(s, qtyCourses);

            System.out.print("Total students: ");
            System.out.println(set.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
