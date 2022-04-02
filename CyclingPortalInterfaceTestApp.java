import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import cycling.MiniCyclingPortal;
import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.IllegalNameException;
import cycling.InvalidNameException;
import cycling.MiniCyclingPortalInterface;
import cycling.SegmentType;
import cycling.StageType;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the CyclingPortalInterface interface -- note you
 * will want to increase these checks, and run it on your CyclingPortal class
 * (not the BadCyclingPortal class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class CyclingPortalInterfaceTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		CyclingPortalInterface portal = new CyclingPortal();
        //CyclingPortalInterface portal = new BadCyclingPortal();

		assert (portal.getRaceIds().length == 0)
			: "Innitial SocialMediaPlatform not empty as required or not returning an empty array.";

		try {
			portal.createRace("Firstrace", "A description");
			portal.createRace("Secondrace", "Another description");
			portal.createRace("Thirdrace", "No description");
		} catch (IllegalNameException e) {
			System.out.println(e);
		} catch (InvalidNameException e) {
			System.out.println(e);
		} finally {
			System.out.println("Number of races : "+portal.getRaceIds().length);
			System.out.println("IDs of races : " + Arrays.toString(portal.getRaceIds()));
		}

		try {
			//portal.removeRaceByName("Secondrace");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(Arrays.toString(portal.getRaceIds()));
		}
		try {
			portal.addStageToRace(1, "First stage", "The first stage", 20, LocalDateTime.now(), StageType.HIGH_MOUNTAIN);
			portal.addStageToRace(1, "First stage different race", "The first stage", 10, LocalDateTime.now(), StageType.MEDIUM_MOUNTAIN);
			portal.addStageToRace(1, "Second stage", "The second stage", 10, LocalDateTime.now(), StageType.FLAT);
			System.out.println("Race 1 Details : " + portal.viewRaceDetails(1));
			System.out.println("Race 1 Stages" + Arrays.toString(portal.getRaceStages(1)));
			System.out.println("Stage 1 length : " + portal.getStageLength(1));
			System.out.println("Race 1 NoOfStages: " + portal.getNumberOfStages(1));
			portal.addStageToRace(3, "Tirst stage", "The first stage", 10, LocalDateTime.now(), StageType.FLAT);
			portal.addStageToRace(3, "Tirst stage different race", "The first stage", 10, LocalDateTime.now(), StageType.MEDIUM_MOUNTAIN);
			portal.addStageToRace(3, "Tecond stage", "The second stage", 10, LocalDateTime.now(), StageType.FLAT);
			System.out.println("Race 3 Details : " + portal.viewRaceDetails(3));
			System.out.println("Race 3 Stages" + Arrays.toString(portal.getRaceStages(3)));
			System.out.println("Race 3 NoOfStages: " + portal.getNumberOfStages(3));
			portal.removeRaceById(3);
			// System.out.println("Race 3 Details : " + portal.viewRaceDetails(3));
			// System.out.println("Race 3 Stages" + Arrays.toString(portal.getRaceStages(3)));
			// System.out.println("Race 3 NoOfStages: " + portal.getNumberOfStages(3));
			// System.out.println("Race 1 Stages : " + Arrays.toString(portal.getRaceStages(1)));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Stop " +Arrays.toString(portal.getRaceIds()));
		}
		try {
			portal.addStageToRace(2, "First 2 stage", "The Second stage", 20, LocalDateTime.now(), StageType.FLAT);
			portal.addStageToRace(2, "Second stage different race", "The Second stage", 10, LocalDateTime.now(), StageType.MEDIUM_MOUNTAIN);
			portal.addStageToRace(2, "Second stage 2", "The second stage", 30, LocalDateTime.now(), StageType.FLAT);
			portal.addStageToRace(2, "Third Stage", "The third stage", 6, LocalDateTime.of(2021, 3, 13, 19, 1, 10) , StageType.HIGH_MOUNTAIN);
			System.out.println("Race 2 details : " + portal.viewRaceDetails(2));
			System.out.println("Race 2 stages : " + Arrays.toString(portal.getRaceStages(2)));
			System.out.println("Race 2 NoOfStages: " + portal.getNumberOfStages(2));
			System.out.println("Race 1 NoOfStages: " + portal.getNumberOfStages(1));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Race ID : " + Arrays.toString(portal.getRaceIds()));
		}
		try {
			//portal.removeStageById(1);
			System.out.println("Race Details : " + portal.viewRaceDetails(1));
			System.out.println("Stage Length : " + portal.getStageLength(1));
			System.out.println("Number of stages : " + portal.getNumberOfStages(1));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Race IDs : " + Arrays.toString(portal.getRaceIds()));
		}
		try {
			portal.addCategorizedClimbToStage(2, 2.0, SegmentType.C4, 5.0, 3.3);
			System.out.println("Race Details: " + portal.viewRaceDetails(2));
			System.out.println("Stage Length : " + portal.getStageLength(2));
			System.out.println("Number of stages : " + portal.getNumberOfStages(2));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Race ID" + Arrays.toString(portal.getRaceIds()));
		}
		try {
			portal.addIntermediateSprintToStage(2, 2.0);
			portal.addCategorizedClimbToStage(2, 2.0, SegmentType.C4, 5.0, 3.3);
			portal.addIntermediateSprintToStage(2, 2.0);
			portal.addCategorizedClimbToStage(2, 2.0, SegmentType.HC, 5.0, 3.3);
			portal.concludeStagePreparation(2);
			portal.removeSegment(3);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Race ID " + Arrays.toString(portal.getRaceIds()));
		}
		try {
			System.out.println("Stage segments " + Arrays.toString(portal.getStageSegments(2)));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(Arrays.toString(portal.getRaceIds()));
		}
		try{
			portal.createTeam("FirstTeam", "A description");
			portal.createTeam("SecondTeam", "Another description");
			portal.createTeam("THIRD	Team", "A description");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally { 
			System.out.println("Teams ID : " + Arrays.toString(portal.getTeams()));

		}
		
		try{
			portal.createRider(1, "john", 2001);
			portal.createRider(1, "sam", 1984);
			portal.createRider(1, "jon", 2001);
			portal.createRider(2, "johns", 2001);
			portal.createRider(2, "same", 1984);
			portal.createRider(3, "jonny", 2001);
			portal.createRider(3, "be", 2001);
			portal.createRider(3, "de", 2001);
			System.out.println("Team 1 Riders: " + Arrays.toString(portal.getTeamRiders(1)));
			System.out.println("Team 2 Riders: " +Arrays.toString(portal.getTeamRiders(2)));
			System.out.println("Team 3 Riders: " +Arrays.toString(portal.getTeamRiders(3)));
			// portal.registerRiderResultsInStage(1, 2, LocalTime.of(1, 3, 15), LocalTime.of(1, 57, 01));
			// System.out.println("Rider results : " + (portal.getRiderResultsInStage(1, 2)));
			// portal.removeRider(2);
			//portal.removeRider(3);
			System.out.println("Team 1 Riders: " +Arrays.toString(portal.getTeamRiders(1)));
			System.out.println("Team 2 Riders: " +Arrays.toString(portal.getTeamRiders(2)));
			System.out.println("Team 3 Riders: " +Arrays.toString(portal.getTeamRiders(3)));
			// System.out.println("Rider results : " + (portal.getRiderResultsInStage(1, 2)));
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
		}
		try{
			portal.registerRiderResultsInStage(1, 1, LocalTime.of(1, 2, 15), LocalTime.of(1, 54, 01));
			portal.registerRiderResultsInStage(1, 2, LocalTime.of(1, 3, 15), LocalTime.of(1, 57, 01));
			portal.registerRiderResultsInStage(1, 3, LocalTime.of(1, 2, 15), LocalTime.of(1, 29, 01));
			portal.registerRiderResultsInStage(1, 4, LocalTime.of(1, 12, 15), LocalTime.of(1, 39, 11));
			portal.registerRiderResultsInStage(1, 5, LocalTime.of(1, 4, 15), LocalTime.of(1, 30, 01));
			portal.registerRiderResultsInStage(1, 6, LocalTime.of(1, 18, 15), LocalTime.of(1, 32, 01));
			portal.registerRiderResultsInStage(2, 1, LocalTime.of(0, 2, 10), LocalTime.of(0, 18, 13), LocalTime.of(0, 23, 43), LocalTime.of(0, 52, 24), LocalTime.of(3, 55, 28),LocalTime.of(4, 35, 28));
			portal.registerRiderResultsInStage(2, 2, LocalTime.of(0, 2, 10), LocalTime.of(0, 21, 13), LocalTime.of(0, 25, 43), LocalTime.of(0, 56, 24), LocalTime.of(3, 10, 28),LocalTime.of(4, 25, 28));
			portal.registerRiderResultsInStage(2, 3, LocalTime.of(0, 1, 10), LocalTime.of(0, 22, 13), LocalTime.of(0, 26, 43), LocalTime.of(0, 58, 24), LocalTime.of(3, 59, 28),LocalTime.of(4, 56, 28));
			portal.registerRiderResultsInStage(2, 4, LocalTime.of(0, 5, 10), LocalTime.of(0, 14, 13), LocalTime.of(0, 34, 43), LocalTime.of(0, 52, 24), LocalTime.of(3, 55, 28),LocalTime.of(4, 59, 28));
			portal.registerRiderResultsInStage(2, 5, LocalTime.of(0, 3, 10), LocalTime.of(0, 18, 13), LocalTime.of(0, 23, 43), LocalTime.of(0, 52, 24), LocalTime.of(3, 53, 28),LocalTime.of(4, 5, 54));
			portal.registerRiderResultsInStage(2, 6, LocalTime.of(0, 1, 10), LocalTime.of(0, 19, 13), LocalTime.of(0, 23, 43), LocalTime.of(0, 53, 24), LocalTime.of(3, 55, 28),LocalTime.of(14, 5, 28));
			portal.registerRiderResultsInStage(3, 1, LocalTime.of(1, 2, 15), LocalTime.of(1, 54, 01));
			portal.registerRiderResultsInStage(3, 2, LocalTime.of(1, 3, 15), LocalTime.of(1, 57, 01));
			portal.registerRiderResultsInStage(3, 3, LocalTime.of(1, 2, 15), LocalTime.of(1, 29, 01));
			portal.registerRiderResultsInStage(3, 4, LocalTime.of(1, 12, 15), LocalTime.of(1, 39, 11));
			portal.registerRiderResultsInStage(3, 5, LocalTime.of(1, 4, 15), LocalTime.of(1, 30, 01));
			portal.registerRiderResultsInStage(3, 6, LocalTime.of(1, 18, 15), LocalTime.of(1, 32, 01));
			System.out.println("Result for each segment stage 1: " + Arrays.toString(portal.getRiderResultsInStage(1, 1)));
			System.out.println("Elapsed Result Time stage 1: " + portal.getRiderAdjustedElapsedTimeInStage(1, 1));
			System.out.println("Result for each segment stage 2: " + Arrays.toString(portal.getRiderResultsInStage(2, 1)));
			System.out.println("Elapsed Result Time stage 2 : " + portal.getRiderAdjustedElapsedTimeInStage(2, 1));
			//portal.deleteRiderResultsInStage(2,1);  
			System.out.println("Result for each segment: " + Arrays.toString(portal.getRiderResultsInStage(1, 1)));
			System.out.println("Result for each segment: " + Arrays.toString(portal.getRiderResultsInStage(2, 1)));
			System.out.println("Rank of stage by ID: " + Arrays.toString(portal.getRidersRankInStage(1)));
			System.out.println("Rank of stage by time: " + Arrays.toString(portal.getRankedAdjustedElapsedTimesInStage(1)));
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
		}
		try{
			System.out.println("Points in stage: " + Arrays.toString(portal.getRidersPointsInStage(1)));
			System.out.println("Points in stage: " + Arrays.toString(portal.getRidersPointsInStage(2)));
			//System.out.println("Points in mountain segment: " + Arrays.toString(portal.getRidersMountainPointsInStage(1)));
			System.out.println("Points in mountain segment: " + Arrays.toString(portal.getRidersMountainPointsInStage(2)));
			System.out.println("Sorted race times : " + Arrays.toString(portal.getGeneralClassificationTimesInRace(1)));
			System.out.println("Sorted race ID : " + Arrays.toString(portal.getRidersGeneralClassificationRank(1)));
			System.out.println("Sorted race points by time : " + Arrays.toString(portal.getRidersPointsInRace(1)));
			System.out.println("Sorted race IDs by  points  : " + Arrays.toString(portal.getRidersPointClassificationRank(1)));
			System.out.println("Sorted mountain points by time: " + Arrays.toString(portal.getRidersMountainPointsInRace(1)));
			System.out.println("Sorted race IDs by mountain points : " + Arrays.toString(portal.getRidersMountainPointClassificationRank(1)));
			System.out.println("Saving...");
			portal.saveCyclingPortal("savefile.txt");
			System.out.println("Saved!");
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
			System.out.println("Race ID " + Arrays.toString(portal.getRaceIds()));
			System.out.println("Erasing...");
			portal.eraseCyclingPortal();
			System.out.println("Eraced!");
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
			System.out.println("Race ID " + Arrays.toString(portal.getRaceIds()));
			System.out.println("Loading...");
			portal.loadCyclingPortal("savefile.txt");
			System.out.println("Loaded!");
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
			System.out.println("Race ID " + Arrays.toString(portal.getRaceIds()));
			System.out.println("Erasing...");
			portal.eraseCyclingPortal();
			System.out.println("Eraced!");
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
			System.out.println("Race ID " + Arrays.toString(portal.getRaceIds()));
		}catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Teams ID " + Arrays.toString(portal.getTeams()));
		}
	}
}

