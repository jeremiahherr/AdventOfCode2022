package adventOfCode.day2;

import java.io.FileNotFoundException;

import org.junit.*;

import adventOfCode.utils.Settings;
import adventOfCode.utils.TextReader;

public class RockPaperScissorsPlayerTests 
{
    @Test
    public void playTournamentTest()
    {
        try 
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day2/Strategy_Test.txt");
            var output = RockPaperScissorsPlayer.playTournament(input);
            Assert.assertEquals(15, output);
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
