package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvcg2 on 2/06/2016.
 */
public class RowDefinition {
    private long rowNumber;
    private List<Field> structure;

    public RowDefinition() {
        structure = new ArrayList<>();
        rowNumber = 0L;
    }

    public RowDefinition(long rowNumber, List<Field> structure) {
        this.structure = structure;
        this.rowNumber = rowNumber;
    }

    public void addField(Field field) throws Exception {
        if(!alreadyExistsKey(field)) {
            structure.add(field);
        } else {
            throw new Exception("This Row already have a key");
        }
    }

    public boolean alreadyExistsKey(Field field) {
        for(Field f : structure) {
            if(f.isKey() && field.isKey()) {
                return true;
            }
        }

        return false;
    }

    public Field getKeyField() {
        for(Field field : structure) {
            if(field.isKey()) {
                return field;
            }
        }

        return null;
    }

    public int getRowSize() {
        int size = 0;
        for(Field field : structure) {
            size+= field.getSize();
        }

        return size;
    }

    public List<Field> getStructure() {
        return structure;
    }

    public void setStructure(List<Field> structure) {
        this.structure = structure;
    }

    public long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(long rowNumber) {
        this.rowNumber = rowNumber;
    }
}
