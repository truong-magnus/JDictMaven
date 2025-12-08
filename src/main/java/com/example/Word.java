package com.example;

public class Word {
    private int id;           // <--- NEW: Maps to Database ID
    private String kanji;
    private String hiragana;
    private String meaning;

    // Constructor 1: Used when creating a new word (ID not generated yet)
    public Word(String kanji, String hiragana, String meaning) {
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.meaning = meaning;
    }

    // Constructor 2: Used when reading from Database (ID already exists)
    public Word(int id, String kanji, String hiragana, String meaning) {
        this.id = id;
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.meaning = meaning;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKanji() { return kanji; }
    public void setKanji(String kanji) { this.kanji = kanji; }

    public String getHiragana() { return hiragana; }
    public void setHiragana(String hiragana) { this.hiragana = hiragana; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    @Override
    public String toString() {
        // Display ID as well
        return String.format("[%d] %s - %s : %s", id, kanji, hiragana, meaning);
    }
}