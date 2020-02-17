import java.util.ArrayList;

public class CS {
	private final int ID;
	private int capacity;
	private ArrayList<Video> videos;

	public CS(int ID, int capacity) {
		this.ID = ID;
		this.capacity = capacity;
		videos = new ArrayList<>();
	}

	public void addVideo(Video video) throws IllegalArgumentException {
		if (video.getSize() < capacity) {
			videos.add(video);
			capacity -= video.getSize();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}

	public int getCapacity() {
		return capacity;
	}

	public String toString() {

		String output = String.valueOf(ID);
		for (Video video : videos) {
			output = output + " " + video.getID();
		}
		return output;

	}

	public int getID() {
		return ID;
	}
}
