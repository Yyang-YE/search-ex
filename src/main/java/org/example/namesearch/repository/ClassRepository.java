package org.example.namesearch.repository;

import org.example.namesearch.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findAllByNameContaining(String keyword);
}
