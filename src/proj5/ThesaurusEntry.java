package proj5;

import java.util.Random;

/**
 * @author Jack Rubin
 * @version 5/31/23
 *
 * ThesaurusEntry class. Each one has a
 * String key which is the main word.
 * LinkedList of Strings, synonyms which can replace a word
 */
public class ThesaurusEntry implements Comparable<ThesaurusEntry>{

    private LinkedList synonyms;

    private String key;

    /**
     * non-default constructor
     * @param newWord key of the ThesaurusEntry
     * @param newSynonyms LL of synonyms of the ThesaurusEntry
     */
    public ThesaurusEntry(String newWord, LinkedList newSynonyms){
        key = newWord;
        synonyms = newSynonyms;
    }

    /**
     * @return random synonym from LL
     */
    public String getRandom(){
        int randomIndex = new Random().nextInt(getSynonymsLength());
        String toReturn = synonyms.getData(randomIndex);
        return toReturn;
    }


    /**
     * adds synonyms if the word isn't already in LL. Array version
     * @param toAdd String array of synonyms of given word
     */
    public void addSynonyms(String[] toAdd){
        for(int i=0; i<toAdd.length; i++){
            if(!contains(toAdd[i])){
                synonyms.add(toAdd[i]);
            }
        }
    }


    /**
     * adds synonyms if the word isn't already in LL. LL version
     * @param toAdd LL of string synonyms of given word
     */
    public void addSynonyms(LinkedList toAdd){
        for(int i=0; i<toAdd.getLength(); i++){
            if(!contains(toAdd.getData(i))){
                synonyms.add(toAdd.getData(i));
            }
        }
    }

    /**
     * getter method for synonyms.
     * @return synonyms LL
     */
    public LinkedList getSynonyms(){
        return synonyms;
    }

    /**
     * getter method for length of synonyms.
     * @return length of synonyms LL.
     */
    public int getSynonymsLength(){
        return synonyms.getLength();
    }

    /**
     * checks if word is in LL
     * @param word, word to find in LL
     * @return true if word is in LL. False if not.
     */
    private boolean contains(String word){
        for(int i=0; i<getSynonymsLength(); i++){
            if((synonyms.getData(i)).equals(word)){
                return true;
            }
        }
        return false;
    }

    /**
     * Comparison method for two ThesaurusEntries. Compares the keys
     * and disregards the synonyms.
     * @param other the ThesaurusEntry to be compared.
     * @return 1 if this is greater, 0 if equal, -1 if other is greater
     */
    public int compareTo(ThesaurusEntry other) {
        return key.compareTo(other.key);
    }

    public String toString(){return key +" - {"+ synonyms.toString() +"}";}

}
