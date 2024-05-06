package org.example.namesearch.repository;

import org.example.namesearch.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findAllByNameContaining(String keyword);


}
