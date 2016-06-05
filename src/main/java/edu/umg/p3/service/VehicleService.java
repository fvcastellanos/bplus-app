package edu.umg.p3.service;

import edu.umg.p3.structures.file.FileDefinition;
import edu.umg.p3.structures.file.RowDefinition;

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
