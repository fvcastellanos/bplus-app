package edu.umg.p3.structures.file;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(value, is("        10"));

    }

}
