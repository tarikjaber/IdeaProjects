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

    public int numPoly() {
        int numPoly = 0;
        for (int i = 0; i < sentences.size(); i++) {
            for(int j = 0; j < sentences.get(i).words.size(); j++) {
                if (sentences.get(i).words.get(j).numSyllables() > 2) {
                    numPoly++;
                }
            }
        }
        return numPoly;
    }

    public int numEasy() {
        int numEasy = 0;
        for (int i = 0; i < sentences.size(); i++) {
            for(int j = 0; j < sentences.get(i).words.size(); j++) {
                if (sentences.get(i).words.get(j).numSyllables() < 3) {
                    numEasy++;
                }
            }
        }
        return numEasy;
    }

    public double getASW() {
        double numSyllables = 0.0;
        double numWords = 0.0;
        for (int i = 0; i < sentences.size(); i++) {
            for(int j = 0; j < sentences.get(i).words.size(); j++) {
                numWords++;
                numSyllables += sentences.get(i).words.get(j).numSyllables();
            }
        }
        return numSyllables/numWords;
    }

    public double getASL() {
        return (double)numWords()/(double)numSentences();
    }

    public int numLetters() {
        int numLetters = 0;
        for (int i = 0; i < sentences.size(); i++) {
            numLetters += sentences.get(i).numLetters();
        }
        return numLetters;
    }

    public double lettersPerWord() {
        return (double)numLetters()/(double)numWords();
    }

    public double lettersPer100Words() {
        return((double)numLetters()*(100.0/numWords()));
    }

    public double sentencesPer100Words() {
        return((double)numSentences()*(100.0/numWords()));
    }

    public double getPHW() {
        return (double)numPoly()/(double)numWords() * 100.0;
    }

    public int numSentences() {
        return sentences.size();
    }


}

