package example1;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.junit.*;
import static org.junit.Assert.*;

public class StringTokenizerTest {

	StringTokenizer st;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testNextToken() {
		st = new StringTokenizer("this is a test");
		assertEquals("this", st.nextToken());
	}

	@Test
	public void testNextTokenwithTabulatorDelimiter() {
		st = new StringTokenizer("this\tis a test");
		assertEquals("this", st.nextToken());
	}

	@Test
	public void testNextTokenwithNewLineDelimiter() {
		st = new StringTokenizer("this\nis a test");
		assertEquals("this", st.nextToken());
	}

	@Test
	public void testNextTokenwithCarriageReturnDelimiter() {
		st = new StringTokenizer("this\ris a test");
		assertEquals("this", st.nextToken());
	}

	@Test
	public void testNextTokenwithFormfeedDelimiter() {
		st = new StringTokenizer("this\fis a test");
		assertEquals("this", st.nextToken());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextTokenWithoutNextToken() {
		st = new StringTokenizer("");
		st.nextToken();
	}

	@Test(expected = ComparisonFailure.class)
	public void testNextTokenwithSameCharacters() {
		st = new StringTokenizer("ffffffffffff");
		assertEquals("this", st.nextToken());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextTokenwithOnlyDelimiters() {
		st = new StringTokenizer("\t\n\r\f");
		assertEquals("this", st.nextToken());
	}

	@Test(expected = AssertionError.class)
	public void testCountTokenswithStringIntCompare() {
		st = new StringTokenizer("this is a test");
		assertEquals("this", st.countTokens());
	}

	@Test
	public void testCountToken() {
		st = new StringTokenizer("this is a test");
		assertEquals(4, st.countTokens());
	}
}
