import java.util.ArrayList;

public class Endpoint {
    double datacentreToHereLatency;
    int serverConnections;
    ArrayList<Connection> connections = new ArrayList<>();

    public Endpoint(int latency, int cacheServers) {
    }

    public void addConnection(Connection c){
        connections.add(c);
    }

}
