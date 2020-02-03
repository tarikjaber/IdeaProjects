import java.util.ArrayList;
public class Sentence {
    String text;
    ArrayList<Word> words = new ArrayList<Word>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public Sentence() {

    }

    public Sentence(String t) {

        text = modifyText(t);
        fillWords();
    }

    public String modifyText(String t) {
        StringBuilder sb = new StringBuilder(t);
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ';' || sb.charAt(i) == ',' || sb.charAt(i) == '(' || sb.charAt(i) == ')' || sb.charAt(i) == '\'') {
                sb.deleteCharAt(i);
            } else if (sb.charAt(i) == '-') {
                sb.replace(i, i + 1, " ");
            }
        }
        return sb.toString();
    }

    public int numLetters() {
        int numLetters = 0;
        for (int i = 0; i < words.size(); i++) {
            numLetters += words.get(i).numLetters();
        }
        return numLetters;
    }

    public int numWords() {
        String [] letterArray = text.split("");
        int numWords = 0;
        for(int i = 0; i < letterArray.length; i++) {
            if (letterArray[i].equals(" ")) {
                numWords++;
            }
        }
        return (numWords + 1);
     }

     public void fillWords() {
         String [] letterArray = text.split("");
         int start = 0;
         int end;
         int numWords = 0;
         for(int i = 0; i < letterArray.length; i++) {
             if (letterArray[i].equals(" ")) {
                 end = i;

                 words.add(new Word(text.substring(start,end)));

                 start = i + 1;
                 numWords++;
             }
         }
         words.add(new Word(text.substring(start,letterArray.length)));

     }

     public int numSyllables() {
        int numSyllables = 0;
        for(int i = 0; i < words.size(); i++) {
            numSyllables += words.get(i).numSyllables();
        }
        return numSyllables;
     }

     public String toString() {
        return(text + " Num words: " + numWords() + " Num syllables: " + numSyllables());
     }
}
