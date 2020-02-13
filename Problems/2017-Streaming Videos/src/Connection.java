public class Connection {
    int id;
    double serverToEndpointLatency;

    public Connection(int id, double latency){
        this.id = id;
        serverToEndpointLatency = latency;
    }

}
