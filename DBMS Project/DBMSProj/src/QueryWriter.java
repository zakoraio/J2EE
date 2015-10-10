import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class QueryWriter {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String query = args[0];
		PrintWriter writer = new PrintWriter("Query.txt", "UTF-8");
		writer.println(query);
		writer.close();

	}

}
