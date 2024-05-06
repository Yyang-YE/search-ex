package org.example.namesearch.repository;

import org.example.namesearch.entity.Building;
import org.example.namesearch.entity.BuildingNickname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingNicknameRepository extends JpaRepository<BuildingNickname, Long> {
    @Query("SELECT bn.building FROM BuildingNickname bn WHERE bn.nickname LIKE %:keyword%")
    List<Building> findAllByNicknameContaining(String keyword);
}
