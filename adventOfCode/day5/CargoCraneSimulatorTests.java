
package adventOfCode.day5;

import org.junit.*;
import adventOfCode.day5.CargoCraneSimulator.CrateMovementType;
import adventOfCode.utils.*;

public class CargoCraneSimulatorTests 
{
    @Test
    public void getFinalCrateArrangementMovingOneCrateAtATime()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day5/CrateRearrangementInstructions_Test.txt");
            var output = CargoCraneSimulator.getFinalCrateArrangement(input, CrateMovementType.SINGLE_CRATE);
            Assert.assertEquals("CMZ", output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }

    @Test
    public void getFinalCrateArrangementMovingMultipleCratesAtOnce()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day5/CrateRearrangementInstructions_Test.txt");
            var output = CargoCraneSimulator.getFinalCrateArrangement(input, CrateMovementType.MULTIPLE_CRATES);
            Assert.assertEquals("MCD", output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
