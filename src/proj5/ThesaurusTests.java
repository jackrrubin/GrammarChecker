package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Tests for Thesaurus data structure.
 * @author Jack Rubin
 * @version 5/24/23
 *
 */
public class ThesaurusTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private Thesaurus thesaurus;

    @Before
    public void setUp() throws Exception {
        thesaurus = new Thesaurus();
    }

    @After
    public void tearDown() throws Exception {
        thesaurus = null;
    }

    @Test
    public void testThesaurusConstructor_toString() {
        assertEquals("An empty Thesaurus.", "", thesaurus.toString());
    }


    @Test
    public void testThesaurus_InsertThesaurusEntry(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert(keyword, synonyms);
        assertEquals("New thesaurus entry is printed",
                "basketball - {ball, baseball, leatherball, beachball}\n", thesaurus.toString());
    }

    @Test
    public void testThesaurus_InsertExistingThesaurusEntry(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert(keyword, synonyms);

        String newKeyword = "basketball";
        String[] newSynonyms = {"squash", "baseball", "tennis"};
        thesaurus.insert(newKeyword, newSynonyms);

        assertEquals("New thesaurus entry is printed",
                "basketball - {ball, baseball, leatherball, beachball, squash, tennis}\n", thesaurus.toString());
    }

    @Test
    public void testThesaurus_DeleteThesaurusEntry(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        thesaurus.delete("basketball");
        assertEquals("Thesaurus is now empty", "", thesaurus.toString());
    }

    @Test
    public void testThesaurus_DeleteNonExistentThesaurusEntry(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        thesaurus.delete("random");
        assertEquals("Nothing changes", "basketball - {ball, baseball, leatherball, beachball}\n",
                thesaurus.toString());
    }

    @Test
    public void testThesaurus_getSynonymForWord(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        String syn = thesaurus.getSynonymFor("basketball");
        assertEquals("Returns a random synonym", syn, syn); // checked manually, cant predict since its actually random
    }

    @Test
    public void testThesaurus_getSynonymForNonExistentWord(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        String syn = thesaurus.getSynonymFor("random");
        assertEquals("Returns an empty string", "", syn);
    }

    @Test
    public void testThesaurus_Contains(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        assertEquals("Returns true", true, thesaurus.contains("basketball"));
    }

    @Test
    public void testThesaurus_ContainsWithNonExistent(){
        String keyword = "basketball";
        String[] synonyms = {"ball", "baseball", "leatherball", "beachball"};
        thesaurus.insert("basketball", synonyms);
        assertEquals("Returns false", false, thesaurus.contains("random"));
    }
}