
package adventOfCode.day2;

import java.io.FileNotFoundException;
import org.junit.*;
import adventOfCode.day2.RockPaperScissorsPlayer.StrategyDecryption;
import adventOfCode.utils.*;

public class RockPaperScissorsPlayerTests 
{
    @Test
    public void playTournamentWithMyStrategyDecryption()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day2/Strategy_Test.txt");
            var output = RockPaperScissorsPlayer.playTournament(input, StrategyDecryption.Mine);
            Assert.assertEquals(15, output);
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }

    @Test
    public void playTournamentWithElfsStrategyDecryption()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day2/Strategy_Test.txt");
            var output = RockPaperScissorsPlayer.playTournament(input, StrategyDecryption.Elfs);
            Assert.assertEquals(12, output);
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
