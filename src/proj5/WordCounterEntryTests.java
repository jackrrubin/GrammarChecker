package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Tests for WordCounterEntry class.
 *
 * @author Jack Rubin
 * @version 5/24/23
 *
 */
public class WordCounterEntryTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private WordCounterEntry wordCounterEntry;

    @Before
    public void setUp() throws Exception {
        wordCounterEntry = new WordCounterEntry("basketball");
    }

    @After
    public void tearDown() throws Exception {
        wordCounterEntry = null;
    }

    @Test
    public void testWordCounterEntryNonDefaultConstructor_toString () {
        assertEquals ("A new WordCounterEntry.", "basketball: 1", wordCounterEntry.toString());
    }

    @Test
    public void testWordCounterEntry_IncrementFrequency () {
        wordCounterEntry.incrementFrequency();
        assertEquals ("An new WordCounterEntry with an incremented frequency.", "basketball: 2", wordCounterEntry.toString());
    }

    @Test
    public void testWordCounterEntry_GetFrequency () {
        int freq = wordCounterEntry.getFreq();
        assertEquals ("Returns frequency.", 1, freq);
    }

    @Test
    public void testWordCounterEntryCompareToWhenEqual() {
        WordCounterEntry otherWordCounterEntry = new WordCounterEntry("basketball");
        assertEquals("Returns 0 since keys are equal", 0,
                wordCounterEntry.compareTo(otherWordCounterEntry));
    }

    @Test
    public void testWordCounterEntryCompareTo_ThisIsGreater() {
        WordCounterEntry otherWordCounterEntry = new WordCounterEntry("apple");
        assertEquals("Returns 1 since this key is greater", 1,
                wordCounterEntry.compareTo(otherWordCounterEntry));
    }

    @Test
    public void testWordCounterEntryCompareTo_OtherIsGreater() {
        WordCounterEntry otherWordCounterEntry = new WordCounterEntry("cape");
        assertEquals("Returns -1 since other key is greater", -1,
                wordCounterEntry.compareTo(otherWordCounterEntry));
    }
}



