package com.example.Test.Controller;

import com.example.Test.Entity.Sensor;
import com.example.Test.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class SensorController {
    @Autowired
    private SensorService sensorService ;
    //@GetMapping("/sensors")
    //public List<Sensor> getAllSensors() {
       // return sensorService.getAllSensors();
    //}

    //start paging
    @GetMapping("/sensors/")
    public Page<Sensor> getAllSensors(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sensorService.getAllSensors(pageable);
    }

    @GetMapping("/sensors/{sensorsById}")
    public Optional<Sensor> getSensorById(@PathVariable Long Id) {
        return sensorService.getSensorsById(Id);
    }

    @PostMapping("/sensors")
    public void newSensor(@RequestBody Sensor newSensor) {
        sensorService.newSensor(newSensor);
    }

    @DeleteMapping("/sensors/{sensorId}")
    public void deleteSensor(@PathVariable Long sensorId) {
        sensorService.deleteSensor(sensorId);
    }


}


