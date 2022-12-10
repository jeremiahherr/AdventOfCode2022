
package adventOfCode.day3;

import adventOfCode.utils.*;

public class ElfRucksackReorganizer 
{
    public static int getRucksackPrioritySum(String ruckSacks)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day3/ElfRucksacks_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getRucksackPrioritySum(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
