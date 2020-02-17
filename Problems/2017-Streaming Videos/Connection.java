
public class Connection {
	private int cacheID;
	private int endpointID;
	private int latency;

	public Connection(int cacheID, int endpointID, int latency) {
		this.cacheID = cacheID;
		this.endpointID = endpointID;
		this.latency = latency;
	}

	public int getCacheID() {
		return cacheID;
	}

	public int getEndpointID() {
		return endpointID;
	}

	public int getLatency() {
		return latency;
	}

}
