import java.io.IOException;
import java.nio.file.Paths;

public class Tester {
    public static void main(String [] args) throws IOException {
        Word test = new Word("doesnt");
        System.out.println(test.numSyllables());
        TextAnalyzer tim = new TextAnalyzer(Paths.get("src/YouthBoardSpeech.txt"));

        System.out.println( "Source text file:  " + tim.getFilename()) ;
        System.out.println( "Readability score: " + tim.fleschScore()) ;
        System.out.println( "Educational level: " + tim.educationLevel());
        System.out.println( "Syllables:         " + tim.t.numSyllables());
        System.out.println( "Words:             " + tim.t.numWords());
        System.out.println( "Sentences:         " + tim.t.numSentences());
    }
}
