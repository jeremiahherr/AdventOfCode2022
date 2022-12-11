
package adventOfCode.day4;

import org.junit.*;
import adventOfCode.day4.ElfAssignmentsChecker.LevelOfOverLap;
import adventOfCode.utils.*;

public class ElfAssignmentsCheckerTests 
{
    @Test
    public void findNumberOfElfAssignmentPairsFullyContainingTheOther()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day4/ElfCleaningAssignments_Test.txt");
            var output = ElfAssignmentsChecker.getNumberOfAssignmentPairsContainingTheOther(input, LevelOfOverLap.FULLY_CONTAINS_THE_OTHER);
            Assert.assertEquals(2, output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
    
    @Test
    public void findNumberOfElfAssignmentPairsPartiallyContainingTheOther()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day4/ElfCleaningAssignments_Test.txt");
            var output = ElfAssignmentsChecker.getNumberOfAssignmentPairsContainingTheOther(input, LevelOfOverLap.PARTIALLY_CONTAINS_THE_OTHER);
            Assert.assertEquals(4, output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
