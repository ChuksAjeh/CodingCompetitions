import java.util.ArrayList;

public class Simulation {
    private static int[][] grid;
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static int bonus;
    private static int timeLimit;

    public Simulation(int[][] grid, ArrayList<Vehicle> vehicles, ArrayList<Ride> rides, int bonus, int timeLimit) {
        this.grid = grid;
        this.vehicles = vehicles;
        this.rides = rides;
        this.bonus = bonus;
        this.timeLimit = timeLimit;

    }

    public void updateSimulation(){
        while((!rides.isEmpty()) && (timeLimit != 0)){
            moveVehicles();
        }
    }

    private static void moveVehicles(){
        for(Vehicle v: vehicles){
            v.takeStep();
            //END OF EACH STEP DECREASE TIME BY 1
            timeLimit -=1;
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public int getBonus() {
        return bonus;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void assignRidesToVehicle(Vehicle v, ArrayList<Ride> rides) throws IllegalArgumentException {
        v.assignRides(rides);
    }

    public static void main(String[] args) {
        Ride firstRide = Parser.readSimulation("a_example.in").getRides().get(0);
        System.out.println("THE FIRST RIDE READ IN HAS START " + firstRide.getStartPoint().getX() + firstRide.getStartPoint().getY() + " AND END POINT " + firstRide.getEndPoint().getX() +firstRide.getEndPoint().getY());

    }
}
