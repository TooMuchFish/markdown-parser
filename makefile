CLASSPATH = lib/*:.
TryCommonMark.class: TryCommonMark.java
	javac -cp $(CLASSPATH) TryCommonMark.java
MarkdownParse.class:MarkdownParse.java 
	javac MarkdownParse.java
MarkdownParseTest.class:MarkdownParseTest.java MarkdownParse.class
	javac -cp $(CLASSPATH) MarkdownParseTest.java
test: MarkdownParseTest.class MarkdownParse.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest