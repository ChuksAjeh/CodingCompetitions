public class Ride {
    private Coord startPoint;
    private Coord endPoint;
    private int earliest;
    private int latest;

    public Ride(Coord startPoint, Coord endPoint, int earliest, int latest) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.earliest = earliest;
        this.latest = latest;
    }

    public Coord getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coord startPoint) {
        this.startPoint = startPoint;
    }

    public Coord getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Coord endPoint) {
        this.endPoint = endPoint;
    }

    public int getEarliest() {
        return earliest;
    }

    public void setEarliest(int earliest) {
        this.earliest = earliest;
    }

    public int getLatest() {
        return latest;
    }

    public void setLatest(int latest) {
        this.latest = latest;
    }
}
