import java.util.ArrayList;

public class Datasource {
    int numOfVideos;
    int numOfEndpoints;
    int numOfDescriptions;
    int numOfCServers;
    int CServerCapacity;

    int[] videoSizes;
    ArrayList<Endpoint> allEndpoints;
    ArrayList<Description> allDescriptions;

    public Datasource(int numOfVideos, int numOfEndpoints, int numOfDescriptions, int numOfCServers, int CServerCapacity, int[] videoSizes, ArrayList<Endpoint> allEndpoints, ArrayList<Description> allDescriptions) {
        this.numOfVideos = numOfVideos;
        this.numOfEndpoints = numOfEndpoints;
        this.numOfDescriptions = numOfDescriptions;
        this.numOfCServers = numOfCServers;
        this.CServerCapacity = CServerCapacity;
        this.videoSizes = videoSizes;
        this.allEndpoints = allEndpoints;
        this.allDescriptions = allDescriptions;
    }

    public static void main(String[] args) {
        Datasource testing = Parser.readDatasource("me_at_the_zoo.in");
        System.out.println(testing.allEndpoints.get(0).datacentreToHereLatency);
    }
}
