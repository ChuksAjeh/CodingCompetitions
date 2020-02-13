public class Description {
    int requestedVideoID;
    int clientEndpointID;
    int numOfRequests;

    public Description(int requestedVid, int clientID, int requests){
        this.requestedVideoID = requestedVid;
        this.clientEndpointID = clientID;
        this.numOfRequests = requests;
    }
}
