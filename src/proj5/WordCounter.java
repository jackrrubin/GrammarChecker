package proj5;

/**
 * @author Jack Rubin
 * @version 5/31/23
 *
 * class for computing word frequencies from a text file.
 * Implements a BST with BSTNodes with WordCounterEntries as keys.
 */
public class WordCounter {

    BinarySearchTree<WordCounterEntry> wordCountBST;

    /**
     * default constructor. Creates new BST with WordCounterEntries
     */
    public WordCounter() {
        wordCountBST = new BinarySearchTree<WordCounterEntry>();
    }

    /**
     * Computes frequency of each word in given file.
     * @param file path to file, such as "src/input.txt"
     */
    public void findFrequencies(String file) {
        LineReader lineReader = new LineReader(file, " ");
        while(true){
            String[] currentLine = lineReader.getNextLine();
            if(currentLine == null){break;}
            for(String s: currentLine) {
                s = s.toLowerCase(); // extra credit
                s = s.replaceAll("\\p{Punct}", "");
                WordCounterEntry wordCounterEntry = new WordCounterEntry(s);
                if(!wordCountBST.contains(wordCounterEntry)) {
                    wordCountBST.insert(wordCounterEntry);
                } else {
                    incrementWordCounterEntry(wordCounterEntry);
                }
            }
        }
    }


    /**
     * Increments the frequency of a WordCounterEntry in the BST.
     * @param toFind WordCounterEntry that we're searching for.
     */
    private void incrementWordCounterEntry(WordCounterEntry toFind) {
        incrementWordCounterEntry(toFind, wordCountBST.getRoot());
    }

    /**
     * recursive helper method.
     * @param toFind WordCounterEntry that we're searching for.
     * @param subtreeRoot BSTNode we're currently examining
     */
    private void incrementWordCounterEntry(WordCounterEntry toFind, BSTNode<WordCounterEntry> subtreeRoot) {
        if(subtreeRoot == null){return;}
        int comparison = toFind.compareTo(subtreeRoot.getKey());
        if (comparison == 0) {
            subtreeRoot.getKey().incrementFrequency();
        } else if (comparison < 0) {
            incrementWordCounterEntry(toFind, subtreeRoot.getLeftNode());
        } else {
            incrementWordCounterEntry(toFind, subtreeRoot.getRightNode());
        }
    }

    /**
     * returns the frequency of the given word
     * @param word string to get the frequency of
     * @return the number of times word appears in the input file
     */
    public int getFrequency(String word) {
        WordCounterEntry entry = new WordCounterEntry(word);
        if(wordCountBST.contains(entry)) {
            WordCounterEntry wordCounterEntry = wordCountBST.getKey(entry);
            return wordCounterEntry.getFreq();
        }
        return 0;
    }

    public String toString(){
        return wordCountBST.toString();
    }
}
