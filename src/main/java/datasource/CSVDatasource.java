package datasource;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVDatasource implements DataSource {

    List<String> records = new ArrayList<String>();

    public String[] getWordArray(String string) {
        try (Scanner scanner = new Scanner(new File(string));) {
            while (scanner.hasNextLine()) {
                List<String> recordFromLine = getRecordFromLine(scanner.nextLine());
                for (String s : recordFromLine
                ) {
                    records.add(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] strings = records.toArray(new String[records.size()]);
        return strings;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
