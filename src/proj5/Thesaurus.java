package proj5;

/**
 * @author Jack Rubin
 * @version 5/31/23
 *
 * Builds a thesaurus from a text file.
 * Each line of the text file is a comma-separated list of synonymous words.
 * The first word in each line should be the thesaurus entry.
 * The remaining words on that line are the list of synonyms for the entry.
 *
 * Implements a BST containing which is made of BSTNodes that have
 * ThesaurusEntries.
 */
public class Thesaurus{

    private BinarySearchTree<ThesaurusEntry> thesaurus;

    /**
     * default constructor
     * makes a new BST containing BSTNodes with ThesaurusEntries.
     */
    public Thesaurus(){
        thesaurus = new BinarySearchTree<ThesaurusEntry>();
    }

    /**
     * non-default constructor
     * makes a new BST containing BSTNodes with ThesaurusEntries
     * creates a Thesaurus from a given file.
     * @param filepath path to comma-delimited text file
     */
    public Thesaurus(String filepath){
        thesaurus = new BinarySearchTree<ThesaurusEntry>();
        createThesaurus(filepath);
    }

    /**
     * creates a Thesaurus from a text file.
     * First word in each line will be the key in ThesaurusEntry.
     * Every word after it in that same line with be synonyms.
     * @param filepath path to comma-delimited text file
     */
    private void createThesaurus(String filepath) {
        LineReader lineReader = new LineReader(filepath, ",");
        while(true){
            String[] currentLine = lineReader.getNextLine();
            if(currentLine == null){break;}
            String newWord = currentLine[0];
            LinkedList LL = new LinkedList();
            for(int i=1; i< currentLine.length; i++) {
                LL.add(currentLine[i]);
            }
            ThesaurusEntry thesaurusEntry = new ThesaurusEntry(newWord, LL);
            thesaurus.insert(thesaurusEntry);
            }
        }


    /**
     * Deletes a BSTNode from the Thesaurus. Does nothing if doesn't exist.
     * @param entry ThesaurusEntry with this String as the key will be deleted
     */
    public void delete(String entry){
        ThesaurusEntry thesaurusEntry = new ThesaurusEntry(entry, new LinkedList());
        thesaurus.delete(thesaurusEntry);
    }

    /**
     * Checks if the BST contains a ThesaurusEntry with the String as the key
     * True if it does contain the key. False if it doesn't
     * @param keyword key to search for in BST
     */
    public boolean contains(String keyword){
        ThesaurusEntry thesaurusEntry = new ThesaurusEntry(keyword, new LinkedList());
        return thesaurus.contains(thesaurusEntry);
    }

    /**
     * Gets a random synonym for the given keyword. If keyword does not exist, return the empty string.
     * @param keyword, word to find a synonym for
     * @return a random synonym from the synonym list of that word, or empty string if keyword doesn't exist.
     */
    public String getSynonymFor(String keyword){
            ThesaurusEntry thesaurusEntry = new ThesaurusEntry(keyword, new LinkedList());
            if(thesaurus.contains(thesaurusEntry)){
                return getSynonymFor(thesaurusEntry, thesaurus.getRoot());
            }
            return "";
    }

    /**
     * Private recursive helper method
     * @param toFind ThesaurusEntry to search for in the BST
     * @param subtreeRoot current BSTNode being examined
     * @return synonym for keyword
     */
    private String getSynonymFor(ThesaurusEntry toFind, BSTNode<ThesaurusEntry> subtreeRoot){
            int comparison = toFind.compareTo(subtreeRoot.getKey());
            if(comparison==0){
                return subtreeRoot.getKey().getRandom();
            }
            else if (comparison<0) {
                return getSynonymFor(toFind, subtreeRoot.getLeftNode());
            }
            else{
                return getSynonymFor(toFind, subtreeRoot.getRightNode());
            }
    }

    /**
     * inserts entry and synonyms into thesaurus. If entry does not exist, it creates one.
     * If it does exist, it adds the given synonyms to the entry's synonym list
     * @param keyword keyword to be added
     * @param syns array of synonyms for keyword entry
     */
    public void insert(String keyword, String[] syns){
        ThesaurusEntry thesaurusEntry = new ThesaurusEntry(keyword,new LinkedList());
        thesaurusEntry.addSynonyms(syns);
        if(thesaurus.contains(thesaurusEntry)){
            insert(thesaurusEntry, thesaurus.getRoot());
        }
        else{
            thesaurus.insert(thesaurusEntry);
        }
    }

    /**
     * private recursive helper method for insert.
     * @param toFind ThesaurusEntry we're looking for
     * @param subtreeRoot current BSTNode being examined
     */
    private void insert(ThesaurusEntry toFind, BSTNode<ThesaurusEntry> subtreeRoot){
        if(subtreeRoot == null){return;}
        if(toFind.compareTo(subtreeRoot.getKey()) == 0){
            subtreeRoot.getKey().addSynonyms(toFind.getSynonyms());
            return;
        }
        insert(toFind, subtreeRoot.getRightNode());
        insert(toFind, subtreeRoot.getLeftNode());
    }

    public String toString(){
        return thesaurus.toString();
    }

}
