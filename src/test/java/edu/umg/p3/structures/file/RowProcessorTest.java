package edu.umg.p3.structures.file;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class RowProcessorTest extends BaseTest {

    @Test
    public void rowProcessorTest() throws Exception {

        RowProcessor rowProcessor = buildRowProcessor();
        assertNotNull(rowProcessor);

        rowProcessor.put("key_field", "10");

        String value = rowProcessor.get("key_field");

        assertNotNull(value);
        assertThat(value, is("        10"));
    }

    @Test
    public void rowProcessorFullValueTest() throws Exception {
        RowProcessor rowProcessor = buildRowProcessor();
        rowProcessor.put("field1", "test message");
        String fullValue = rowProcessor.getFullValue();

        assertThat(fullValue.length(), is(160));
        assertTrue(fullValue.contains("test message"));
    }

}
