package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Tests for GrammarCheckerClass
 * @author Jack Rubin
 * @version 5/24/23
 *
 */
public class GrammarCheckerTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private GrammarChecker grammarChecker;

    @Before
    public void setUp() throws Exception {
        grammarChecker = new GrammarChecker("src/proj5/smallThesaurus.txt", 7);
    }

    @After
    public void tearDown() throws Exception {
        grammarChecker = null;
    }

    @Test
    public void testGrammarCheckerImproveGrammar () {
        System.out.println("Nothing changes since threshold is at 7");
        grammarChecker.improveGrammar("src/proj5/lamb.txt");
        System.out.println();
    }

    @Test
    public void testGrammarCheckerImproveGrammarWithChanges () {
        grammarChecker = new GrammarChecker("src/proj5/smallThesaurus.txt", 2);
        System.out.println("New output is produced since threshold is 2");
        grammarChecker.improveGrammar("src/proj5/lamb.txt");
    }

    }



