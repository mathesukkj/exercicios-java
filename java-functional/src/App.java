import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Employee> list = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter salary for filtering: ");
        double filterSalary = s.nextDouble();
        s.close();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\in.csv"))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));

                line = br.readLine();
            }

            List<String> filteredSalaryList = list.stream()
                    .filter(x -> x.getSalary() > filterSalary)
                    .map(x -> x.getEmail())
                    .sorted()
                    .toList();

            System.out.println("Email of employees whose salary is greater than $2000.00: ");
            for (String salary : filteredSalaryList) {
                System.out.println(salary);
            }

            double salarySum = list.stream()
                    .filter(x -> x.getName().charAt(0) == 'M')
                    .map(x -> x.getSalary())
                    .reduce(0.0, (x, y) -> x + y);
            System.out.println("Salary of people whose name starts with 'M': " + salarySum);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
