import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\in.csv"))) {
            String line = br.readLine();
            Map<String, Integer> map = new HashMap<>();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if (map.containsKey(name)) {
                    votes += map.get(name);
                }

                map.put(name, votes);

                line = br.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
