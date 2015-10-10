import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileDataExtractor {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub InputStream stdout = new StreamGobbler(sess.getStdout());
		 

		FileReader resultFile = new FileReader("results.txt");
		 
        BufferedReader br = new BufferedReader(resultFile);



        while (true)

        {

                String line = br.readLine();

                if (line == null)

                        break;

                System.out.println(line);

	}

}
}
