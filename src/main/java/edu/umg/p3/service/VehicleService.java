package edu.umg.p3.service;

import edu.umg.p3.structures.file.FileDefinition;
import edu.umg.p3.structures.file.RowDefinition;
import edu.umg.p3.structures.file.RowProcessor;

import java.util.Map;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class VehicleService {

    private static VehicleService vehicleService;

    private RowDefinition rowDefinition;
    private FileDefinition fileDefinition;

    public static VehicleService getInstance() {
        if(vehicleService == null) {
            vehicleService = new VehicleService();
        }

        return vehicleService;
    }

    public void createFileDefinition(String fileName, RowDefinition rowDefinition) {
        this.rowDefinition = rowDefinition;
        fileDefinition = new FileDefinition(rowDefinition);
    }

    public void addVehicle(Map<String, String> vehicle) {
        RowProcessor rowProcessor = new RowProcessor(rowDefinition);

        for(String key : vehicle.keySet()) {
            rowProcessor.put(key, vehicle.get(key));
        }

        fileDefinition.writeRow(rowProcessor.getFullValue());
    }

    public String getFileContent() {
        return fileDefinition.readFile();
    }

    public String getBTreeContent() {

        String value = "No data found";

        if(fileDefinition != null && fileDefinition.getTree() != null) {
            value = fileDefinition.getTree().traverse();
        }

        return value;
    }

    public Map<String, String> searchVehicle(String key) {
        return fileDefinition.findByKey(key);
    }

    public void setRowDefinition(RowDefinition rowDefinition) {
        this.rowDefinition = rowDefinition;
    }

    public void setFileDefinition(FileDefinition fileDefinition) {
        this.fileDefinition = fileDefinition;
    }

    public RowDefinition getRowDefinition() {
        return rowDefinition;
    }

    public FileDefinition getFileDefinition() {
        return fileDefinition;
    }
}
