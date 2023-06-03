package proj5;

/**
 * This class is dedicated to running non-JUnit tests.
 */
public class Main{

    //LineReader tests
    public static void main(String[] args) {
      //LineReader lineReader = new LineReader("src/proj5/smallThesaurus.txt", ",");
      //while(true){
       //   String[] currentLine = lineReader.getNextLine();
         //   String newWord = currentLine[0];
           // LinkedList LL = new LinkedList();
            //for(String s: currentLine)
              //LL.add(s);
            //if(lineReader.getNextLine() == null){break;}

        //WordCounterEntry tests
       // WordCounterEntry wordCounterEntry = new WordCounterEntry("blue");
        //System.out.println(wordCounterEntry.getFreq());
      //  wordCounterEntry.incrementFrequency();
        //wordCounterEntry.incrementFrequency();
        //System.out.println(wordCounterEntry.getFreq());
        //System.out.println(wordCounterEntry);

       // System.out.println();
        //ThesaurusEntry tests
       // LinkedList synonymsList = new LinkedList();
       // synonymsList.add("pop");
        //synonymsList.add("coke");
        //synonymsList.add("pepsi");
        //synonymsList.toString();

        //System.out.println();
        //System.out.println();

        //ThesaurusEntry thesaurusEntry = new ThesaurusEntry("soda", synonymsList);
        //System.out.println(thesaurusEntry.key);
        //System.out.println(thesaurusEntry.sizeOfSynonyms());
        //System.out.println(thesaurusEntry);

        //String[] synonymsList2 = new String[3];
        //synonymsList2[0] = "pop";
        //synonymsList2[1] = "sprite";
        //synonymsList2[2] = "pepsi";
        //thesaurusEntry.addSynonyms(synonymsList2);
        //System.out.println(thesaurusEntry);
        //System.out.println(thesaurusEntry.removeRandom());
        //System.out.println(thesaurusEntry);

        //Thesaurus thesaurus = new Thesaurus("src/proj5/lamb.txt");
        //System.out.println(thesaurus);

        Thesaurus thesaurus = new Thesaurus("src/proj5/thesaurustest1.txt");
        System.out.println(thesaurus);

        Thesaurus thesaurus2 = new Thesaurus();
        String[] syns = {"small","angry","ache","always","repair","very","umbrella","say"};
        thesaurus2.insert("red", syns);
        String[] syns2 = {"small", "angry", "test1", "test2"};
        thesaurus2.insert("red", syns2);
        System.out.println(thesaurus2);

        System.out.println();

        System.out.println("Delete test:");
        thesaurus2.delete("red");
        System.out.println(thesaurus2);


        System.out.println("\n");
        System.out.println("WordCounter tests");
        WordCounter wordCounter = new WordCounter();
        wordCounter.findFrequencies("src/proj5/wordcounttest.txt");
        System.out.println(wordCounter);
        System.out.println(wordCounter.getFrequency("red"));
        System.out.println(wordCounter.getFrequency("plane"));

        //BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        //binarySearchTree.insert(1);
        //binarySearchTree.insert(2);
        //binarySearchTree.insert(5);
        //binarySearchTree.insert(3);
        //System.out.println(binarySearchTree);
        //binarySearchTree.delete(1);
        //binarySearchTree.delete(5);
        //System.out.println(binarySearchTree);


        Thesaurus thesaurus1 = new Thesaurus("src/proj5/smallThesaurus.txt");
        System.out.println(thesaurus1);
        //System.out.println(thesaurus1.getSynonymFor("always"));

        //System.out.println(thesaurus.getSynonymFor("really"));
        //System.out.println(thesaurus);
        //System.out.println("After deletion");
        //System.out.println(thesaurus);
        //System.out.println(thesaurus.getSynonymFor("really"));
        //
        //WordCounter wordCounter1 = new WordCounter();
        //wordCounter1.findFrequencies("src/proj5/lamb.txt");
        //System.out.println(wordCounter1);
        //System.out.println(wordCounter1.getFrequency("Mary"));

        //Grammar Checker Tests
        GrammarChecker grammarChecker = new GrammarChecker("src/proj5/smallThesaurus.txt", 2);
        grammarChecker.improveGrammar("src/proj5/lamb.txt");
    }
}