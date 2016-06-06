package edu.umg.p3.controllers;

import edu.umg.p3.service.VehicleService;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class BaseController {

    protected VehicleService vehicleService = VehicleService.getInstance();
}
