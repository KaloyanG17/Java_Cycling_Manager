package cycling;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * CyclingPortal is a minimally compiling, but non-functioning implementor
 * of the CyclingPortalInterface interface.
 * 
 * @author Taariq Fadhill
 * @author Kaloyan Gaydarov
 * @version 4.20
 * @since 14/02/2022
 *
 */

public class Team implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    // Initializes number of teams to 0.
    private static int numberOfTeams = 0;
    // Initializes teamID.
    private int teamID;
    // Initializes teamName.
    private String teamName;
    // Initializes teamDesc.
    private String teamDesc;
    // Initializes points.
    private int points;
    // Creates array list 'Rider'.
    private ArrayList<Rider> teamRiders = new ArrayList<Rider>();
    // Initializes number of riders to 0.
    private static int numberOfRiders = 0;

    //-----------------------------------Setter methods-----------------------------------//
    /**
     * Sets the name of the team.
     * @param teamName name of the team.
     * Sets the description of the team.
     * @param teamDesc description of the team.
     * Sets the total points for the team.
     * @param points 
     * Adds points to the total points for the team.
     * @param points
     * Resets the number of teams to 0.
     * Resets the number of riders in a team to 0.
     */
    public void setTeamName(String teamName){this.teamName = teamName;}
    public void setTeamDesc(String teamDesc){this.teamDesc = teamDesc;}
    public void setTeamPoints(int points){this.points = points;}
    public void addTeamPoints(int points){this.points = this.points + points;}
    public static void resetNumberOfTeams() {numberOfTeams = 0;}
    public static void resetNumberOfRiders() {numberOfRiders= 0;}

    //-----------------------------------Getter methods-----------------------------------//
    /**
     * Gets the team ID of the object.
     * @return the team ID.
     * Gets the name of the team.
     * @return the name of the team.
     * Gets the description of the team.
     * @return description of the team.
     * Gets the total points for a team.
     * @return total points.
     * Gets the number of riders in a team.
     * @return number of riders.
     * Gets riders which are in a team.
     * @return riders in a given team as an array.
     * Gets riders based on their riderID.
     * @return riders as an object.
     * 
     * 
     * Gets the details of the team.
     * @param teamID the ID of the team.
     * @param teamName the name of the team.
     * @param teamDesc description of the team.
     * @param points total points for the team.
     */
    public int getTeamID() {return teamID;}
    public String getTeamName() {return teamName;}
    public String getTeamDesc() {return teamDesc;}
    public int getTeamPoints(){return points;}
    public int getNumberOfTeamRiders(){ return numberOfRiders;}
    public Rider[] getRiders() {
        Rider[] riderArray = new Rider[teamRiders.size()];
        riderArray = teamRiders.toArray(riderArray);
        return riderArray;
    }
    public Rider getRider(int riderID)  {
        for (Rider rider : teamRiders) {
            if (rider.getRiderID() == riderID) {
                return rider;
            }
        }
        return new Rider();
    }
    public String getTeamDetails() {
        return "ID: "+teamID+" | Name: "+teamName+" | Description: "+teamDesc+" | Points: "+points;
    }
 
    //---------------------------------Constructer methods----------------------------------//
    /**
     * Creates object 'Team' with initialized values of 'Null', 'Null', 0 and 0 respectively.
     */
    public Team() {
        this.teamName = "Null";
        this.teamDesc = "Null";
        this.teamID = 0;
        this.points = 0;
    }
    
    /**
     * Creates object 'Team' with initialized values.
     * @param teamName the name of the team.
     * @param teamDesc description of a given team.
     * @param teamID ID of the team.
     * @param points points of the team.
     */
    public Team(String teamName, String teamDesc) {
        this.teamName = teamName;
        this.teamDesc = teamDesc;
        this.teamID = ++numberOfTeams;
        this.points = 0;
    }

     //---------------------------------Remover & Adder methods----------------------------------//
    /**
     * Creates method for removing a rider from a given team.
     * @param rider object 'rider' that will be removed.
     * 
     * Creates method for adding a rider to a given team.
     * @param rider object 'rider' that will be added.
     */
     public void removeRider(Rider rider) {
        teamRiders.remove(rider);
        --numberOfRiders;
    }
    public void addRider(Rider newRider) {
        teamRiders.add(newRider);
        numberOfRiders++;
    }
}