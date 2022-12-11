
package adventOfCode.day5;

import org.junit.*;
import adventOfCode.utils.*;

public class CargoCraneSimulatorTests 
{
    @Test
    public void getFinalCrateArrangementTest()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day5/CrateRearrangementInstructions_Test.txt");
            var output = CargoCraneSimulator.getFinalCrateArrangement(input);
            Assert.assertEquals("CMZ", output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
