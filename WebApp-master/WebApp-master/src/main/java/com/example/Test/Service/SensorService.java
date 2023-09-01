package com.example.Test.Service;

import com.example.Test.Entity.Sensor;
import com.example.Test.Entity.SensorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional

public class SensorService {
    @Autowired
    private SensorRepo sensorRepo;

    public Page<Sensor> getAllSensors(Pageable pageable) {
        return sensorRepo.findAll(pageable);
    }

    public Optional<Sensor> getSensorsById(Long Id) {
        return sensorRepo.findById(Id);
    }

    public Sensor newSensor(Sensor newSensor) {
        return sensorRepo.save(newSensor);
    }

    public void deleteSensor(Long sensorId) {
        sensorRepo.deleteById(sensorId);
    }

}
