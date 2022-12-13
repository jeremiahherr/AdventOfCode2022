
package adventOfCode.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import adventOfCode.utils.*;

public class CargoCraneSimulator 
{
    public enum CrateMovementType
    {
        SINGLE_CRATE,
        MULTIPLE_CRATES
    }

    public static String getFinalCrateArrangement(String crateRearrangementInstructions, CrateMovementType crateMovementType)
    {
        var initialArrangementAndInstructions = separateInitialArrangementAndMoveInstructions(crateRearrangementInstructions);
        var crateStacks = getInitialCrateArrangement(initialArrangementAndInstructions[0]);
        var moveInstructions = initialArrangementAndInstructions[1];
        for (var instructionLine : moveInstructions.split(Settings.NEW_LINE))
        {
            crateStacks = carryOutInstructionLine(instructionLine, crateStacks, crateMovementType);
        }
        return getCrateAtTopOfEachStack(crateStacks);
    }

    private static String[] separateInitialArrangementAndMoveInstructions(String crateRearrangementInstructions)
    {
        var initialArrangementAndInstructions = new String[2];
        var dividingIndex = crateRearrangementInstructions.indexOf("move");
        initialArrangementAndInstructions[0] = crateRearrangementInstructions.substring(0, dividingIndex); // Initial arrangement of crate stacks
        initialArrangementAndInstructions[1] = crateRearrangementInstructions.substring(dividingIndex); // Crate move instructions
        return initialArrangementAndInstructions;
    }

    private static ArrayList<Stack<String>> getInitialCrateArrangement(String initialCrateArrangement)
    {
        var crateArrangementLines = initialCrateArrangement.split(Settings.NEW_LINE);
        var numberOfCrateStacks = crateArrangementLines[crateArrangementLines.length - 1].split("   ").length;
        var crateStacks = new ArrayList<Stack<String>>(numberOfCrateStacks);
        for (int stack = 0; stack < numberOfCrateStacks; stack++)
        {
            crateStacks.add(new Stack<String>());
        }
        var cratePositionMap = mapCratePositionInLineToStackIndex(numberOfCrateStacks);

        for (int lineIndex = crateArrangementLines.length - 2; lineIndex >= 0; lineIndex--)
        {
            var line = crateArrangementLines[lineIndex];
            for (int characterIndex = 1; characterIndex <= line.length(); characterIndex += 4)
            {
                var character = String.valueOf(line.charAt(characterIndex));
                var characterIsNotWhitespace = !character.isEmpty() && !character.trim().isEmpty();
                if (characterIsNotWhitespace)
                {
                    var stackIndex = cratePositionMap.get(characterIndex);
                    crateStacks.get(stackIndex).push(character);
                }
            }
        }
        return crateStacks;
    }

    private static HashMap<Integer, Integer> mapCratePositionInLineToStackIndex(int numberOfCrateStacks)
    {
        var cratePositionInLineToStackIndexMap = new HashMap<Integer, Integer>();
        var cratePositionInLine = 1;
        for (int stackIndex = 0; stackIndex < numberOfCrateStacks; stackIndex++)
        {
            cratePositionInLineToStackIndexMap.put(cratePositionInLine, stackIndex);
            cratePositionInLine += 4;
        }
        return cratePositionInLineToStackIndexMap;
    }

    private static ArrayList<Stack<String>> carryOutInstructionLine(String instructionLine, ArrayList<Stack<String>> crateStacks, CrateMovementType crateMovementType)
    {
        String[] instruction = instructionLine.split(Settings.EMPTY_SPACE);
        int cratesToMove = Integer.parseInt(instruction[1]);
        int fromStack = Integer.parseInt(instruction[3])-1;
        int toStack = Integer.parseInt(instruction[5])-1;

        for (int crate = 0; crate < cratesToMove; crate++)
        {
            // TODO: simulate moving multiple crates at once by putting the crates in a temporary stack before putting them in the destination stack
            crateStacks.get(toStack).push(crateStacks.get(fromStack).pop());
        }
        return crateStacks;
    }

    private static String getCrateAtTopOfEachStack(ArrayList<Stack<String>> crateStacks)
    {
        var crateMessage = Settings.EMPTY_STRING;
        for (var stack : crateStacks)
        {
            crateMessage += stack.peek();
        }
        return crateMessage;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day5/CrateRearrangementInstructions_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + getFinalCrateArrangement(input, CrateMovementType.SINGLE_CRATE));
            System.out.println("Part 2 Answer: " + getFinalCrateArrangement(input, CrateMovementType.MULTIPLE_CRATES));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
