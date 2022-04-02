package cycling;
import java.io.Serializable;
import java.time.LocalDateTime;
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

public class Stage implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    // Initializes number of stages to 0.
    private static int numberOfStages = 0;
    // Initializes stageID.
    private int stageID;
    //Initializes stageName.
    private String stageName;
    // Initializes stageDesc.
    private String stageDesc;
    // Initializes length.
    private double length;
    // Initializes type of stage.
    private StageType type;
    // Creates array list 'Segment'.
    private ArrayList<Segment> segmentsArray = new ArrayList<Segment>();;
    // Creates array list 'Results'
    private ArrayList<Results> resultsArray = new ArrayList<Results>();
    // Initializes number of segments to 0.
    private static int numberOfSegments = 0;
    // Initializes start time.
    private LocalDateTime startTime;
    // Initializes prepared object as 'true'.
    private boolean prepared = true;


    //-----------------------------------Prepare methods-----------------------------------//
    /**
     * Prepares function isPrepared()
     * @return state of is/isn't prepared
     */
    
    public boolean isPrepared() {return prepared;}
    public void prepare() {prepared = true;}

    
    //-----------------------------------Setter methods-----------------------------------//
    /**
     * Sets the start time of the stage.
     * @param startTime start time of the stage.
     * Sets the name of the stage.
     * @param stageName name of the stage.
     * Sets the description of the stage.
     * @param stageDesc description of the stage.
     * Sets the length of the stage.
     * @param length of the stage.
     * Sets the type of stage.
     * @param type of stage
     * 
     * Resets the number of stages to 0.
     * Resets the number of segements in a given stage to 0.
     */
    public void setStartTime(LocalDateTime startTime){this.startTime = startTime;}
    public void setStageName(String stageName){this.stageName = stageName;}
    public void setStageDesc(String stageDesc){this.stageDesc = stageDesc;}
    public void setStageLength(int length){this.length = length;}
    public void setType(StageType type){this.type = type;}
    public static void resetNumberOfStages() {numberOfStages = 0;}
    public static void resetNumberOfSegments() {numberOfSegments = 0;}


    //-----------------------------------Getter methods-----------------------------------//
    /**
     * Gets the stage ID of the object.
     * @return the stage ID.
     * Gets the name of the stage.
     * @return the name of the stage.
     * Gets the description of the stage.
     * @return description of the stage.
     * Gets the length of the stage.
     * @return the length of the stage in km.
     * Gets the type of stage.
     * @return type of stage.
     * Gets the stage results from the array list 'Results'.
     * @return results in the stage as an array.
     * Gets the start time in the stage.
     * @return the start time of the races in that stage.
     * Gets the segments which are in that stage.
     * @return segments as an array.
     * 
     * 
     * Gets the details of the stage.
     * @param stageID the ID of the stage.
     * @param stageName the name of the stage.
     * @param stageDesc the description of the stage.
     * @param numberOfSegments the number of segments in the stage.
     * @param stageLength the length of the stage in km.
     */
    public int getStageId() {return stageID;}
    public String getStageName() {return stageName;}
    public String getStageDescription() {return stageDesc;}
    public double getStageLength() {return length;}
    public StageType getStageType() {return type;}
    public ArrayList<Results> getStageResults() {return resultsArray;}
    public LocalDateTime getStartTime(){return startTime;}
    public Segment[] getStageSegments() {
        Segment[] segmentArray = new Segment[segmentsArray.size()];
        segmentArray = segmentsArray.toArray(segmentArray);
        return segmentArray;
    }
    public String getStageDetails() {
        double stageLength = getStageLength();
        return "ID: "+stageID+" | Name: "+stageName+" | Description: "+stageDesc+" | Number of Segements: "+numberOfSegments+" | Stage Length: "+stageLength;
    }

    
    //---------------------------------Constructer methods----------------------------------//
    /**
     * Creates object 'Stage' with initialized values of 'Null', 'Null', 0 and 0 respectively.
     */
    public Stage() {
        this.stageName = "Null";
        this.stageDesc = "Null";
        this.length = 0;
        this.stageID = 0;
    }
    
    /**
     * Creates object 'Stage' with initialized values.
     * @param stageName the name of the stage.
     * @param stageDesc the description of a given stage.
     * @param length length of the stage in km.
     * @param startTime start time of races in the stage.
     * @param type type of stage.
     */
    public Stage(String stageName, String stageDesc, double length,LocalDateTime startTime, StageType type) {
        this.stageName = stageName;
        this.stageDesc = stageDesc;
        this.length = length;
        this.startTime = startTime;
        this.type = type;
        this.stageID = ++numberOfStages;
    }
    

    //-------------------------------Remover & Adder methods--------------------------------//
    /**
     * Creates method for removing a segment from a given stage.
     * @param segment object 'segement' that will be removed.
     * 
     * Creates method for adding a segment to a given stage.
     * @param segment object 'segment' that will be added.
     * 
     * Creates method for adding results to a stage.
     * @param result object 'result' that will be added.
     * 
     * Creates method for removing results from a stage.
     * @param result object 'result' that will be removed.
     */
    public void removeStageSegment(Segment segment) {
        segmentsArray.remove(segment);
        --numberOfSegments;
    }
    public void addStageSegment(Segment segment) {
        segmentsArray.add(segment);
        ++numberOfSegments;
    }
    public void addStageResults(Results result) {
        resultsArray.add(result);
    }
    public void removeResults(Results result) throws IDNotRecognisedException {
        resultsArray.remove(result);
    }
}
