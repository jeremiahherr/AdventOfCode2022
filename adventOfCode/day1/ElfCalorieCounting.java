
package adventOfCode.day1;

import java.util.ArrayList;
import java.util.Collections;
import adventOfCode.utils.*;

public class ElfCalorieCounting
{
    public static int getSumOfTopNHighestElfCaloriesTotals(String caloriesList, int n)
    {
        var totalCaloriesByElf = getTotalCaloriesByElf(caloriesList);
        Collections.sort(totalCaloriesByElf, Collections.reverseOrder()); // Sort in descending order
        int sumOfTopNHighestCalorieTotals = 0;

        if (n > totalCaloriesByElf.size()) n = totalCaloriesByElf.size();
        for (int elf = 0; elf < n; elf++)
        {
           sumOfTopNHighestCalorieTotals += totalCaloriesByElf.get(elf);
        }
        return sumOfTopNHighestCalorieTotals;
    }

    private static ArrayList<Integer> getTotalCaloriesByElf(String caloriesList)
    {
        var totalCaloriesByElf = new ArrayList<Integer>();
        var caloriesByItem = caloriesList.split(Settings.NEW_LINE);
        var currentElfCaloriesTotal = 0;

        for (int item = 0; item < caloriesByItem.length; item++)
        {
            var atNextElf = caloriesByItem[item].equals(Settings.EMPTY_STRING);
            if (!atNextElf)
            {
                currentElfCaloriesTotal += Integer.parseInt(caloriesByItem[item]);
            }
            else
            {
                totalCaloriesByElf.add(currentElfCaloriesTotal);
                currentElfCaloriesTotal = 0;
            }
        }
        totalCaloriesByElf.add(currentElfCaloriesTotal); // Add the last elf's calories
        return totalCaloriesByElf;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day1/ElfCalories_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + ElfCalorieCounting.getSumOfTopNHighestElfCaloriesTotals(input, 1));
            System.out.println("Part 2 Answer: " + ElfCalorieCounting.getSumOfTopNHighestElfCaloriesTotals(input, 3));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
