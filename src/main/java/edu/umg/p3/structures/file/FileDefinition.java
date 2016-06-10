package edu.umg.p3.structures.file;

import edu.umg.p3.dto.Field;
import edu.umg.p3.structures.tree.BTree;

import java.io.*;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class FileDefinition {
    private String fileName;
    private RowDefinition rowDefinition;
//    private RowProcessor rowProcessor;
    private BTree<String, Integer> tree;
    private int size;

    private void addToBPlusTree(String data) {
        RowProcessor rowProcessor = new RowProcessor(rowDefinition);
        Map<String, String> map = rowProcessor.process(data);
        Field field = rowDefinition.getKeyField();
        String key = map.get(field.getName());
        tree.insert(key.trim(), size);
        size++;
    }

    private void initFile(String fileName, RowDefinition rowDefinition) {
        this.fileName = fileName;
        this.rowDefinition = rowDefinition;
        size = 0;
        tree = new BTree<>(3);
//        rowProcessor = new RowProcessor(rowDefinition);
    }

    public FileDefinition(RowDefinition rowDefinition) {
        fileName = UUID.randomUUID().toString();
        initFile(fileName, rowDefinition);
    }

    public FileDefinition(String fileName, RowDefinition rowDefinition) {
        initFile(fileName, rowDefinition);
    }

    public void writeRow(String data) {
        try {
            File file = new File(fileName);

            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();

            addToBPlusTree(data);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String readRow(int record) {
        String value = null;
        try {
            byte [] content = new byte[rowDefinition.getRowSize()];
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
            randomAccessFile.seek(record * rowDefinition.getRowSize());

            randomAccessFile.read(content);

            randomAccessFile.close();

            value = new String(content);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }

    public Map<String, String> readRecord(int record) {
        RowProcessor rowProcessor = new RowProcessor(rowDefinition);
        Map<String, String> value = null;

        String row = readRow(record);
        if(row != null) {
            value = rowProcessor.process(row);
        }

        return value;
    }

    public Map<String, String> findByKey(String key) {
        Map<String, String> value = null;

        Integer record = tree.search(key);
        if (record != null) {
           value = readRecord(record);
        }

        return value;
    }

    public String readFile() {
        String value = null;

        try {
            StringBuilder sb = new StringBuilder();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            byte [] content;
            for(int i=0;i<size;i++) {
                content = new byte[rowDefinition.getRowSize()];
                fis.read(content);
                sb.append(new String(content));
            }

            value = sb.toString();

            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }

    public BTree<String, Integer> getTree() {
        return tree;
    }
}
