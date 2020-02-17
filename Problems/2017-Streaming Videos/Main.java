import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javafx.util.Pair;

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
		ArrayList<Request> requestlist = new ArrayList<>();
		for (Endpoint e : endpoints) {
			requestlist.addAll(e.getRequests());
		}
		requestlist.sort(Comparator.comparing(Request::getAmmount));
		Collections.reverse(requestlist);

		while (!requestlist.isEmpty()) {
			Request currentRequest = requestlist.get(0);
			ArrayList<Connection> possibleConnections = endpoints[currentRequest
					.getEndpointID()].getConnections();
			possibleConnections
					.sort(Comparator.comparing(Connection::getLatency));
			boolean added = false;
			int i = 0;
			while (!added) {
				if (i < possibleConnections.size()) {
					try {
						servers[possibleConnections.get(i).getCacheID()]
								.addVideo(videos[currentRequest.getVideoID()]);
						added = true;
						System.out.println("video "
								+ currentRequest.getVideoID() + " on server "
								+ possibleConnections.get(i).getCacheID());
					} catch (IllegalArgumentException e) {
						i++;
					}
				} else {
					System.out.println(currentRequest.getVideoID()
							+ " No server just data center");
					added = true;
				}
			}
			requestlist.remove(0);
		}

		// All cache servers have been assigned the relevant videos (albeit with
		// very ducktapey code)
		// Now just generate the output
		FileWriter fw = new FileWriter("src/out.txt");
		int serversUsed = 0;
		for (int j = 0; j < servers.length; j++) {
			if (servers[j].getVideos().size() > 0) {
				serversUsed++;
			}
		}
		fw.write(String.valueOf(serversUsed));
		for (int j = 0; j < servers.length; j++) {
			if (servers[j].getVideos().size() > 0) {
				fw.write("\n" + servers[j].toString());
			}
		}
		fw.close();
	}

	/**
	 * If the entire line is numerical use this
	 */
	public static int[] numArray(String[] array) {
		return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
	}
}
