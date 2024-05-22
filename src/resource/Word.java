package resource;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;

public class Word {
  private ArrayList<String> englishWords = new ArrayList<>(1);
  private ArrayList<String> koreanWords = new ArrayList<>(3);

  public static Word[] read(File etfFile) throws IOException {
    ArrayList<Word> arrayList = new ArrayList<>();
    try (Scanner scanner = new Scanner(etfFile, "utf8")) {
      while (scanner.hasNext()) {
        final String line = scanner.nextLine();
        System.out.println(line);
        final String subStrings[] = line.split("\\|\\|");
        final String leftSide = subStrings[0];
        final String rightSide = subStrings[1];
        System.out.println(leftSide + ", " + rightSide);
        final String englishWords[] = leftSide.split("\\|");
        String koreanWords[] = rightSide.split("\\|");
        for(int i = 0;i < koreanWords.length;i++) {
          koreanWords[i] = koreanWords[i].toLowerCase();
        }
        Word word = new Word(englishWords, koreanWords);
        arrayList.add(word);
      }
    } catch (NoSuchElementException e) {
      
    }
    Word words[] = new Word[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      words[i] = arrayList.get(i);
    }
    return words;
  }

  Word(String english, String korean) {
    this(new String[] { english }, new String[] { korean });
  }

  Word(String english, String koreanArray[]) {
    this(new String[] { english }, koreanArray);
  }

  Word(String englishArray[], String korean) {
    this(englishArray, new String[] { korean });
  }

  Word(String englishArray[], String koreanArray[]) {
    for (String english : englishArray) {
      addEnglishMeaning(english);
    }
    for (String korean : koreanArray) {
      addKoreanMeaning(korean);
    }
  }

  void addKoreanMeaning(String korean) {
    koreanWords.add(korean);
  }

  void addEnglishMeaning(String english) {
    englishWords.add(english);
  }

  String[] getEnglishWords() {
    return (String[]) englishWords.toArray();
  }

  String[] getKoreanWords() {
    return (String[]) koreanWords.toArray();
  }

  public boolean isEnglishMatched(String english) {
    // English
    // eGlish
    // english
    String englishWord = null;
    for (int seek = 0; seek < englishWords.size(); seek++) {
      englishWord = englishWords.get(seek);
      if (englishWord.equalsIgnoreCase(english)) {
        break;
      }
    }

    if(englishWord == null) {
      return false;
    }

    for (int seek = 0; seek < englishWord.length(); seek++) {
      if (Character.isUpperCase(englishWord.charAt(seek)) && Character.isLowerCase(english.charAt(seek))){
        return false;
      }
    }

    return true;
  }

  public boolean isKoreanMatched(String korean) {
    final String toCompare = korean.toLowerCase();
    return koreanWords.contains(toCompare);
  }

  @Override
  public boolean equals(Object object)
  {
    if(object instanceof Word) {
      Word word = (Word)object;
      if(this.englishWords.equals(word.englishWords) && this.koreanWords.equals(word.koreanWords)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
    
    //englishWords.iterator()urn "Word: " + englishWords.size() + ":" + koreanWords.size(); 
  }
}
