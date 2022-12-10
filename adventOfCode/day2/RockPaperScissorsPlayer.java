package adventOfCode.day2;

import java.util.HashMap;
import adventOfCode.utils.*;

public class RockPaperScissorsPlayer 
{
    public enum StrategyDecryption
    {
        Mine,
        Elfs
    }

    public static int playTournament(String strategy, StrategyDecryption decryption)
    {
        var totalScore = 0;
        var rounds = getStrategyRounds(strategy);
        for (int round = 0; round < rounds.length; round++)
        {
            var roundShapeCodes = getRoundShapeCodes(rounds[round]);
            var myShapeCode = roundShapeCodes[Players.Me.ordinal()];
            var opponentShapeCode = roundShapeCodes[Players.Opponent.ordinal()];
            totalScore += getScore(myShapeCode, opponentShapeCode, decryption);
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
        Lose,
        Draw,
        Win
    }

    private static HashMap<Outcome, Integer> getOutcomeScoreKey()
    {
        var outcomeScoreKey = new HashMap<Outcome, Integer>();
        outcomeScoreKey.put(Outcome.Win, 6);
        outcomeScoreKey.put(Outcome.Lose, 0);
        outcomeScoreKey.put(Outcome.Draw, 3);
        return outcomeScoreKey;
    }

    private static HashMap<String, Outcome> getMyOutcomeKey()
    {
        var myOutcomeKey = new HashMap<String, Outcome>();
        myOutcomeKey.put("X", Outcome.Lose);
        myOutcomeKey.put("Y", Outcome.Draw);
        myOutcomeKey.put("Z", Outcome.Win);
        return myOutcomeKey;
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

    private static Shape[][] getMyShapeMatrix()
    {
        var myShapeMatrix = new Shape[Shape.values().length][Outcome.values().length];
        myShapeMatrix[Shape.Rock.ordinal()][Outcome.Lose.ordinal()] = Shape.Scissors;
        myShapeMatrix[Shape.Rock.ordinal()][Outcome.Draw.ordinal()] = Shape.Rock;
        myShapeMatrix[Shape.Rock.ordinal()][Outcome.Win.ordinal()] = Shape.Paper;
        myShapeMatrix[Shape.Paper.ordinal()][Outcome.Lose.ordinal()] = Shape.Rock;
        myShapeMatrix[Shape.Paper.ordinal()][Outcome.Draw.ordinal()] = Shape.Paper;
        myShapeMatrix[Shape.Paper.ordinal()][Outcome.Win.ordinal()] = Shape.Scissors;
        myShapeMatrix[Shape.Scissors.ordinal()][Outcome.Lose.ordinal()] = Shape.Paper;
        myShapeMatrix[Shape.Scissors.ordinal()][Outcome.Draw.ordinal()] = Shape.Scissors;
        myShapeMatrix[Shape.Scissors.ordinal()][Outcome.Win.ordinal()] = Shape.Rock;
        return myShapeMatrix;
    }

    private static int getScore(String myActionCode, String opponentShapeCode, StrategyDecryption decryption)
    {
        Shape myShape;
        Outcome outcome;
        var opponentShape = getOpponentShapeKey().get(opponentShapeCode);
        if (decryption == StrategyDecryption.Mine)
        {
            myShape = getMyShapeKey().get(myActionCode);
            outcome = getOutcomeMatrix()[opponentShape.ordinal()][myShape.ordinal()];
        }
        else
        {
            outcome = getMyOutcomeKey().get(myActionCode);
            myShape = getMyShapeMatrix()[opponentShape.ordinal()][outcome.ordinal()];
        }
        var score = getOutcomeScoreKey().get(outcome) + getShapeScoreKey().get(myShape);
        return score;
    }

    public static void main(String[] args)
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day2/Strategy_MyPuzzle.txt");
            System.out.println("Part 1 Answer: " + playTournament(input, StrategyDecryption.Mine));
            System.out.println("Part 2 Answer: " + playTournament(input, StrategyDecryption.Elfs));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
