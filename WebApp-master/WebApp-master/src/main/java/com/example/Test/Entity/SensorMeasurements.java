package com.example.Test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "sensor_measurements")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SensorMeasurements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    /**
     * Many measurments to one Sensor
     */
    //@ManyToOne
    @JoinColumn(name = "sensorId")
    private Long sensorId;
    @Column(name = "readingType")
    private String readingType;
    @Column(name = "readingValue")
    private double readingValue;
    @Column(name = "readingDate")
    private LocalDate readingDate;
    @Column(name = "description")
    private String description;
    @Column(name = "time")
    private LocalDateTime time;
}
