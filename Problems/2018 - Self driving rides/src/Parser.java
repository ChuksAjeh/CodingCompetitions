import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    //basic file reader that opens and reads the file
    public static Simulation readSimulation(String filename){

        File fileIn = new File(filename);

        Scanner scan = null;

        try{

            scan = new Scanner(fileIn);

        }catch (FileNotFoundException e){

            System.out.println("Unable to open file or file not found.");

            System.exit(0);

        }



        return Parser.readSimulation(scan);

    }



    /**

     * @param in overloads the readProfileSet method and takes in the scanned file.

     *           a nested scanner then looks at each line of the file and parses it

     *           into the create profile method whilst that profile is inserted into

     *           the tree.

     * */
    // reads the file and and will assign the
    private static Simulation readSimulation(Scanner in){
        in.useDelimiter("\n");
        Scanner curLine = new Scanner(in.nextLine());
        curLine.useDelimiter(" ");

        int rows = curLine.nextInt();
        int cols = curLine.nextInt();
        int numVehicles = curLine.nextInt();
        int numRides = curLine.nextInt();
        int bonus = curLine.nextInt();
        int timeLimit = curLine.nextInt();
        ArrayList<Ride> rides = new ArrayList<Ride>();
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        int cnt =0;
        for(int i=0; i<numVehicles; i++){
            vehicles.add(new Vehicle());
        }

        while(in.hasNextLine() && cnt < numRides ){

            curLine = new Scanner(in.nextLine());
            Ride someRide = readRide(curLine);
            rides.add(someRide);
        }

        int[][] grid = new int[rows][cols];
        return  new Simulation(grid, vehicles,rides, bonus, timeLimit);

    }

    private static Ride readRide (Scanner in ){

        int startX = in.nextInt();
        int startY = in.nextInt();
        Coord start = new Coord(startX,startY);
        int endX = in.nextInt();
        int endY = in.nextInt();
        Coord end = new Coord(endX,endY);
        int earliest = in.nextInt();
        int latest = in.nextInt();
        return new Ride(start,end,earliest,latest);
    }


}
