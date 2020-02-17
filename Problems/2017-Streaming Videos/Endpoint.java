import java.util.ArrayList;

import javafx.util.Pair;

public class Endpoint {

	private final int ID;
	private ArrayList<Request> requests;
	private final int centerLatency;
	private ArrayList<Connection> connections;

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
		Request request = new Request(videoID, ID, number);
		requests.add(request);
	}

	public void addConnection(int serverID, int latency) {
		Connection connection = new Connection(serverID, ID, latency);
		connections.add(connection);
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public ArrayList<Request> getRequests() {
		return requests;
	}
}
