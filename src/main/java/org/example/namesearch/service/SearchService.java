package org.example.namesearch.service;

import org.example.namesearch.entity.Building;
import org.example.namesearch.entity.Class;
import org.example.namesearch.entity.Facility;
import org.example.namesearch.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final BuildingRepository buildingRepository;
    private final BuildingNicknameRepository buildingNicknameRepository;
    private final ClassRepository classRepository;
    private final ClassNicknameRepository classNicknameRepository;
    private final FacilityRepository facilityRepository;

    public SearchService(BuildingRepository buildingRepository, BuildingNicknameRepository buildingNicknameRepository, ClassRepository classRepository, ClassNicknameRepository classNicknameRepository, FacilityRepository facilityRepository) {
        this.buildingRepository = buildingRepository;
        this.buildingNicknameRepository = buildingNicknameRepository;
        this.classRepository = classRepository;
        this.classNicknameRepository = classNicknameRepository;
        this.facilityRepository = facilityRepository;
    }

    public List<String> searchBuilding(String keyword) {
        //건물명만 조회하기!!!
        //먼저 일반 건물명 조회
        List<Building> buildings = buildingRepository.findAllByNameContaining(keyword);
        buildings.addAll(buildingNicknameRepository.findAllByNicknameContaining(keyword));

        List<String> names = buildings.stream()
            .map(Building::getName)
            .toList();
        return names.stream().distinct().collect(Collectors.toList());
    }
    public List<String> searchClass(String keyword) {
        //얘는 나머지 전체
        String[] temp = keyword.split("&");

        //만약 빌딩명 확정 상태면 해당 정보 관련해서만 찾기로!!
        //우당교양관&101호 >> 건물 확정시 이렇게 넘어온다고 가정
        List<Class> classes = new ArrayList<>();
        List<String> result;

        //class 찾기
        if(temp.length == 1) {
            //건물확정X 상태
            classes.addAll(findClass(temp[0]));
            result = classes.stream()
                .map(obj -> obj.getBuilding().getName() + " " + obj.getName())
                .collect(Collectors.toList());
        } else {
            //건물확정O 상태, 건물명+강의실명 return
            classes.addAll(findClass(temp[1]));
            result = classes.stream()
                .map(obj -> temp[0] + " " + obj.getName())
                .collect(Collectors.toList());
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

    private List<Class> findClass(String keyword) {
        List<Class> classes = classRepository.findAllByNameContaining(keyword);
        classes.addAll(classNicknameRepository.findAllByNicknameContaining(keyword));
        return classes;
    }

    public List<String> searchFacility(String keyword) {
        List<Facility> facilities = facilityRepository.findAllByTypeContaining(keyword);

        List<String> types = facilities.stream()
            .map(Facility::getType)
            .toList();
        return types.stream().distinct().collect(Collectors.toList());
    }
}
