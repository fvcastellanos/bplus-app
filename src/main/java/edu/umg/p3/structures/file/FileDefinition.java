package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class FileDefinition {
    private String fileName;
    private List<RowDefinition> rows;

    public FileDefinition() {
        rows = new ArrayList<>();
        fileName = UUID.randomUUID().toString();
    }

    public FileDefinition(String fileName) {
        rows = new ArrayList<>();
        this.fileName = fileName;
    }

    public void addRow(RowDefinition rowDefinition) {
        rows.add(rowDefinition);
    }


    private String rowToString(RowDefinition rowDefinition) {

        StringBuilder builder = new StringBuilder();
        for (Field field : rowDefinition.getStructure()) {
            builder.append(field.getFullValue());
        }

        return builder.toString();
    }

    public void writeFileToDisk() {

    }
}
