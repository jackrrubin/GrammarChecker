package proj5;

/**
 * @author Jack Rubin
 * @version 5/31/23
 *
 * WordCounterEntry class. Each object has
 * a key (String), which is a stored word
 * a frequency, number of times a word appears in a text file
 */

public class WordCounterEntry implements Comparable<WordCounterEntry>{
    private int freq;
    private String key;
    private static final int NEW_WORD = 1;

    /**
     * non-default constructor for WordCounterEntry.
     * Frequency is set to 1.
     * @param data word to be stored.
     */
    public WordCounterEntry(String data){
        key = data;
        freq = NEW_WORD;
    }

    /**
     * increments the frequency
     */
    public void incrementFrequency(){freq++;}

    /**
     * getter method for the frequency.
     * @return frequency
     */
    public int getFreq(){return freq;}

    /**
     * Compares this WordCounterEntry to other WordCounterEntry.
     * Only looks at the key. Disregards frequency
     * @param other the WordCounterEntry to be compared.
     * @return 1 if this is greater, 0 if equal, -1 if other is greater
     */
    public int compareTo(WordCounterEntry other) {
        return key.compareTo(other.key);
    }

    public String toString(){
        return key+ ": "+freq;
    }
}
