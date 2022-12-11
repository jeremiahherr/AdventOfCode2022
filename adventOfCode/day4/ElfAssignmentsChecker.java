
package adventOfCode.day4;

import adventOfCode.utils.*;

public class ElfAssignmentsChecker 
{
    public static int getNumberOfAssignmentPairsContainingTheOther(String elfAssignments)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day4/ElfCleaningAssignments_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getNumberOfAssignmentPairsContainingTheOther(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
