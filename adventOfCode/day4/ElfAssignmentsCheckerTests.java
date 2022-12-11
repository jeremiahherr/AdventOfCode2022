
package adventOfCode.day4;

import org.junit.*;
import adventOfCode.utils.*;

public class ElfAssignmentsCheckerTests 
{
    @Test
    public void findNumberOfElfAssignmentPairsFullyContainingTheOther()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day4/ElfCleaningAssignments_Test.txt");
            var output = ElfAssignmentsChecker.getNumberOfAssignmentPairsContainingTheOther(input);
            Assert.assertEquals(2, output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }   
}
