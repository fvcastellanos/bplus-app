package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fvcg2 on 2/06/2016.
 */
public class RowDefinition {
    private Set<Field> structure;

    public RowDefinition() {
        structure = new HashSet<>();
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
}
