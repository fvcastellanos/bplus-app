package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.leftPad;
import static org.apache.commons.lang.StringUtils.repeat;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class RowProcessor {

    private RowDefinition rowDefinition;
    private Map<String, String> rowMap;

    public RowProcessor(RowDefinition rowDefinition) {
        this.rowDefinition = rowDefinition;
        rowMap = new HashMap<>();
        buildRowMap();
    }

    private void buildRowMap() {
        List<Field> list = rowDefinition.getStructure();

        for(Field field : list) {
            rowMap.put(field.getName(), repeat(" ", field.getSize()));
        }
    }

    public void put(String name, String value) {
        Field field = rowDefinition.findField(name);
        if(field != null) {
            String str = null;

            if(value.length() > field.getSize()) {
                str = value.substring(0, field.getSize() - 1);
            } else {
                str = leftPad(value, field.getSize(), " ");
            }

            rowMap.put(name, str);
        }
    }

    public Map<String, String> process(String data) {

        List<Field> fields = rowDefinition.getStructure();

        int i = 0;
        for(Field field : fields)  {
            put(field.getName(),
                    data.substring(rowDefinition.getOrderSize(i),
                            rowDefinition.getOrderSize(i) + field.getSize()
                    )
            );
            i++;
        }

        return rowMap;
    }

    public String get(String name) {
        return rowMap.get(name);
    }

    public String getFullValue() {
        StringBuilder sb = new StringBuilder();
        List<Field> fields = rowDefinition.getStructure();
        for(Field field : fields) {
            sb.append(rowMap.get(field.getName()));
        }

        return sb.toString();
    }
}
