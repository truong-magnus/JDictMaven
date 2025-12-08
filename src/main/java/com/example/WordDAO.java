package com.example;

import java.sql.*;
import java.util.ArrayList;

public class WordDAO {

    // 1. READ: Get all words
    public ArrayList<Word> getAllWords() {
        ArrayList<Word> list = new ArrayList<>();
        String sql = "SELECT * FROM vocabularies";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Word w = new Word(
                        rs.getInt("id"),
                        rs.getString("kanji"),
                        rs.getString("hiragana"),
                        rs.getString("meaning")
                );
                list.add(w);
            }
        } catch (SQLException e) {
            System.err.println("Error getting data: " + e.getMessage());
        }
        return list;
    }

    // 2. CREATE: Add new word
    public void addWord(Word w) {
        String sql = "INSERT INTO vocabularies (kanji, hiragana, meaning) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, w.getKanji());
            pstmt.setString(2, w.getHiragana());
            pstmt.setString(3, w.getMeaning());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error adding word: " + e.getMessage());
        }
    }

    // 3. DELETE: Remove word by ID
    public void deleteWord(int id) {
        String sql = "DELETE FROM vocabularies WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("=> Success: com.example.Word with ID " + id + " deleted.");
            } else {
                System.out.println("=> Error: com.example.Word ID not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting word: " + e.getMessage());
        }
    }

    // 4. UPDATE: Update word info
    public void updateWord(Word w) {
        String sql = "UPDATE vocabularies SET kanji=?, hiragana=?, meaning=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, w.getKanji());
            pstmt.setString(2, w.getHiragana());
            pstmt.setString(3, w.getMeaning());
            pstmt.setInt(4, w.getId()); // Condition (WHERE id = ...)

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("=> Success: com.example.Word updated!");
            }
        } catch (SQLException e) {
            System.err.println("Error updating word: " + e.getMessage());
        }
    }

    // 5. SEARCH: Find words by keyword (Kanji, Hiragana or Meaning)
    public ArrayList<Word> searchWord(String keyword) {
        ArrayList<Word> list = new ArrayList<>();
        // Using LIKE %keyword% for partial match
        String sql = "SELECT * FROM vocabularies WHERE kanji LIKE ? OR hiragana LIKE ? OR meaning LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Word w = new Word(
                        rs.getInt("id"),
                        rs.getString("kanji"),
                        rs.getString("hiragana"),
                        rs.getString("meaning")
                );
                list.add(w);
            }
        } catch (SQLException e) {
            System.err.println("Error searching word: " + e.getMessage());
        }
        return list;
    }

    // 6. HELPER: Get a single word by ID (Useful for Update flow)
    public Word getWordById(int id) {
        String sql = "SELECT * FROM vocabularies WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Word(
                        rs.getInt("id"),
                        rs.getString("kanji"),
                        rs.getString("hiragana"),
                        rs.getString("meaning")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }
}