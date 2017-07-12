package com.labelinsight

class Pangram {

    private static String ALL_LETTERS = ('a'..'z').join()

    private String sentence

    Pangram(String sentence) {
        this.sentence = sentence
    }

    String getMissingLetters() {
        if (!sentence) {
            return ALL_LETTERS
        }

        String uniqueCharacters = getUniqueCharacters(getCharacterSet())
        if (!uniqueCharacters) {
            return ''
        }

        uniqueCharacters
    }

    private String getCharacterSet() {
        sentence.trim().toLowerCase().toSet().sort().join().replaceAll('[^a-z]','')
    }


    private static String getUniqueCharacters(String characterSetString) {
        (ALL_LETTERS.toSet() - characterSetString.toSet()).join()
    }
}
