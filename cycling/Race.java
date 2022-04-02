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

public class Race implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    // Initializes number of races to 0.
    private static int numberOfRaces = 0;
    // Initializes raceID.
    private int raceID;
    // Initializes raceName.
    private String raceName;
    // Initializes raceDesc.
    private String raceDesc;
    // Initializes number of stages to 0.
    private static int numberOfStages = 0;
    // Initializes array of objects of stages.
    private ArrayList<Stage> stages;

    //-----------------------------------Setter methods-----------------------------------//
    /**
	 * Sets the race name according to the raceName and raceDesc objects.
     * @param raceName name of the race.
     * 
     * Sets the race description according to the raceName and raceDesc objects.
     * @param raceDesc description of the race.
     * 
     * Resets number of races, setting to 0.
     * Resets number of stages in a race, setting to 0.
     * Adds a stage from the objects stage.
     * @param stage where object stages are stored. 
     */
    public void setRaceName(String raceName){this.raceName= raceName;}
    public void setraceDesc(String raceDesc){this.raceDesc= raceDesc;}
    public static void resetNumberOfRaces() {numberOfRaces = 0;}
    public static  void resetNumberOfStages() {numberOfStages = 0;}
    public void addStage(Stage stage) {
        stages.add(stage);
        numberOfStages++;
    }
    

    //-----------------------------------Getter methods-----------------------------------//
    /**
	 * Gets the race ID of the object.
     * @return the race ID. 
     * Gets the race name of the object.
     * @return the race name.
     * Gets the race description.
     * @return the race description.
     * Gets the array list of object: stages.
     * @return array list of object: stages.
     * Gets the number of stages.
     * @return the number of stages in the object.
     * 
     * 
     * Gets the details of the race.
     * @param raceId the ID of the race.
     * @param raceName the name of the race.
     * @param raceDesc the description of the race.
     * @param numberOfStages the number of stages in the race.
     * @param totalLength the total length of the race in km.
	 */
    public int getRaceID() {return raceID;}
    public String getRaceName(){return raceName;}
    public String getRaceDesc(){return raceDesc;}
    public ArrayList<Stage> getStages() {return stages;}
    public Stage[] getStagesV2() {
        Stage[] stageArray = new Stage[stages.size()];
        stageArray = stages.toArray(stageArray);
        return stageArray;
    }
    public int getNumberOfStages() {return numberOfStages;}
    double getTotalLength() {
        double totalLength = 0;
        double length;
        for (Stage stage : stages) {
            length = stage.getStageLength();
            assert (length >= 0);
            totalLength += length;
        }
        return totalLength;
    }
    public String getRaceDetails() {
        double totalLength = getTotalLength();
        return "ID: "+raceID+" | Name: "+raceName+" | Description: "+raceDesc+" | Number of Stages: "+numberOfStages+" | Total Length: "+totalLength;
    }

    //---------------------------------Constructer methods----------------------------------//
    /**
	 * Creates Object 'Race' with initialized values of 'Null', 'Null' and '0' respectively, and an empty array. 
	 */
    public Race(){
        this.raceName = "Null";
        this.raceDesc = "Null";
        this.raceID = 0;
        this.stages = new ArrayList<>();
    }
    
    /**
	 * Creates Object 'Race' with initialized values.
     * @param raceName the name of a given race.
     * @param raceDesc the description of a given race.
	 */
    public Race(String raceName, String raceDesc){
        this.raceName = raceName;
        this.raceDesc =raceDesc;
        this.raceID = ++numberOfRaces;
        this.stages = new ArrayList<>();
    }

    //---------------------------------Remover methods----------------------------------//
    /**
	 * Creates method for removing a stage.
     * @param stage object 'stage' that will be removed.
     * @exception IDNotRecognisedException The ID of the stage does not exist.
	 */
    public void removeStage(Stage stage) throws IDNotRecognisedException {
        if (!stages.contains(stage)) {
            throw new IDNotRecognisedException("stage does not exist in race with Id '"+raceID+"'");
        }
        stages.remove(stage);
        numberOfStages--;
    }
    
}

