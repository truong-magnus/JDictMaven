package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api") // Base URL: All endpoints in this class start with /api
public class WordController {

    // Initialize Data Access Object to handle database operations
    private final WordDAO wordDAO = new WordDAO();

    // 1. API: Get all vocabulary words
    // Endpoint: http://localhost:8080/api/words
    // Method: GET
    @GetMapping("/words")
    public ArrayList<Word> getAllWords() {
        // Fetch list from Database and return as JSON
        return wordDAO.getAllWords();
    }

    // 2. API: Search words by keyword
    // Endpoint: http://localhost:8080/api/search?keyword=...
    // Example: http://localhost:8080/api/search?keyword=Teacher
    @GetMapping("/search")
    public ArrayList<Word> search(@RequestParam String keyword) {
        // Return search results as JSON
        return wordDAO.searchWord(keyword);
    }
}