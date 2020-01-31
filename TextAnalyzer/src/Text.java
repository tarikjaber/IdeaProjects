import java.util.ArrayList;

public class Text {
    String text;
    ArrayList<Sentence> sentences = new ArrayList<Sentence>();

    public Text() {

    }

    public Text(String t) {
        text = t;
        fillSentences();
    }

    public void fillSentences() {
        String[] letterArray = text.split("");
        int start = 0;
        int end;
        for(int i = 0; i < text.length(); i++) {
            if(letterArray[i].equals(".") || letterArray[i].equals("!") || letterArray[i].equals("?")) {
                /*
                if(i != text.length() - 1) {
                    try {
                        int test = Integer.parseInt(letterArray[i]);
                        break;
                    } catch (Exception e) {
                        continue;
                    }
                }
                */
                end = i-1;
                sentences.add(new Sentence(text.substring(start, end + 1)));
                start = i + 2;
            }
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public int numSyllables() {
        int numSyllables = 0;
        for(int i = 0; i < sentences.size(); i++) {
            numSyllables += sentences.get(i).numSyllables();
        }
        return numSyllables;
    }

    public int numWords() {
        int numWords = 0;
        for (int i = 0; i < sentences.size(); i++) {
            numWords += sentences.get(i).numWords();
        }
        return numWords;
    }

    public int numSentences() {
        return sentences.size();
    }


}

