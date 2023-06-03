package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Tests for ThesaurusEntry class
 * @author Jack Rubin
 * @version 5/24/23
 *
 */
public class ThesaurusEntryTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private ThesaurusEntry thesaurusEntry;

    @Before
    public void setUp() throws Exception {
        LinkedList syns = new LinkedList();
        syns.add("tennis");
        syns.add("football");
        syns.add("baseball");
        thesaurusEntry = new ThesaurusEntry("basketball", syns);
    }

    @After
    public void tearDown() throws Exception {
        thesaurusEntry = null;
    }

    @Test
    public void testThesaurusEntryConstructor_toString() {
        assertEquals("A new ThesaurusEntry.", "basketball - {tennis, football, baseball}",
                thesaurusEntry.toString());
    }

    @Test
    public void testThesaurusEntryGetRandom() {
        System.out.println("Returns random word from LL");
        System.out.println(thesaurusEntry.getRandom());
    }

    @Test
    public void testThesaurusEntryAddSynonymsArray() {
        String[] toAdd = {"baseball", "squash", "hockey"};
        thesaurusEntry.addSynonyms(toAdd);
        assertEquals("A ThesaurusEntry with new synonyms and no repeats.","basketball - {tennis, football, baseball, squash, hockey}",
                thesaurusEntry.toString());
    }

    @Test
    public void testThesaurusEntryAddSynonymsLL() {
        LinkedList toAdd = new LinkedList();
        toAdd.add("baseball");
        toAdd.add("squash");
        toAdd.add("hockey");
        thesaurusEntry.addSynonyms(toAdd);
        assertEquals("A ThesaurusEntry with new synonyms and no repeats.","basketball - {tennis, football, baseball, squash, hockey}",
                thesaurusEntry.toString());
    }

    @Test
    public void testThesaurusEntryGetSynonyms() {
        LinkedList syns = thesaurusEntry.getSynonyms();
        assertEquals("A ThesaurusEntry's synonyms.", "tennis, football, baseball",
                syns.toString());
    }

    @Test
    public void testThesaurusEntryCompareToWhenEqual() {
        ThesaurusEntry otherThesaurusEntry = new ThesaurusEntry("basketball", new LinkedList());
        assertEquals("Returns 0 since keys are equal", 0,
                thesaurusEntry.compareTo(otherThesaurusEntry));
    }


    public void testThesaurusEntryCompareTo_OtherIsGreater() {
        ThesaurusEntry otherThesaurusEntry = new ThesaurusEntry("football", new LinkedList());
        assertEquals("Returns -1 since this key is less than other key", -1,
                thesaurusEntry.compareTo(otherThesaurusEntry));
    }

    public void testThesaurusEntryCompareTo_ThisIsGreater() {
        ThesaurusEntry otherThesaurusEntry = new ThesaurusEntry("apple", new LinkedList());
        assertEquals("Returns 1 since this key is greater than other key", 1,
                thesaurusEntry.compareTo(otherThesaurusEntry));
    }

}