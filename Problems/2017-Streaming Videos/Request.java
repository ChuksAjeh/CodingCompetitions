
public class Request {
	private int endpointID;
	private int videoID;
	private int ammount;

	public Request(int videoID, int endpointID, int ammount) {
		this.ammount = ammount;
		this.videoID = videoID;
		this.endpointID = endpointID;
	}

	public int getAmmount() {
		return ammount;
	}

	public int getEndpointID() {
		return endpointID;
	}

	public int getVideoID() {
		return videoID;
	}
}
