import java.io.File;

import javax.swing.JButton;

import ETFManager.ETFDir;
import XWindow.XWindow;

public class App {
    public App() {
        XWindow window = new XWindow(500, 500, "asdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsssssssssssssssssssssssssss", true);
        window.add(new JButton("qwer"));
        window.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        // new App();
        File file = new File("./src/EnglishTest/Grade2/Test.etfx");
        ETFDir rootDir = new ETFDir(file);
        System.out.println(rootDir.curDirName);
        System.out.println(rootDir.curDirTests.get(2).words.get(1).englishWords.get(0));

        // Word test[] = Word.read(file);

        // System.out.println(test[0].isEnglishMatched("English"));    //true
        // System.out.println(test[0].isEnglishMatched("enGLISH"));//false
        // System.out.println(test[0].isEnglishMatched("ENGLISH"));//true
        // System.out.println(test[0].isEnglishMatched("EnGLiSh"));//true
        
        // System.out.println();

        //asdf

        // System.out.println(test[4].isKoreanMatched("a가 b하는 것을 막다"));//true
        // System.out.println(test[4].isKoreanMatched("a가 B하는 것을 막다"));//true
        // System.out.println(test[4].isKoreanMatched("A가 b하는 것을 막다")); //true
        // System.out.println(test[4].isKoreanMatched("A가 B하는 것을 막다"));//true
        // System.out.println(test[4].isKoreanMatched("A가 B하는 것을 장려하다")); //false

        // (손음쉽게) ~을 해내다 -- 틀림
        // (가까스로) ~을 해내다 -- 맞음
        // ~을 해내다 -- 맞음
    }
}