import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;


public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String FILENAME = "test.scala";

		CharStream input = null;
		try {
			input = new ANTLRFileStream(FILENAME);
		} catch (IOException e1) {
			System.err.println("Unable to open " + FILENAME);
			System.exit(1);
		}
		
		ScalaSubsetLexer lexer = new ScalaSubsetLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		ScalaSubsetParser parser = new ScalaSubsetParser(tokens); 
		try {
			parser.compilationUnit();
			System.out.println("OK");
		} catch (RecognitionException e) {
			e.printStackTrace();
		} 
	}
}
