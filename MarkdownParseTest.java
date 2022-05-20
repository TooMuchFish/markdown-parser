import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/*
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
*/

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLink()throws IOException{
        Path testFile = Path.of("test1.md");
        String result = Files.readString(testFile);
        ArrayList<String> links = MarkdownParse.getLinks(result);
        List<String> output = List.of("https://something.com", "some-page.html");
        assertEquals(output,links);
    }
    @Test
    public void testGetLinks1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("`google.com");
        expectedoutput.add("google.com");
        expectedoutput.add("ucsd.edu");
        assertEquals(expectedoutput, links);
    }
    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("a.com");
        expectedoutput.add("a.com(())");
        expectedoutput.add("example.com");
        assertEquals(expectedoutput, links);
    }
    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // Expected output
        ArrayList<String> expectedoutput = new ArrayList<>();
        expectedoutput.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expectedoutput, links);
    }
    
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        System.out.println(links); 
    }
}
