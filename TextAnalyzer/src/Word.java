public class Word {
    String word;

    public Word() {
        this("");
    }

    public Word(String w) {
        word = w;
    }

    public int numDiphthongs() {
        int numDiphthongs = 0;

        for(int i = 1; i < word.length(); i++) {
            String temp = word.substring(i-1,i) + word.substring(i,i+1);
            temp = temp.toLowerCase();
            if(temp.equals("aw") || temp.equals("au") || temp.equals("ew") || temp.equals("oo") ||temp.equals("oi") ||
                    temp.equals("oy") || temp.equals("ow") || temp.equals("ou") || temp.equals("ea") || temp.equals("aa") || temp.equals("io")
                    || temp.equals("oa") || temp.equals("ie")) {
                numDiphthongs++;
            }
        }
        return numDiphthongs;
    }

    public int numVowels() {
        int numVowels = 0;
        for (int i = 0; i < word.length(); i++) {
            String character = word.substring(i, i+1);
            if(isVowel(character)) {
                numVowels++;
            }
        }
        return numVowels;
    }

    public boolean isVowel(String character) {
        character = character.toLowerCase();
        if(character.equals("a") || character.equals("e") || character.equals("i") || character.equals("o") || character.equals("u") || character.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public int numSilent() {

        int numSilent = 0;

        if(word.length() >= 3) {
            String[] charArray = word.split("");
            int length = word.length();

        /*
        for (int i = 0; i < word.length(); i++) {
            String character = charArray[i];
            if (i > 0) {
                if (character.equals("e") && !isVowel(charArray[i - 1])) {
                    numSilent++;
                } else if (character.equals("y") && isVowel(charArray[i - 1])) {
                    numSilent++;
                }
            }
        }
        */

            String character = charArray[charArray.length - 1].toLowerCase();

            if (character.equals("e") && !isVowel(charArray[length - 2]) && isVowel(charArray[length - 3])) {
                numSilent++;
            } else if (character.equals("y") && isVowel(charArray[length - 2])) {
                numSilent++;
            }
        }
        return numSilent;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int numSyllables() {
        return(numVowels() - numDiphthongs() - numSilent());
    }

    public String toString() {
        return("Word: " + word + " # syllables: " + numSyllables());
    }
}
