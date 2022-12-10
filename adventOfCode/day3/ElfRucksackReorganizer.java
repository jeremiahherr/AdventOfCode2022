
package adventOfCode.day3;

import java.util.ArrayList;
import java.util.HashMap;
import adventOfCode.utils.*;

public class ElfRucksackReorganizer 
{
    public static int getSharedCompartmentItemPrioritySum(String rucksacks)
    {
        var rucksackPrioritySum = 0;
        for (var rucksack : getRucksacks(rucksacks))
        {
            rucksackPrioritySum += getItemPriority(getItemSharedByBothRucksackCompartments(getRucksackCompartments(rucksack)));
        }
        return rucksackPrioritySum;
    }
    
    public static int getGroupBadgePrioritySum(String rucksacks)
    {
        var groupBadgePrioritySum = 0;
        for (var elfGroup : getElfGroups(rucksacks))
        {
            groupBadgePrioritySum += getItemPriority(getGroupBadge(elfGroup));
        }
        return groupBadgePrioritySum;
    }

    private static String[] getRucksacks(String rucksacksList)
    {
        var rucksacks = rucksacksList.split(Settings.NEW_LINE);
        return rucksacks;
    }

    private static ArrayList<String[]> getElfGroups(String rucksackList)
    {
        var elfGroups = new ArrayList<String[]>();
        var rucksacks = getRucksacks(rucksackList);
        var elfGroup = new String[3];
        for (int rucksack = 0; rucksack < rucksacks.length; rucksack++)
        {
            elfGroup[rucksack % 3] = rucksacks[rucksack];
            if (rucksack % 3 == 2) 
            {
                elfGroups.add(elfGroup);
                elfGroup = new String[3];
            }
        }
        return elfGroups;
    }

    private static String[] getRucksackCompartments(String rucksack)
    {
        var rucksackCompartments = new String[2];
        int middleItemIndex = rucksack.length() / 2;
        rucksackCompartments[0] = rucksack.substring(0, middleItemIndex);
        rucksackCompartments[1] = rucksack.substring(middleItemIndex);
        return rucksackCompartments;
    }

    private static char getItemSharedByBothRucksackCompartments(String[] rucksackCompartments)
    {
        var compartment1 = rucksackCompartments[0];
        var compartment2 = rucksackCompartments[1];
        for (int item = 0; item < compartment1.length(); item++)
        {
            var currentItem = compartment1.charAt(item);
            if (compartment2.contains(String.valueOf(currentItem))) return currentItem;
        }
        return Character.MIN_VALUE;
    }

    private static char getGroupBadge(String[] elfGroup)
    {
        var elf1 = elfGroup[0];
        var elf2 = elfGroup[1];
        var elf3 = elfGroup[2];
        for (int item = 0; item < elf1.length(); item++)
        {
            var currentItem = elf1.charAt(item);
            if (elf2.contains(String.valueOf(currentItem)) && elf3.contains(String.valueOf(currentItem))) return currentItem;
        }
        return Character.MIN_VALUE;
    }

    private static HashMap<String, Integer> getItemPriorityDictionary()
    {
        var itemPriorityDictionary = new HashMap<String, Integer>();
        itemPriorityDictionary.put("a", 1);
        itemPriorityDictionary.put("b", 2);
        itemPriorityDictionary.put("c", 3);
        itemPriorityDictionary.put("d", 4);
        itemPriorityDictionary.put("e", 5);
        itemPriorityDictionary.put("f", 6);
        itemPriorityDictionary.put("g", 7);
        itemPriorityDictionary.put("h", 8);
        itemPriorityDictionary.put("i", 9);
        itemPriorityDictionary.put("j", 10);
        itemPriorityDictionary.put("k", 11);
        itemPriorityDictionary.put("l", 12);
        itemPriorityDictionary.put("m", 13);
        itemPriorityDictionary.put("n", 14);
        itemPriorityDictionary.put("o", 15);
        itemPriorityDictionary.put("p", 16);
        itemPriorityDictionary.put("q", 17);
        itemPriorityDictionary.put("r", 18);
        itemPriorityDictionary.put("s", 19);
        itemPriorityDictionary.put("t", 20);
        itemPriorityDictionary.put("u", 21);
        itemPriorityDictionary.put("v", 22);
        itemPriorityDictionary.put("w", 23);
        itemPriorityDictionary.put("x", 24);
        itemPriorityDictionary.put("y", 25);
        itemPriorityDictionary.put("z", 26);
        itemPriorityDictionary.put("A", 27);
        itemPriorityDictionary.put("B", 28);
        itemPriorityDictionary.put("C", 29);
        itemPriorityDictionary.put("D", 30);
        itemPriorityDictionary.put("E", 31);
        itemPriorityDictionary.put("F", 32);
        itemPriorityDictionary.put("G", 33);
        itemPriorityDictionary.put("H", 34);
        itemPriorityDictionary.put("I", 35);
        itemPriorityDictionary.put("J", 36);
        itemPriorityDictionary.put("K", 37);
        itemPriorityDictionary.put("L", 38);
        itemPriorityDictionary.put("M", 39);
        itemPriorityDictionary.put("N", 40);
        itemPriorityDictionary.put("O", 41);
        itemPriorityDictionary.put("P", 42);
        itemPriorityDictionary.put("Q", 43);
        itemPriorityDictionary.put("R", 44);
        itemPriorityDictionary.put("S", 45);
        itemPriorityDictionary.put("T", 46);
        itemPriorityDictionary.put("U", 47);
        itemPriorityDictionary.put("V", 48);
        itemPriorityDictionary.put("W", 49);
        itemPriorityDictionary.put("X", 50);
        itemPriorityDictionary.put("Y", 51);
        itemPriorityDictionary.put("Z", 52);
        return itemPriorityDictionary;
    }

    private static int getItemPriority(char item)
    {
        return getItemPriorityDictionary().get(String.valueOf(item));
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day3/ElfRucksacks_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getSharedCompartmentItemPrioritySum(input));
            System.out.println("Part 2 Answer: " + getGroupBadgePrioritySum(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
