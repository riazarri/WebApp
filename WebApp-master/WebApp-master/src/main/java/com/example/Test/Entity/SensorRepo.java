package com.example.Test.Entity;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepo extends PagingAndSortingRepository<Sensor, Long> {
    Optional<Sensor> findById(Long Id);
    Sensor save(Sensor newSensor);
    void deleteById(Long Id);
    List<Sensor> findByType(String type);

    List<Sensor> findByLocation(String location);
}

