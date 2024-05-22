package ETFManager;

import java.util.ArrayList;

public class Word {
    public ArrayList<String> englishWords = new ArrayList<String>();
    public ArrayList<String> koreanWords = new ArrayList<String>();
    public Word(String line) {
        ArrayList<Word> words = new ArrayList<Word>();
        final String englishPart = line.split("=")[0];
        final String koreanPart = line.split("=")[1];
        final String[] englishWordsStrings = englishPart.split("\\|");
        final String[] koreanWordsStrings = koreanPart.split("\\|");
        
        for (String englishWord : englishWordsStrings) {
            englishWords.add(englishWord);
        }
        for (String koreanWord : koreanWordsStrings) {
            koreanWords.add(koreanWord);
        }
    }

    private Word(String[] englishWords, String[] koreanWords) {
        for (String englishWord : englishWords) {
            this.englishWords.add(englishWord);
        }
        for (String koreanWord : koreanWords) {
            this.koreanWords.add(koreanWord);
        }
    } 
}
