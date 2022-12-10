
package adventOfCode.day3;

import org.junit.*;
import adventOfCode.utils.*;

public class ElfRucksackReorganizerTests 
{
    @Test
    public void getRucksackPrioritySumTest()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day3/ElfRucksacks_Test.txt");
            var output = ElfRucksackReorganizer.getRucksackPrioritySum(input);
            Assert.assertEquals(157, output);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
