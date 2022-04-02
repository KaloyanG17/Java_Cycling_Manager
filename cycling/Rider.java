package cycling;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * CyclingPortal is a minimally compiling, but non-functioning implementor
 * of the CyclingPortalInterface interface.
 * 
 * @author Kaloyan Gaydarov
 * @author Taariq Fadhill
 * @version 4.20
 * @since 14/02/2022
 *
 */

public class Rider implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    // Initializes the number of riders to 0. 
    private static int numberOfRiders = 0;
    // Initializes teamID.
    private int teamID;
    // Initializes riderName.
    private String riderName;
    // Initializes yearOfBirth.
    private int yearOfBirth;
    // Initializes riderID.
    private int riderID;
    // Initializes points.
    private int points;
    // Initializes array of objects of results.
    private ArrayList<Results> resultsArray = new ArrayList<Results>();

    //-----------------------------------Setter methods-----------------------------------//
    /**
     * Sets the rider name.
     * @param riderName name of the rider.
     * 
     * Sets the team ID.
     * @param teamID ID of the team the rider is in.
     * 
     * Sets the year of birth.
     * @param yearOfBirth year that the rider was born, must be 2010 < yearOfBirth > 1900.
     * 
     * Resets the number of riders in a team, setting to 0 .
     * 
     * Sets points for the rider.
     * @param points points that will be stored in the rider object.
     * 
     * Adds points to the rider object.
     * @param points points that will be stored in the rider object.
     * 
     * Adds the result of the rider to the results array.
     * @param results result of the rider that will be stored in the results array.
     */
    public void setRiderName(String riderName){this.riderName= riderName;}
    public void setTeamID(int teamID){this.teamID= teamID;}
    public void setYearOfBirth(int yearOfBirth){this.yearOfBirth= yearOfBirth; }
    public static void resetNumberOfRiders() {numberOfRiders = 0;}
    public void setRiderPoints(int points){this.points = points;}
    public void addRiderPoints(int points){this.points = this.points + points;}
    public void addRiderResult(Results results){resultsArray.add(results);}

    //-----------------------------------Getter methods-----------------------------------//
    /**
     * Gets the team ID of the object.
     * @return the team ID.
     * Gets the name of the rider.
     * @return name of the rider.
     * Gets the year of birth of the rider.
     * @return year that the rider was born, must be 2010 < yearOfBirth > 1900.
     * Gets the rider ID of the object.
     * @return the rider ID.
     * Gets the points for the given rider.
     * @return points assigned to the specific rider.
     * Gets the array list of object: results.
     * @return array list of object: results.
     * 
     * 
     * Gets the details of the rider.
     * @param riderID the ID of the rider.
     * @param riderName the name of the rider.
     * @param teamID the ID of the team the rider is assigned to.
     * @param yearOfBirth year that the rider was born, must be 2010 < yearOfBirth > 1900.
     * @param points points the rider as acquired.
     */
    public int getTeamID() {return teamID;}
    public String getRiderName() {return riderName;}
    public int getYearOfBirth() {return yearOfBirth;}
    public int getRiderID() {return riderID;}
    public int getRiderPoints() {return points;}
    public Results[] getRiderResults() {
        Results[] resultArr = new Results[resultsArray.size()];
        resultArr = resultsArray.toArray(resultArr);
        return resultArr;
    };
    public String getRiderDetails() {
        return "Rider ID: "+riderID+" | Name: "+riderName+" | Team ID: "+teamID+" | Year Of Birth: "+yearOfBirth+" | Points: "+points;
    }

    //---------------------------------Constructer methods----------------------------------//
    /**
     * Creates object 'Rider' with initialized values of 0, 'Null', 0, 0 and 0 respectively.
     */
    public Rider() {
        teamID = 0;
        riderName = "Null";
        yearOfBirth = 0;
        riderID = 0;
        points = 0;
    }

    /**
     * Creates object 'Rider' with initialized values.
     * @param teamID ID of the team the rider is assigned to.
     * @param riderName name of the rider.
     * @param yearOfBirth year that the rider was born, must be 2010 < yearOfBirth > 1900.
     * @param riderID ID of the rider.
     * @param points points acquired by the rider.
     */
    public Rider(int teamID, String riderName , int yearOfBirth) {
        this.teamID = teamID;
        this.riderName = riderName;
        this.yearOfBirth = yearOfBirth;
        this.riderID = ++numberOfRiders;
        this.points = 0;
           
    }
    //---------------------------------Remover methods----------------------------------//
    /**
     * Creates method for removing a rider.
     * @param result object result that will be removed.
     * @throws IDNotRecognisedException The ID of the rider does not exist.
     */
    public void removeResults(Results result) throws IDNotRecognisedException {
        resultsArray.remove(result);
    }

}
    
