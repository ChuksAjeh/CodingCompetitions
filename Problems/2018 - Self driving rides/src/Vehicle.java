import java.util.ArrayList;

public class Vehicle {
    private static int currentActiveVehicles = 0;
    private int vehicleId;
    private Coord location;
    private boolean carryingRide;
    private ArrayList<Ride> rides;

    public Vehicle() {
        this.location = new Coord(0,0);
        this.vehicleId = currentActiveVehicles++;
        this.carryingRide = false;
    }

    public void assignRides(ArrayList<Ride> allocatedRides) throws IllegalArgumentException {
        if(this.rides.size() == 0){
            this.rides = allocatedRides;
        }
        else{
            throw new IllegalArgumentException("This vehicle already has assigned rides");
        }
    }

    public void takeStep() {
        Ride nextRide = rides.get(0);
        if(!carryingRide){
            if(reachedLocation(nextRide.getStartPoint())){
                carryingRide = true;
            }
            else{
                moveTowards(nextRide.getStartPoint());
            }

        }
        else{
            if(reachedLocation(nextRide.getEndPoint())){
                carryingRide = false;
                rides.remove(nextRide);
            }
            else{
                moveTowards(nextRide.getEndPoint());
            }
        }
    }

    private void moveTowards(Coord somePoint){
        int xDistance = location.getX() - somePoint.getX();
        int yDistance = location.getY() - somePoint.getY();

        //IF X DISTANCE = 0 THEN MOVE UP
        if(xDistance == 0){
            //IF DISTANCE IS POSITIVE
            if(yDistance > 0){
                location.setY(location.getY() - 1);
            }
            //IF ITS NEGATIVE
            else if(yDistance < 0){
                location.setY(location.getY() + 1);
            }
        }
        //IF Y DISTANCE = 0 THEN MOVE ACROSS
        else if(yDistance == 0){
            //IF DISTANCE IS POSITIVE
            if(xDistance > 0){
                location.setX(location.getX() - 1);
            }
            //IF ITS NEGATIVE
            else if(xDistance < 0){
                location.setX(location.getX() + 1);
            }
        }
        //ITS NOT ON THE RIGHT AXIS FOR EITHER COORD THEN BEGIN MOVING ON THE X AXIS (THIS IS JUST MY CHOICE)
        else{
            if(xDistance > 0){
                location.setX(location.getX() - 1);
            }
            //IF ITS NEGATIVE
            else if(xDistance < 0){
                location.setX(location.getX() + 1);
            }
        }
    }

    private boolean reachedLocation(Coord somePoint){
        int xDistance = location.getX() - somePoint.getX();
        int yDistance = location.getY() - somePoint.getY();

        //IF BOTH DISTANCES TO X AND Y ARE 0 THEN YOU ARE AT THE SPOT
        if(xDistance + yDistance == 0){
            return true;
        }
        return false;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public Ride getRide(int index){
        return this.rides.get(index);
    }

}
