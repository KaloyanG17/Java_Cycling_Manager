package cycling;

import java.io.Serializable;
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

public class Segment implements Serializable{
    //-------------------------------Private Initial Varriables---------------------------//
    // Initializes the number of segments to 0.
    private static int numberOfSegments = 0;
    // Initializes segmentID.
    private int segmentID;
    // Initializes location.
    private double location;
    // Initializes segment types.
    private SegmentType type;
    // Initializes average gradient.
    private double averageGradient;
    // Initializes length.
    private double length;
    // Initializes stage.
    private Stage stage;

    //-----------------------------------Setter methods-----------------------------------//
    /**
     * Sets the segment location.
     * @param location where the segments will be.
     * 
     * Sets the average gradient of a given segment.
     * @param averageGradient the average gradient of the segment as a percentage.
     * 
     * Sets the length of the segment.
     * @param length length of the segment in km.
     * 
     * Sets the stage the segment will be held.
     * @param stage the type of stage.
     * 
     * Resets the number of segments to 0.
     * @param numberOfSegments the number of segments in a given stage.
     */
    public void setSegementLocation(double location) {this.location = location;}
    public void setSegmentAverageGradient(double averageGradient) {this.averageGradient = averageGradient;}
    public void setSegmentLength(double length) {this.length = length;}
    public void setSegmentStage(Stage stage) {this.stage = stage;}
    public static void resetNumberOfSegments() {numberOfSegments = 0;}


     //-----------------------------------Getter methods-----------------------------------//
    /**
     * Gets the segment ID of the object.
     * @return the segment ID.
     * Gets the location of the Segment.
     * @return location of the segment.
     * Gets the type of segment.
     * @return type of segment in a given stage.
     * Gets the average gradient of a given segment.
     * @return the average gradient as a percentage.
     * Gets the length of a given segment.
     * @return length of the segment in km.
     * Gets the stage a given segment is in.
     * @return stage of a given segment.
     * 
     * 
     * Gets the details of the segment.
     * @param segmentID the ID of the segment.
     * @param location location of the segment.
     * @param type type of segment.
     * @param averageGradient the average gradient of the segment as a percentage.
     * @param length length of the segment in km.
     * @param stage stage that the segment is in.
     */
     public int getSegmentID() {return segmentID;}
    public double getSegmentLocation() {return location;}
    public SegmentType getSegmentType() {return type;}
    public double getSegmentAverageGradient() {return averageGradient;}
    public double getSegmentLength() {return length;}
    public Stage getSegmentStage() {return stage;}
    public String getSegementDetails() {
        return "ID: "+segmentID+" | Location: "+location+" | Type:: "+type+" | Average Gradient: "+averageGradient+" | Length: "+length+" | Stage: "+stage;
    }



    //---------------------------------Constructer methods----------------------------------//
    /**
     * Creates object 'Segment' with initialized values of 0, 0 and 0 respectively.
     */
    public Segment() {
        this.location = 0;
        this.segmentID = 0;
        this.averageGradient = 0;
    }
    
    /**
     * Creates object 'Rider' with initialized values.
     * @param location location of the segment.
     * @param type type of segment.
     * @param averageGradient average gradient of the segment as a percentage.
     * @param length length of the segment in km.
     */ 
    public Segment(double location, SegmentType type, double averageGradient, double length) {
        this.location = location;
        this.type = type;
        this.averageGradient = averageGradient;
        this.length = length;
        this.segmentID = ++numberOfSegments;
    }

    Segment(double location, SegmentType type) {
        this.location = location;
        this.type = type;
        this.segmentID = ++numberOfSegments;
    }
    
}