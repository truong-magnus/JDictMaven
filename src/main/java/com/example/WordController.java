package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * REST Controller for managing Vocabulary resources.
 * Handles HTTP requests and maps them to DAO operations.
 */
@RestController
@RequestMapping("/api") // Base URL for all endpoints
@CrossOrigin(origins = "*") // Access
public class WordController {

    private final WordDAO wordDAO = new WordDAO();

    // --- 1. READ OPERATIONS ---

    /**
     * Get all words from the database.
     * Endpoint: GET /api/words
     *
     * @return List of Word objects in JSON format.
     */
    @GetMapping("/words")
    public ArrayList<Word> getAllWords() {
        return wordDAO.getAllWords();
    }

    /**
     * Search for words containing the keyword.
     * Endpoint: GET /api/search?keyword=...
     *
     * @param keyword The search term (Kanji, Hiragana, or Meaning)
     * @return List of matching words.
     */
    @GetMapping("/search")
    public ArrayList<Word> search(@RequestParam String keyword) {
        return wordDAO.searchWord(keyword);
    }

    // --- 2. CREATE OPERATION ---

    /**
     * Add a new word to the database.
     * Endpoint: POST /api/words
     *
     * @param newWord The Word object sent in the request body (JSON).
     * @return A success message.
     */
    @PostMapping("/words")
    public Map<String, String> addWord(@RequestBody Word newWord) {
        wordDAO.addWord(newWord);
        // Return a simple JSON response
        return Map.of("message", "Success! Word added to database.");
    }

    // --- 3. UPDATE OPERATION ---

    /**
     * Update an existing word by ID.
     * Endpoint: PUT /api/words/{id}
     *
     * @param id          The ID of the word to update (from URL path).
     * @param updatedWord The new data for the word (from request body).
     * @return A success message.
     */
    @PutMapping("/words/{id}")
    public Map<String, String> updateWord(@PathVariable int id, @RequestBody Word updatedWord) {
        // Set the ID from the path to the object to ensure correct update
        updatedWord.setId(id);

        wordDAO.updateWord(updatedWord);
        return Map.of("message", "Success! Word with ID " + id + " updated.");
    }

    // --- 4. DELETE OPERATION ---

    /**
     * Delete a word by ID.
     * Endpoint: DELETE /api/words/{id}
     *
     * @param id The ID of the word to delete.
     * @return A success message.
     */
    @DeleteMapping("/words/{id}")
    public Map<String, String> deleteWord(@PathVariable int id) {
        wordDAO.deleteWord(id);
        return Map.of("message", "Success! Word with ID " + id + " deleted.");
    }
}