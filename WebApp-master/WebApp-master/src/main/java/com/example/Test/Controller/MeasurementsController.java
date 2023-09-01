package com.example.Test.Controller;

import com.example.Test.Entity.MeasurementsRepo;
import com.example.Test.Entity.SensorMeasurements;
import com.example.Test.Entity.SensorRepo;
import com.example.Test.Service.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MeasurementsController {
    @Autowired
    private MeasurementsService measurementsService;
    @Autowired
    private MeasurementsRepo measurementsRepo;

    @GetMapping("/sensors_measurements")
    public List<SensorMeasurements> getAllSensorsMeasurements() {

        return measurementsService.getAllSensorsMeasurements();
    }


  @GetMapping("/sensors_measurements/{Id}")
    public Optional<SensorMeasurements> getMeasurementsById(@PathVariable Long Id) {

        return measurementsService.getMeasurementsById(Id);
    }

    @PostMapping("/sensors_measurements")
    public void newSensorMeasurements(@RequestBody SensorMeasurements newSensorMeasurements) {
        measurementsService.newSensorMeasurements(newSensorMeasurements);
    }

    @DeleteMapping("sensors_measurements/{Id}")
    public void deleteSensorMeasurements(@PathVariable Long Id) {
        measurementsService.deleteSensorMeasurements(Id);
    }

    //methods to bring sensors with type , location, time parameters
    @GetMapping("/sensors/byType")
    public Page<SensorMeasurements> getSensorsByReadingType(@RequestParam String readingType,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return measurementsService.getSensorsByReadingType(readingType, pageable);
    }
    @GetMapping("/sensors/byLocation")
    public List<SensorMeasurements> getSensorsByLocation(@RequestParam String location,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return measurementsService.getSensorsByLocation(location, pageable);
    }
    @GetMapping("/sensors/byTime")
    public Page<SensorMeasurements> getSensorsByTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return measurementsService.getSensorsByTime(time, pageable);
    }

    //4
    @GetMapping("/sensors/meanValue")
    public double findMeanValue (@RequestParam("type") String type ) {
        double meanValue = measurementsService.getMeanValue(type);
       // return measurementsService.getmeanValue(meanValue);
        return meanValue;
    }
    @GetMapping("/sensors/minValue")
    public double findMinValue (@RequestParam("type") String type ) {
        double minValue = measurementsService.getMinValue(type);
        return minValue;
    }
    @GetMapping("/sensors/maxValue")
    public double findMaxValue (@RequestParam("type") String type ) {
        double maxValue = measurementsService.getMaxValue(type);
        return maxValue;
    }

}
