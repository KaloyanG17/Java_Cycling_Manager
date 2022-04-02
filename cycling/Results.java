package cycling;
import java.io.Serializable;
import java.time.LocalTime;
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

public class Results implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    //Gets the number of results for the stage, initializing at 0.
    private static int numberOfResults = 0;
    //initializes resultID.
    private int resultID;
    //initializes stage.
    private Stage stage;
    //initializes rider.
    private Rider rider;
    //initializes array of local times.
    private LocalTime[] times;

    //-----------------------------------Setter methods-----------------------------------//
    /**
     * Sets the results in a stage.
     * @param stage object stage.
     * Sets the results to a rider.
     * @param rider object rider.
     * Sets the result time based on local time array.
     * @param times collected from local time array.
     * Resets number of results in a stage, setting to 0. 
    */
    
    
    public void setResultStage(Stage stage) {this.stage = stage;}
    public void setResultRider(Rider rider) {this.rider = rider;}
    public void setResultTime(LocalTime[] times) {this.times = times;}
    public static void resetNumberOfResults() {numberOfResults = 0;}


    //-----------------------------------Getter methods-----------------------------------//
    /**
     * Gets the results ID of the object.
     * @return the result ID.
     * Gets the stage object of where the given result is.
     * @return the stage object.
     * Gets the rider based on their result in the stage.
     * @return the rider object.
     * Gets the times of a given result.
     * @return the result times as an array.
     */
    
    
    public int getResultsId() {return resultID;}
    public Stage getResultStage() {return stage;}
    public Rider getResultRider() {return rider;}
    public LocalTime[] getResultTimes() {return times;}

    
    //---------------------------------Constructer methods----------------------------------//
    /**
     * Creates object 'Results' with initialized values.
     * @param stage the stage the results will be stored in.
     * @param rider the rider associated with the result.
     * @param times the time of the given result.
     */
    public Results(Stage stage, Rider rider , LocalTime... times) {
        this.stage = stage;
        this.rider = rider;
        this.times = times;
        this.resultID = ++numberOfResults;
    }
    /**
     * Creates empty object 'Results' and sets the result ID to 0.
     */
    public Results(){
        this.stage = new Stage();
        this.resultID = 0;
    }

}
