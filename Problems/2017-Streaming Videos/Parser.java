import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	/**
	 * Returns ArrayList of every line of a file.
	 */
	public static ArrayList<String> getLines(String filepath)
			throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(filepath));

		ArrayList<String> lines = new ArrayList<>();

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();
		return lines;
	}

}