package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by fvcg2 on 2/06/2016.
 */
public class RowDefinitionTest {

    private Field buildField(int order, String name, int size, boolean key) {
        return Field.newBuilder()
                .withOrder(order)
                .withName(name)
                .withSize(size)
                .withKey(key)
                .build();
    }

    private RowDefinition buildRow() throws Exception {
        RowDefinition row = new RowDefinition();
        row.addField(buildField(1, "key_field", 10, true));
        row.addField(buildField(2, "field1", 100, false));
        row.addField(buildField(3, "field2", 50, false));

        return row;
    }

    @Test
    public void rowDefinitionTest() throws Exception {
        RowDefinition row = buildRow();

        assertThat(row.getRowSize(), is(160));
        assertThat(row.getKeyField().getName(), is("key_field"));
    }
}
