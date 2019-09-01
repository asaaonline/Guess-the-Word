import datasource.CSVDatasource;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyArray;


import static org.junit.Assert.assertThat;

public class CSVDatasourceTest {
    @Test
    public void should_ReturnStringArray() {
        CSVDatasource csvDatasource = new CSVDatasource();
        String[] wordArray = csvDatasource.getWordArray("test.csv");
        assertThat(wordArray,not(emptyArray()));

    }
}
