package com.example;

/**
 * Represents a vocabulary entity in the system.
 * Maps directly to the 'vocabularies' table in the database.
 */
public class Word {
    private int id;           // Primary Key
    private String kanji;     // e.g., 食べる
    private String hiragana;  // e.g., たべる
    private String meaning;   // e.g., To eat

    // --- CONSTRUCTORS ---

    /**
     * Default constructor.
     * Required by Spring Boot (Jackson) for JSON deserialization.
     */
    public Word() {
    }

    /**
     * Constructor for creating a new word before saving to DB (no ID yet).
     *
     * @param kanji    The Kanji character
     * @param hiragana The Hiragana reading
     * @param meaning  The meaning in English/Vietnamese
     */
    public Word(String kanji, String hiragana, String meaning) {
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.meaning = meaning;
    }

    /**
     * Constructor for mapping data from DB (ID exists).
     */
    public Word(int id, String kanji, String hiragana, String meaning) {
        this.id = id;
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.meaning = meaning;
    }

    // --- GETTERS & SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s : %s", id, kanji, hiragana, meaning);
    }
}