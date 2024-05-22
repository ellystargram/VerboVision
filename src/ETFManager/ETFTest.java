package ETFManager;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ETFTest {
    public String testName;
    public ArrayList<Word> words = new ArrayList<Word>();
    public ETFTest(File ETFFile, String testName, int lineNum) {
        this.testName = testName;
        try (Scanner lineReader = new Scanner(ETFFile, "UTF-8");){
            int braceOpenCount = 0;
            int braceCloseCount = 0;
            for (int i = 1; i < lineNum; i++) {
                lineReader.nextLine().strip();
            }
            while(lineReader.hasNext()){
                String line = lineReader.nextLine().strip();
                if(line.matches("\\{")){
                    braceOpenCount++;
                }else if(line.matches("\\}")){
                    braceCloseCount++;
                }
                else{
                    Word newWord = new Word(line);
                    words.add(newWord);
                }
                if(braceOpenCount==braceCloseCount){
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
