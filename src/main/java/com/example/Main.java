package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Call DAO instead of using local ArrayList
    private static final WordDAO wordDAO = new WordDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to J-Dict Pro (Database Version)");

        while (true) {
            System.out.println("\n--- MENU (MySQL) ---");
            System.out.println("1. Add new word");
            System.out.println("2. Show all words");
            System.out.println("3. Search word");
            System.out.println("4. Update word");
            System.out.println("5. Delete word");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addNewWord(scanner); break;
                case "2": showAllWords(); break;
                case "3": searchWord(scanner); break;
                case "4": updateWord(scanner); break;
                case "5": deleteWord(scanner); break;
                case "6":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addNewWord(Scanner scanner) {
        System.out.println("\n--- ADD NEW WORD ---");
        System.out.print("Enter Kanji: ");
        String k = scanner.nextLine();
        System.out.print("Enter Hiragana: ");
        String h = scanner.nextLine();
        System.out.print("Enter Meaning: ");
        String m = scanner.nextLine();

        Word w = new Word(k, h, m);
        wordDAO.addWord(w); // Send to Database
        System.out.println("=> Saved to Database!");
    }

    private static void showAllWords() {
        System.out.println("\n--- VOCABULARY LIST (FROM DB) ---");
        // Fetch fresh data from DB every time
        ArrayList<Word> list = wordDAO.getAllWords();

        if (list.isEmpty()) {
            System.out.println("Database is empty.");
        } else {
            for (Word word : list) {
                System.out.println(word.toString());
            }
        }
    }

    private static void searchWord(Scanner scanner) {
        System.out.println("\n--- SEARCH WORD ---");
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        ArrayList<Word> results = wordDAO.searchWord(keyword);
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Word w : results) {
                System.out.println(w.toString());
            }
        }
    }

    private static void deleteWord(Scanner scanner) {
        System.out.println("\n--- DELETE WORD ---");
        showAllWords(); // Show list so user knows the ID
        System.out.print("Enter ID to delete (Check the number inside []): ");

        try {
            int id = Integer.parseInt(scanner.nextLine());
            wordDAO.deleteWord(id);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format.");
        }
    }

    private static void updateWord(Scanner scanner) {
        System.out.println("\n--- UPDATE WORD ---");
        showAllWords();
        System.out.print("Enter ID to update: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            // 1. Check if ID exists in DB
            Word currentWord = wordDAO.getWordById(id);
            if (currentWord == null) {
                System.out.println("Error: ID not found.");
                return;
            }

            System.out.println("Updating: " + currentWord.toString());
            System.out.println("(Press Enter to keep current value)");

            // 2. Input new values
            System.out.print("New Kanji [" + currentWord.getKanji() + "]: ");
            String newKanji = scanner.nextLine();
            if (!newKanji.isEmpty()) currentWord.setKanji(newKanji);

            System.out.print("New Hiragana [" + currentWord.getHiragana() + "]: ");
            String newHiragana = scanner.nextLine();
            if (!newHiragana.isEmpty()) currentWord.setHiragana(newHiragana);

            System.out.print("New Meaning [" + currentWord.getMeaning() + "]: ");
            String newMeaning = scanner.nextLine();
            if (!newMeaning.isEmpty()) currentWord.setMeaning(newMeaning);

            // 3. Push update to DB4
            wordDAO.updateWord(currentWord);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format.");
        }
    }
}