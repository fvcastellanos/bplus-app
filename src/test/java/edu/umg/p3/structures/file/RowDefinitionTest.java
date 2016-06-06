package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by fvcg2 on 2/06/2016.
 */
public class RowDefinitionTest extends BaseTest {


    @Test
    public void rowDefinitionTest() throws Exception {
        RowDefinition row = buildRow();

        assertThat(row.getRowSize(), is(160));
        assertThat(row.getKeyField().getName(), is("key_field"));
    }

    @Test
    public void findRowTest() throws  Exception {
        RowDefinition row = buildRow();

        Field field = row.findField("key_field");
        Field notFound = row.findField("foo");

        assertThat(field.getName(), is("key_field"));
        assertNull(notFound);

    }
}
