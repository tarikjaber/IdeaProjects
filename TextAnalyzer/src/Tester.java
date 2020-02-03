import java.io.IOException;
import java.nio.file.Paths;

public class Tester {
    public static void main(String [] args) throws IOException {
        TextAnalyzer tim = new TextAnalyzer(Paths.get("src/YouthBoardSpeech.txt"));

        System.out.println( "Source text file:                                " + tim.getFilename()) ;
        System.out.println( "Readability score (flesch):                      " + tim.fleschScore()) ;
        System.out.println( "Readability score (smog):                        " + tim.smogScore());
        System.out.println( "Readability score (gunning fog):                 " + tim.gunningFogScore());
        System.out.println( "Readability score (flesch kincaid):              " + tim.fleschKincaidScore());
        System.out.println( "Readability score (coleman-liau):                " + tim.colemanLiauScore());
        System.out.println( "Readability score (linear write):                " + tim.linearWriteScore());
        System.out.println( "Readability score (automatic readability index): " + tim.automatedReadabilityIndex());
        System.out.println( "Educational level:                               " + tim.educationLevel());
        System.out.println( "Syllables:                                       " + tim.t.numSyllables());
        System.out.println( "Letters:                                         " + tim.t.numLetters());
        System.out.println( "Letters per word (average):                      " + roundDecimal(tim.t.lettersPerWord()));
        System.out.println( "Average sentence length:                         " + roundDecimal(tim.t.getASL()));
        System.out.println( "Average syllables per word:                      " + roundDecimal(tim.t.getASW()));
        System.out.println( "Percentage of hard words:                        " + roundDecimal(tim.t.getPHW()) + "%");
        System.out.println( "Poly-syllabic words:                             " + tim.t.numPoly());
        System.out.println( "Easy words:                                      " + tim.t.numEasy());
        System.out.println( "Words:                                           " + tim.t.numWords());
        System.out.println( "Sentences:                                       " + tim.t.numSentences());
    }

    public static double roundDecimal(double d) {
        return Math.round(d * 100.0)/100.0;
    }
}
