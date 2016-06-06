package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class BaseTest {

    protected Field buildField(int order, String name, int size, boolean key) {
        return Field.newBuilder()
                .withOrder(order)
                .withName(name)
                .withSize(size)
                .withKey(key)
                .build();
    }

    protected RowDefinition buildRow() throws Exception {
        RowDefinition row = new RowDefinition();
        row.addField(buildField(1, "key_field", 10, true));
        row.addField(buildField(2, "field1", 100, false));
        row.addField(buildField(3, "field2", 50, false));

        return row;
    }

    protected RowProcessor buildRowProcessor() throws Exception {
        RowProcessor rowProcessor = new RowProcessor(buildRow());
        return rowProcessor;
    }

}
