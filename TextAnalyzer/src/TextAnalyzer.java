import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAnalyzer {
    Text t;
    String filename;

    public Text getT() {
        return t;
    }

    public void setT(Text t) {
        this.t = t;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public TextAnalyzer() {

    }

    public TextAnalyzer(Path text) throws IOException {
        /*
        filename = text.toString();
        String content = Files.readString(text, StandardCharsets.US_ASCII);
        */
        filename = text.toString();
        String content = readFile(text.toString());
        t = new Text(content);
    }

    public String getFilename() {
        return filename;
    }

    static String readFile(String fname) throws IOException {
        File file = new File(fname);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String txt = "";
        String st;
        while ((st = br.readLine()) != null) {
            txt += st;
    }
        return txt;

}

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public int fleschScore() {
        return (int)(206.835 - 84.6 * (  (double)t.numSyllables()   /  (double)t.numWords()  ) - 1.015 * (  (double)t.numWords()  /    (double)t.numSentences()  ) );
    }

    public String educationLevel() {
        int readability = fleschScore();
        if(readability >= 91) {
            return "5th grade";
        } else if (readability >= 81) {
            return "6th grade";
        } else if (readability >= 71) {
            return "7th grade";
        } else if (readability >= 61) {
            return "8th and 9th grade";
        } else if (readability >= 51) {
            return "10th to 12th grade";
        } else if (readability >= 31) {
            return "College student";
        } else if (readability >= 0) {
            return "College graduate";
        } else {
            return "Hard as hell";
        }
    }
}
