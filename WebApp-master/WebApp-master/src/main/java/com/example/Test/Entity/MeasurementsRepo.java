package com.example.Test.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface  MeasurementsRepo extends JpaRepository<SensorMeasurements, Long> {
    List<SensorMeasurements> findBySensorId(Long sensorId);
    SensorMeasurements save(SensorMeasurements newSensorMeasurements);
    void deleteSensorMeasurementsById(Long Id);

    Page<SensorMeasurements> findByReadingType(String readingType, Pageable pageable);
    Page<SensorMeasurements> findByTime(Date time, Pageable pageable);

    //double getMeanValue(String type);
    //double getMinValue(String type);
    //double getMaxValue(String type);
}
