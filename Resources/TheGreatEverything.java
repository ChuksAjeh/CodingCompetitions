import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TheGreatEverything {

	/**
	 * Change number of run calls and their parameters based on problem set
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		run("resources/example1.txt", "resources/example1output.txt");
		run("resources/example2.txt", "resources/example2output.txt");
		run("resources/example3.txt", "resources/example3output.txt");
	}

	public static void run(String input, String output) throws IOException {
		System.out.println("Starting file: " + input + "...");

		ArrayList<String> lines = getLines(input);

		// TODO: implement input - expect to use a variable lineNumber to
		// itterate through lines, use intArray if relevant

		// TODO: implement solution

		FileWriter fw = new FileWriter(output);

		// TODO: implement output - FileWriter goes character by character,
		// remember to use \n where appropiate

		fw.close();

		System.out.println("Complete! Result written to " + output);
	}

	/**
	 * Converts a string array to an integer array
	 * 
	 * @param array
	 * @return
	 */
	static int[] intArray(String[] array) {
		return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
	}

	/**
	 * Reads the file
	 * 
	 * @param filepath
	 * @return Array of strings representing each line of the file
	 * @throws IOException
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
