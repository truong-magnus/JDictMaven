-- Database Schema for J-Dict Lite

CREATE DATABASE IF NOT EXISTS jdict_db;

USE jdict_db;

CREATE TABLE IF NOT EXISTS vocabularies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kanji VARCHAR(50) NOT NULL,
    hiragana VARCHAR(50),
    meaning VARCHAR(255)
);

-- Sample Data
INSERT INTO vocabularies (kanji, hiragana, meaning) VALUES
('先生', 'せんせい', 'Teacher'),
('学生', 'がくせい', 'Student');