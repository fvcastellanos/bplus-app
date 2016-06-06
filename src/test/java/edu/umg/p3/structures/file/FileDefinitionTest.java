package edu.umg.p3.structures.file;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class FileDefinitionTest extends BaseTest {

    @Test
    public void fileCreationTest() throws Exception {
        RowDefinition rowDefinition = buildRow();
        RowProcessor rowProcessor = buildRowProcessor();
        String fileName = "test.txt";
        FileDefinition file = new FileDefinition(fileName, rowDefinition);

        rowProcessor.put("key_field", "10");
        rowProcessor.put("field1", "hello world");
        rowProcessor.put("field2", "bye world");

        file.writeRow(rowProcessor.getFullValue());

        Map<String, String> map = file.findByKey("10");

        assertThat(map.get("key_field").trim(), is("10"));
        assertThat(map.get("field1").trim(), is("hello world"));
        assertThat(map.get("field2").trim(), is("bye world"));

    }
}
