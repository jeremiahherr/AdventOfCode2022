package adventOfCode.day2;

import java.util.HashMap;
import adventOfCode.utils.*;

public class RockPaperScissorsPlayer 
{
    public static int playTournament(String strategy)
    {
        var totalScore = 0;
        var rounds = getStrategyRounds(strategy);
        for (int round = 0; round < rounds.length; round++)
        {
            var roundShapeCodes = getRoundShapeCodes(rounds[round]);
            var myShapeCode = roundShapeCodes[Players.Me.ordinal()];
            var opponentShapeCode = roundShapeCodes[Players.Opponent.ordinal()];
            totalScore += getScore(myShapeCode, opponentShapeCode);
        }
        return totalScore;
    }

    private static String[] getStrategyRounds(String strategy)
    {
        var strategyRounds = strategy.split(Settings.NEW_LINE);
        return strategyRounds;
    }

    private static String[] getRoundShapeCodes(String round)
    {
        var roundShapeCodes = round.split(Settings.EMPTY_SPACE);
        return roundShapeCodes;
    }

    private enum Players
    {
        Opponent,
        Me
    }

    private enum Shape
    {
        Rock,
        Paper,
        Scissors
    }

    private static HashMap<String, Shape> getOpponentShapeKey()
    {
        var opponentShapeKey = new HashMap<String, Shape>();
        opponentShapeKey.put("A", Shape.Rock);
        opponentShapeKey.put("B", Shape.Paper);
        opponentShapeKey.put("C", Shape.Scissors);
        return opponentShapeKey;
    }

    private static HashMap<String, Shape> getMyShapeKey()
    {
        var myShapeKey = new HashMap<String, Shape>();
        myShapeKey.put("X", Shape.Rock);
        myShapeKey.put("Y", Shape.Paper);
        myShapeKey.put("Z", Shape.Scissors);
        return myShapeKey;
    }

    private static HashMap<Shape, Integer> getShapeScoreKey()
    {
        var shapeScoreKey = new HashMap<Shape, Integer>();
        shapeScoreKey.put(Shape.Rock, 1);
        shapeScoreKey.put(Shape.Paper, 2);
        shapeScoreKey.put(Shape.Scissors, 3);
        return shapeScoreKey;
    }

    private enum Outcome
    {
        Win,
        Lose,
        Draw
    }

    private static HashMap<Outcome, Integer> getOutcomeScoreKey()
    {
        var outcomeScoreKey = new HashMap<Outcome, Integer>();
        outcomeScoreKey.put(Outcome.Win, 6);
        outcomeScoreKey.put(Outcome.Lose, 0);
        outcomeScoreKey.put(Outcome.Draw, 3);
        return outcomeScoreKey;
    }

    private static Outcome[][] getOutcomeMatrix()
    {
        var numberOfShapes = Shape.values().length;
        var outcomeMatrix = new Outcome[numberOfShapes][numberOfShapes];
        outcomeMatrix[Shape.Rock.ordinal()][Shape.Rock.ordinal()] = Outcome.Draw;
        outcomeMatrix[Shape.Rock.ordinal()][Shape.Paper.ordinal()] = Outcome.Win;
        outcomeMatrix[Shape.Rock.ordinal()][Shape.Scissors.ordinal()] = Outcome.Lose;
        outcomeMatrix[Shape.Paper.ordinal()][Shape.Rock.ordinal()] = Outcome.Lose;
        outcomeMatrix[Shape.Paper.ordinal()][Shape.Paper.ordinal()] = Outcome.Draw;
        outcomeMatrix[Shape.Paper.ordinal()][Shape.Scissors.ordinal()] = Outcome.Win;
        outcomeMatrix[Shape.Scissors.ordinal()][Shape.Rock.ordinal()] = Outcome.Win;
        outcomeMatrix[Shape.Scissors.ordinal()][Shape.Paper.ordinal()] = Outcome.Lose;
        outcomeMatrix[Shape.Scissors.ordinal()][Shape.Scissors.ordinal()] = Outcome.Draw;
        return outcomeMatrix;
    }

    private static int getScore(String myShapeCode, String opponentShapeCode)
    {
        var myShape = getMyShapeKey().get(myShapeCode);
        var opponentShape = getOpponentShapeKey().get(opponentShapeCode);
        var outcome = getOutcomeMatrix()[opponentShape.ordinal()][myShape.ordinal()];
        var score = getOutcomeScoreKey().get(outcome) + getShapeScoreKey().get(myShape);
        return score;
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
