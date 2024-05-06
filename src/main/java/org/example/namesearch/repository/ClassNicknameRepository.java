package org.example.namesearch.repository;

import org.example.namesearch.entity.Building;
import org.example.namesearch.entity.Class;
import org.example.namesearch.entity.ClassNickname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassNicknameRepository extends JpaRepository<ClassNickname, Long> {
    @Query("SELECT cn.classs FROM ClassNickname cn WHERE cn.nickname LIKE %:keyword%")
    List<Class> findAllByNicknameContaining(String keyword);
}
