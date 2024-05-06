package org.example.namesearch.repository;

import org.example.namesearch.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findAllByTypeContaining(String keyword);
}
