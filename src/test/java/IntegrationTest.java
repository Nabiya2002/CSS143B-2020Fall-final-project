import edu.uwb.css143b2020fall.service.Indexer;
import edu.uwb.css143b2020fall.service.IndexerImpl;
import edu.uwb.css143b2020fall.service.Searcher;
import edu.uwb.css143b2020fall.service.SearcherImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private Indexer indexer;
    private Searcher searcher;

    @Before
    public void setUp() {
        indexer = new IndexerImpl();
        searcher = new SearcherImpl();
    }

    @Test
    public void testIntegration() {
        List<TestCase> cases = getTestCase();
        for (TestCase testCase : cases) {
            List<Integer> actual = searcher.search(
                    testCase.target,
                    indexer.index(testCase.documents)
            );
            assertEquals(testCase.expect, actual);
        }
    }

    @Test
    public void testMyIntegration() {
        List<TestCase> cases = getMyTestCase();
        for (TestCase testCase : cases) {
            List<Integer> actual = searcher.search(
                    testCase.target,
                    indexer.index(testCase.documents)
            );
            assertEquals(testCase.expect, actual);
        }
    }

    private List<TestCase> getMyTestCase() {
        List<String> documents = Util.getMyDocumentsForIntTest();

        List<TestCase> testCases = new ArrayList<>(Arrays.asList(
                new TestCase(
                        documents,
                        "java project",
                        new ArrayList<>(Arrays.asList(3, 7))
                ),
                new TestCase(
                        documents,
                        "this does not exist",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "java",
                        new ArrayList<>(Arrays.asList(3, 4, 6, 7))
                ),
                new TestCase(
                        documents,
                        "green button",
                        new ArrayList<>(Arrays.asList(1, 8))
                ),
                new TestCase(
                        documents,
                        "the final java project is awesome",
                        new ArrayList<>(Arrays.asList(7))
                )
        ));

        return testCases;
    }

    private List<TestCase> getTestCase() {
        List<String> documents = Util.getDocumentsForIntTest();

        List<TestCase> testCases = new ArrayList<>(Arrays.asList(
                new TestCase(
                        documents,
                        "",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "hello world",
                        new ArrayList<>(Arrays.asList(0, 1, 6))
                ),
                new TestCase(
                        documents,
                        "llo wor",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "wor",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "hello",
                        new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 6))
                ),
                new TestCase(
                        documents,
                        "just world",
                        new ArrayList<>(Arrays.asList(0))
                ),
                new TestCase(
                        documents,
                        "sunday",
                        new ArrayList<>(Arrays.asList(6))
                ),
                new TestCase(
                        documents,
                        "hello world fun",
                        new ArrayList<>(Arrays.asList(6))
                ),
                new TestCase(
                        documents,
                        "world world fun",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "office",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "ryan murphy",
                        Util.emptyResult()
                ),
                new TestCase(
                        documents,
                        "new macbook",
                        new ArrayList<>(Arrays.asList(7))
                ),
                new TestCase(
                        documents,
                        "is awesome",
                        new ArrayList<>(Arrays.asList(7))
                )
        ));

        return testCases;
    }

    private class TestCase {
        private List<String> documents;
        private String target;
        private List<Integer> expect;

        public TestCase(List<String> documents, String target, List<Integer> expect) {
            this.documents = documents;
            this.target = target;
            this.expect = expect;
        }
    }
}