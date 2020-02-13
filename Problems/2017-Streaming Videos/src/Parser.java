import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    //basic file reader that opens and reads the file
    public static Datasource readDatasource(String filename){

        File fileIn = new File(filename);

        Scanner scan = null;

        try{

            scan = new Scanner(fileIn);

        }catch (FileNotFoundException e){

            System.out.println("Unable to open file or file not found.");

            System.exit(0);

        }



        return Parser.readDatasource(scan);

    }



    /**

     * @param in overloads the readProfileSet method and takes in the scanned file.

     *           a nested scanner then looks at each line of the file and parses it

     *           into the create profile method whilst that profile is inserted into

     *           the tree.

     * */
    // reads the file and and will assign the
    private static Datasource readDatasource(Scanner in){


        int numOfVideos = in.nextInt();
        int numOfEndpoints = in.nextInt();
        int numOfDescriptions = in.nextInt();
        int numOfCServers = in.nextInt();
        int CServerCapacity = in.nextInt();


        //Next line is now videos in order and their sizes i.e video 1 2 3 4

        int[] videoSizes = new int[numOfVideos];
        ArrayList<Endpoint> allEndpoints = new ArrayList<Endpoint>();
        ArrayList<Description> allDescriptions = new ArrayList<Description>();

        in.useDelimiter("\n |  ");
        int count = 0;


        for(int endpoint = 0; endpoint < numOfEndpoints; endpoint++){
            int latency = curLine.nextInt();
            int cacheServers = curLine.nextInt();
            Endpoint someEndpoint = new Endpoint(latency, cacheServers);
            while(curLine.hasNextLine() & count < numOfEndpoints){
                Scanner currentLine = new Scanner(curLine.nextLine());
                Connection newConnection = readEndpointConnection(currentLine);
                someEndpoint.addConnection(newConnection);
            }
            count+=1;
        }

        while (in.hasNextLine()){
            Scanner descLine = new Scanner(in.nextLine());
            allDescriptions.add(readDescription(descLine));
        }



        return  new Datasource(numOfVideos, numOfEndpoints, numOfDescriptions, numOfCServers, CServerCapacity, videoSizes, allEndpoints, allDescriptions);

    }

    private static Connection readEndpointConnection(Scanner in){
        int serverID = in.nextInt();
        int latency = in.nextInt();
        return new Connection(serverID, latency);
    }

    private static Description readDescription(Scanner in){
        int requestedVideoID = in.nextInt();
        int clientEndpointID = in.nextInt();
        int numOfRequests = in.nextInt();
        return new Description(requestedVideoID, clientEndpointID, numOfRequests);
    }


}
