import javax.swing.*;
import java.io.IOException;
import java.nio.file.Paths;


public class Tester {

    public static void main(String [] args) throws IOException {

        JTable j;
        JFrame f = new JFrame();

        String[] columnNames = { "Text", "Sentences", "Words", "Syllables", "Characters", "Flesch Score", "Flesch GL" , "Smog GL", "Gunning Fog GL",
                "Coleman Liau GL" , "Linear Write GL",
                "ARI GL"};
        String[][] data = new String[3][12];

        TextAnalyzer [] texts = new TextAnalyzer[3];
        texts[0] = new TextAnalyzer(Paths.get("src/test-6th-grader.txt"));
        texts[1] = new TextAnalyzer(Paths.get("src/test-college-grad.txt"));
        texts[2] = new TextAnalyzer(Paths.get("src/Gettysburg.txt"));

        TextAnalyzer temp = new TextAnalyzer();
        for(int i = 0; i < texts.length; i++) {
            data[i][0] = texts[i].getFilename();
            data[i][1] = Integer.toString(texts[i].t.numSentences());
            data[i][2] = Integer.toString(texts[i].t.numWords());
            data[i][3] = Integer.toString(texts[i].t.numSyllables());
            data[i][4] = Integer.toString(texts[i].t.numLetters());
            data[i][5] = Integer.toString(texts[i].fleschScore());
            data[i][6] = texts[i].educationLevel();
            data[i][7] = temp.gradeLevel(texts[i].smogScore());
            data[i][8] = temp.gradeLevel(texts[i].gunningFogScore());
            data[i][9] = temp.gradeLevel(texts[i].colemanLiauScore());
            data[i][10] = temp.gradeLevel(texts[i].linearWriteScore());
            data[i][11] = temp.gradeLevel(texts[i].automatedReadabilityIndex());
        }
                // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 1200, 110);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(1200, 110);
        // Frame Visible = true


        //resizeColumnWidth(j);
        f.setVisible(true);
    }
}
