import java.util.ArrayList;

import javafx.util.Pair;

public class Endpoint {

	private final int ID;
	private ArrayList<Pair<Integer, Integer>> requests;
	private final int centerLatency;
	private ArrayList<Pair<Integer, Integer>> connections;

	public Endpoint(int ID, int centerLatency) {
		requests = new ArrayList<>();
		connections = new ArrayList<>();
		this.ID = ID;
		this.centerLatency = centerLatency;
	}

	public int getID() {
		return ID;
	}

	public int getCenterLatency() {
		return centerLatency;
	}

	public void addRequest(int videoID, int number) {
		Pair<Integer, Integer> request = new Pair<Integer, Integer>(videoID,
				number);
		requests.add(request);
	}

	public void addConnection(int serverID, int latency) {
		Pair<Integer, Integer> connection = new Pair<Integer, Integer>(serverID,
				latency);
		connections.add(connection);
	}

	public ArrayList<Pair<Integer, Integer>> getRequests() {
		return requests;
	}
}
