package proj5;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Jack Rubin
 * @version 5/31/23
 *
 * GrammarChecker class which has
 * a threshold, thresh(int) which is the maximum uses allowed for a word before being switched.
 * a Thesaurus, has synonyms for words to replace overused words.
 * a WordCounter, counts the number of times a word is used in a given text file (not case-sensitive).
 */
public class GrammarChecker {

    private int thresh;
    private Thesaurus thesaurus;

    /**
     * non-default constructor.
     * Creates a Thesaurus with the thesaurus file.
     * @param thesaurusFile file to create Thesaurus
     * @param threshold max number of times a word can be used before being switched
     * with a synonym.
     */
    public GrammarChecker(String thesaurusFile, int threshold) {
        thesaurus = new Thesaurus(thesaurusFile);
        thresh = threshold;
    }

    /**
     * Given a text file, replaces overused words with synonyms. Finished text is printed to the console.
     * @param textFile file to be examined
     */
    public void improveGrammar(String textFile){
        WordCounter wordCounter = new WordCounter();
        Scanner s = null;
        try{s=new Scanner(Paths.get(textFile));}
        catch (Exception ignore){ignore.printStackTrace();}
        wordCounter.findFrequencies(textFile);
        System.out.println(wordCounter);
        while(s.hasNextLine()){
            String[] currentLine = s.nextLine().split(" ");
            for (String word : currentLine){
                String punctuation = word.replaceAll("[a-zA-Z]", ""); // extra credit
                String currentWord = word.replaceAll("\\p{Punct}", "");
                if (wordCounter.getFrequency(currentWord.toLowerCase()) > thresh && thesaurus.contains(currentWord.toLowerCase())){
                    currentWord = thesaurus.getSynonymFor(currentWord.toLowerCase());
                    if(word.charAt(0)<97){ // checks first letter using ascii number. uppercase is 65-90 & lowercase is >=97
                        currentWord = currentWord.substring(0,1).toUpperCase()+currentWord.substring(1); // extra credit
                    }
                }
                System.out.print(currentWord+punctuation+" ");
            }
            System.out.println();
        }
    }
}
