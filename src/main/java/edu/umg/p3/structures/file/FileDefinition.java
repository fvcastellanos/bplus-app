package edu.umg.p3.structures.file;

import edu.umg.p3.structures.tree.BTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class FileDefinition {
    private String fileName;
    private RowDefinition rowDefinition;
    private BTree<String, String> tree;
    private int size;

    public FileDefinition(RowDefinition rowDefinition) {
        fileName = UUID.randomUUID().toString();
        this.rowDefinition = rowDefinition;
        size = 0;
        tree = new BTree<>(3);
    }

    public FileDefinition(String fileName, RowDefinition rowDefinition) {
        this.fileName = fileName;
        this.rowDefinition = rowDefinition;
        size = 0;
        tree = new BTree<>(3);
    }

    public void writeRow(String data) {
        try {
            File file = new File(fileName);

            if(!file.exists()) {
                file.createNewFile();
            }

            byte [] content = data.getBytes();

            FileOutputStream fop = new FileOutputStream(file);
            fop.write(content);
            fop.flush();
            fop.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String readRow(int record) {
        String value = null;
        try {
            File file = new File(fileName);
            byte [] content = null;
            FileInputStream fis = new FileInputStream(file);
            fis.read(content, record * rowDefinition.getRowSize(), rowDefinition.getRowSize());
            fis.close();

             value = new String(content);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }

}
