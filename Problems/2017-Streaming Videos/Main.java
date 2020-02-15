import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	/**
	 * Assuming test file is placed directly into the source directory
	 */
	public static void main(String[] args) throws IOException {

		ArrayList<String> lines = Parser.getLines("src/example.txt");
		int lineNumber = 0;
		int[] line = numArray(lines.get(lineNumber).split(" "));

		Video[] videos = new Video[line[0]];
		Endpoint[] endpoints = new Endpoint[line[1]];
		CS[] servers = new CS[line[3]];

		int requests = line[2];

		int capacities = line[4];
		for (int i = 0; i < line[3]; i++) {
			servers[i] = new CS(i, capacities);
		}

		System.out.println(line[0] + " videos, " + line[1] + " endpoints, "
				+ line[2] + " requests, " + line[3] + " servers, " + line[4]
				+ " of size");

		lineNumber++;
		line = numArray(lines.get(lineNumber).split(" "));
		for (int i = 0; i < videos.length; i++) {
			videos[i] = new Video(i, line[i]);

			System.out.println("video " + i + ": " + line[i]);
		}

		for (int i = 0; i < endpoints.length; i++) {
			lineNumber++;
			line = numArray(lines.get(lineNumber).split(" "));
			endpoints[i] = new Endpoint(i, line[0]);
			int caches = line[1];

			System.out.println("endpoint " + i + " has " + line[0]
					+ "data center lat and " + line[1] + " caches");
			for (int j = 0; j < caches; j++) {
				lineNumber++;
				line = numArray(lines.get(lineNumber).split(" "));
				endpoints[i].addConnection(line[0], line[1]);

				System.out.println("lat cache " + line[0] + ": " + line[1]);
			}
		}

		for (int i = 0; i < requests; i++) {
			lineNumber++;
			line = numArray(lines.get(lineNumber).split(" "));
			endpoints[line[1]].addRequest(line[0], line[2]);

			System.out.println("video " + line[0] + "requested " + line[2]
					+ "times on endpoint " + line[1]);
		}

		// TODO: All data read from file, calculation and output needed.

		// First idea is to use give attention to the biggest requests first.
	}

	/**
	 * If the entire line is numerical use this
	 */
	public static int[] numArray(String[] array) {
		return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
	}
}
