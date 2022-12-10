
package adventOfCode.day1;

import org.junit.*;

import adventOfCode.utils.Settings;
import adventOfCode.utils.TextReader;

public class ElfCalorieCountingTests 
{
    @Test
    public void findElfCarryingMostCalories()
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day1/ElfCalories_Test.txt");
            var output = ElfCalorieCounting.getSumOfTopNHighestElfCaloriesTotals(input, 1);
            Assert.assertEquals(24000, output);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }

    @Test
    public void findTop3ElvesCarryingMostCalories()
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day1/ElfCalories_Test.txt");
            var output = ElfCalorieCounting.getSumOfTopNHighestElfCaloriesTotals(input, 3);
            Assert.assertEquals(45000, output);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
