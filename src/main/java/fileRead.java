import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class fileRead {


    private fileRead() {
    }

    public static List<String[]> readFile(final String filepath) {
        final List<String[]> operations = new ArrayList<String[]>();

        BufferedReader br = null;
        String line = "";
        final String splitter = ";";

        try {
            br = new BufferedReader(new java.io.FileReader(filepath));
            while ((line = br.readLine()) != null) {
                final String[] row = line.split(splitter);
                //System.out.println(Arrays.asList(row));
                operations.add(row);

            }
        } catch (FileNotFoundException e) {
            System.out.print("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}