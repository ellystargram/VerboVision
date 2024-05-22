package ETFManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ETFDir {
    public String curDirName;
    public int curDirDegree;
    public ArrayList<ETFDir> subDir = new ArrayList<ETFDir>();
    public ArrayList<ETFTest> curDirTests = new ArrayList<ETFTest>();

    public ETFDir(File ETFFile) {
        curDirName = ETFFile.getName();

        int lineNum = 1;
        readETFLine(lineNum, ETFFile);

    }

    public ETFDir(File ETFFile, String dirName, int searchStartLine) {
        curDirName = dirName;

        readETFLine(searchStartLine, ETFFile);

    }

    private void readETFLine(int lineNum, File ETFFile) {
        try (Scanner lineReader = new Scanner(ETFFile, "UTF-8");) {
            int braceOpenCount = 0;
            int braceCloseCount = 0;
            for (int i = 1; i < lineNum; i++) {
                lineReader.nextLine().strip();
            }
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine().strip();
                if (line.startsWith("//dir") && braceOpenCount-1==braceCloseCount) {
                    String dirName = line.strip().replaceAll("//dir +(.+)", "$1");
                    System.out.println("dir detected: " + dirName + " at " + lineNum);
                    lineNum+=1;
                    line= lineReader.nextLine().strip();
                    
                    
                    ETFDir newReadDir = new ETFDir(ETFFile, dirName, lineNum);
                    subDir.add(newReadDir);
                    braceOpenCount++;
                } else if (line.startsWith("//test")&& braceOpenCount-1==braceCloseCount) {
                    String testName = line.replaceAll("//test +(.+)", "$1");
                    System.out.println("test detected: " + testName + " at " + lineNum);
                    lineNum+=1;
                    line= lineReader.nextLine().strip();

                    ETFTest newReadTest = new ETFTest(ETFFile, testName, lineNum);
                    curDirTests.add(newReadTest);
                    braceOpenCount++;

                } else if (line.matches("\\{")) {
                    braceOpenCount++;
                } else if (line.matches("\\}")) {
                    braceCloseCount++;
                }
                if(braceOpenCount==braceCloseCount) {
                    break;
                }
                lineNum++;
            }

            
        } catch (Exception e) {

        }

    }
}
