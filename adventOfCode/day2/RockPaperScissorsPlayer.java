package adventOfCode.day2;

import adventOfCode.utils.*;

public class RockPaperScissorsPlayer 
{
    public static int playTournament(String strategy)
    {
        var totalScore = 0;
        return totalScore;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day2/Strategy_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + playTournament(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
