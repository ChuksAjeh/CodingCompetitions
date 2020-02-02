import java.util.ArrayList;

public class Simulation {
    private int[][] grid;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private int bonus;
    private int timeLimit;

    public Simulation(int[][] grid, ArrayList<Vehicle> vehicles, ArrayList<Ride> rides, int bonus, int timeLimit) {
        this.grid = grid;
        this.vehicles = vehicles;
        this.rides = rides;
        this.bonus = bonus;
        this.timeLimit = timeLimit;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void assignRidesToVehicle(Vehicle v, ArrayList<Ride> rides){
        //v.assignRides(rides);

    }

    public static void main(String[] args) {
        Ride firstRide = Parser.readSimulation("a_example.in").getRides().get(0);
        System.out.println("THE FIRST RIDE READ IN HAS START " + firstRide.getStartPoint().getX() + firstRide.getStartPoint().getY() + " AND END POINT " + firstRide.getEndPoint().getX() +firstRide.getEndPoint().getY());

    }
}
