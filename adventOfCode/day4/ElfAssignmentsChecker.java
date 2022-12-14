
package adventOfCode.day4;

import java.util.ArrayList;
import adventOfCode.utils.*;

public class ElfAssignmentsChecker 
{
    public enum LevelOfOverLap
    {
        FULLY_CONTAINS_THE_OTHER,
        PARTIALLY_CONTAINS_THE_OTHER
    }

    public static int getNumberOfAssignmentPairsContainingTheOther(String elfAssignments, LevelOfOverLap overlap)
    {
        var assignmentPairsFullyContainingTheOther = 0;
        var assignmentPairsPartiallyContainingTheOther = 0;
        for (var assignmentPair : getAssignmentPairs(elfAssignments))
        {
            if (anAssignemntFullyContainsTheOther(getAssignments(assignmentPair)))
                assignmentPairsFullyContainingTheOther++;

            if (anAssignmentPartiallyContainsTheOther(getAssignments(assignmentPair))) 
                assignmentPairsPartiallyContainingTheOther++;
        }
        if (overlap == LevelOfOverLap.FULLY_CONTAINS_THE_OTHER) return assignmentPairsFullyContainingTheOther;
        else return assignmentPairsPartiallyContainingTheOther;
    }

    private static String[] getAssignmentPairs(String elfAssignmentsList)
    {
        return elfAssignmentsList.split(Settings.NEW_LINE);
    }

    private static String[] getAssignments(String assignmentPair)
    {
        return assignmentPair.split(",");
    }

    private static ArrayList<Integer> getSections(String assignment)
    {
        var sections = new ArrayList<Integer>();
        var sectionRange = assignment.split("-");
        var lowerBound = Integer.parseInt(sectionRange[0]);
        var upperBound = Integer.parseInt(sectionRange[1]);
        for (int section = lowerBound; section <= upperBound; section++)
        {
            sections.add(section);
        }
        return sections;
    }

    private static boolean anAssignemntFullyContainsTheOther(String[] assignments)
    {
        var assignement1Sections = getSections(assignments[0]);
        var assignement2Sections = getSections(assignments[1]);
        return assignement1Sections.containsAll(assignement2Sections) || assignement2Sections.containsAll(assignement1Sections);
    }

    private static boolean anAssignmentPartiallyContainsTheOther(String[] assignments)
    {
        var assignement1Sections = getSections(assignments[0]);
        var assignement2Sections = getSections(assignments[1]);
        for (var section : assignement1Sections)
        {
            if (assignement2Sections.contains(section))
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day4/ElfCleaningAssignments_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getNumberOfAssignmentPairsContainingTheOther(input, LevelOfOverLap.FULLY_CONTAINS_THE_OTHER));
            System.out.println("Part 2 Answer: " + getNumberOfAssignmentPairsContainingTheOther(input, LevelOfOverLap.PARTIALLY_CONTAINS_THE_OTHER));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
