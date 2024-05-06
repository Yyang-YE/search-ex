package org.example.namesearch.controller;

import org.example.namesearch.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/find")
    public List<String> findAllByNameContaining(@RequestParam String content) {
        List<String> result = searchService.searchBuilding(content);
        result.addAll(searchService.searchClass(content));
        result.addAll(searchService.searchFacility(content));
        return result;
    }

}
