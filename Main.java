import java.io.IOException;
import java.util.ArrayList;

public class Main {

	/**
	 * Assuming test file is placed directly into the source directory
	 */
	public static void main(String[] args) throws IOException {
		handleLines(Parser.getLines("src/example.txt"));
	}

	/**
	 * TODO: per case implementation of file
	 */
	public static void handleLines(ArrayList<String> lines) {
	}

}
