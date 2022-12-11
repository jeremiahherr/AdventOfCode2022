package adventOfCode.day5;

import adventOfCode.utils.*;

public class CargoCraneSimulator 
{
    public static String getFinalCrateArrangement(String crateRearrangementInstructions)
    {
        return Settings.EMPTY_STRING;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day5/CrateRearrangementInstructions_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getFinalCrateArrangement(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
