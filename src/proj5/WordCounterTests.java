package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Tests for WordCounter data structure.
 *
 * @author Jack Rubin
 * @version 5/24/23
 */
public class WordCounterTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private WordCounter wordCounter;

    @Before
    public void setUp() throws Exception {
        wordCounter = new WordCounter();
    }

    @After
    public void tearDown() throws Exception {
        wordCounter = null;
    }

    @Test
    public void testWordCounterDefaultConstructor_toString () {
        assertEquals ("An empty WordCounter.", "", wordCounter.toString());
    }

    @Test
    public void testWordCounterFindFrequencies () {
        wordCounter.findFrequencies("src/proj5/lamb.txt");
        assertEquals ("A word counter with labeled frequencies.", "a: 2\n" + "and: 2\n" +
                "as: 1\n" + "everywhere: 2\n" + "fleece: 1\n" +
                "go: 1\n" + "had: 2\n" + "its: 1\n" + "lamb: 5\n" + "little: 4\n" + "mary: 6\n" +
                "snow: 1\n" + "sure: 1\n" + "that: 2\n" + "the: 1\n" + "to: 1\n" + "was: 2\n" + "went: 4\n" +
                "white: 1\n", wordCounter.toString());
    }
    @Test
    public void testWordCounterGetFrequency () {
        wordCounter.findFrequencies("src/proj5/lamb.txt");
        assertEquals ("A word counter with labeled frequencies.",6, wordCounter.getFrequency("mary"));
    }

    @Test
    public void testWordCounterGetFrequencyOfNonExistingEntry() {
        wordCounter.findFrequencies("src/proj5/lamb.txt");
        assertEquals ("A word counter with labeled frequencies.",0, wordCounter.getFrequency("random"));
    }

    }



