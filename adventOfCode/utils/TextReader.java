
package adventOfCode.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader 
{
    public static String readFromFile(String fileName) throws FileNotFoundException
    {
        var file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String output = Settings.EMPTY_STRING;
        while (scanner.hasNextLine())
        {
            output += scanner.nextLine() + Settings.NEW_LINE;
        }
        scanner.close();
        return output;
    }
}
