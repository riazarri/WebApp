package com.example.Test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "sensor")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", unique = true, length = 10) //Set unique and length constraints for sensorId
    private Long Id;
    @Column(name = "type", nullable = false) // Make 'type' field non-nullable
    private String type;
    @Column(name = "vendorName", nullable = false) // Make 'vendorName' field non-nullable
    private String vendorName;
    @Column(name = "vendorEmail")
    private String vendorEmail;
    @Column(name = "description", length = 500) // Set maximum length for 'description'
    private String description;
    @Column(name = "location", nullable = false) // Make 'location' field non-nullable
    private String location;
}



