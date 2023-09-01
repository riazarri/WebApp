package com.example.Test.Service;

import com.example.Test.Entity.MeasurementsRepo;
import com.example.Test.Entity.Sensor;
import com.example.Test.Entity.SensorMeasurements;
import com.example.Test.Entity.SensorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class MeasurementsService {
    @Autowired
    private MeasurementsRepo measurementsRepo;
    @Autowired
    private SensorRepo sensorRepo;
    double positiveInfinity = Double.POSITIVE_INFINITY;
    double negativeInfinity = Double.NEGATIVE_INFINITY;

    public List<SensorMeasurements> getAllSensorsMeasurements() {
        return measurementsRepo.findAll();
    }

    public Optional<SensorMeasurements> getMeasurementsById(Long Id) {
        return measurementsRepo.findById(Id);
    }

    public SensorMeasurements newSensorMeasurements(SensorMeasurements newSensorMeasurements) {
        return measurementsRepo.save(newSensorMeasurements);
    }

    public void deleteSensorMeasurements(long Id) {
        measurementsRepo.deleteSensorMeasurementsById(Id);
    }

    //findByReadingValue
    //public List<SensorMeasurements> findByReadingValue()

    //pull 3 sensors
    public Page<SensorMeasurements> getSensorsByReadingType(String readingType, Pageable pageable) {
        return measurementsRepo.findByReadingType(readingType, pageable);
    }

    public List<SensorMeasurements> getSensorsByLocation(String location, Pageable pageable) {
        List<Sensor> sensors = sensorRepo.findByLocation(location);
        ArrayList<Long> ids = new ArrayList<>();

        List<SensorMeasurements> measurements = new ArrayList<>();
        for (Sensor sensor : sensors) {
            ids.add(sensor.getId());

        }
        System.out.println(ids);
        for (Long id : ids) {
            measurements.addAll(measurementsRepo.findBySensorId(id));

        }
        System.out.println(measurements);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), measurements.size());
        Page<SensorMeasurements> page = new PageImpl<>(measurements.subList(start, end), pageable, measurements.size());
        return measurements;
    }

    public Page<SensorMeasurements> getSensorsByTime(Date time, Pageable pageable) {
        return measurementsRepo.findByTime(time, pageable);
    }
    //4.meanValue
    public double getMeanValue(String type) {
        List<Sensor> sensors = sensorRepo.findByType(type);
        List<Long> ids = new ArrayList<>();
        List<SensorMeasurements> measurements = new ArrayList<>();
        double sum = 0.0;
        List<Double> readingValues = new ArrayList<>();
        for (Sensor sensor : sensors) {
            ids.add(sensor.getId());

        }
        System.out.println(measurements);
        for (Long id : ids) {
            measurements.addAll(measurementsRepo.findBySensorId(id));

        }
        for (SensorMeasurements sensorMeasurements : measurements) {
            readingValues.add(sensorMeasurements.getReadingValue());
            sum += sensorMeasurements.getReadingValue();
        }
        return sum / readingValues.size();
    }

    //4.minValue
    public double getMinValue(String type) {
        List<Sensor> sensors = sensorRepo.findByType(type);
        List<Long> ids = new ArrayList<>();
        List<SensorMeasurements> measurements = new ArrayList<>();
        //double sum = 0.0;
        List<Double> readingValues = new ArrayList<>();
        for (Sensor sensor : sensors) {
            ids.add(sensor.getId());
        }
        System.out.println(measurements);
        for (Long id : ids) {
            measurements.addAll(measurementsRepo.findBySensorId(id));
        }

        double minValue = measurements.get(0).getReadingValue();
        for (SensorMeasurements sensorMeasurements : measurements) {
            double readingValue = sensorMeasurements.getReadingValue();
            readingValues.add(readingValue);
            // double firstreadingValue = readingValues.get(0);
            if (readingValue < minValue) {
                minValue = readingValue; // Update minimum value if a smaller value is found
            }
        }
        return minValue;
    }
    //4.maxValue
    public double getMaxValue(String type) {
        List<Sensor> sensors = sensorRepo.findByType(type);
        List<Long> ids = new ArrayList<>();
        List<SensorMeasurements> measurements = new ArrayList<>();
        List<Double> readingValues = new ArrayList<>();
        for (Sensor sensor : sensors) {
            ids.add(sensor.getId());
        }
        System.out.println(measurements);
        for (Long id : ids) {
            measurements.addAll(measurementsRepo.findBySensorId(id));
        }
        double maxValue = 0;
        for (SensorMeasurements sensorMeasurements : measurements) {
            double readingValue = sensorMeasurements.getReadingValue();
            readingValues.add(readingValue);

            if (readingValue > maxValue) {
                maxValue = readingValue; // Update maximum value if a bigger value is found
            }
        }
        return maxValue;
    }
}



