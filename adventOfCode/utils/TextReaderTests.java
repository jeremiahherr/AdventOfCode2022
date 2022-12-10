
package adventOfCode.utils;

import org.junit.*;

public class TextReaderTests 
{
    @Test
    public void readFromFileTest()
    {
        try
        {
            var input = TextReader.readFromFile(Settings.PROJECT_FOLDER + "day1/ElfCalories_Test.txt");
            var lines = input.split(Settings.NEW_LINE);
            Assert.assertEquals("1000", lines[0]);
            Assert.assertEquals("2000", lines[1]);
            Assert.assertEquals("3000", lines[2]);
            Assert.assertEquals(Settings.EMPTY_STRING, lines[3]);
            Assert.assertEquals("4000", lines[4]);
            Assert.assertEquals(Settings.EMPTY_STRING, lines[5]);
            Assert.assertEquals("5000", lines[6]);
            Assert.assertEquals("6000", lines[7]);
            Assert.assertEquals(Settings.EMPTY_STRING, lines[8]);
            Assert.assertEquals("7000", lines[9]);
            Assert.assertEquals("8000", lines[10]);
            Assert.assertEquals("9000", lines[11]);
            Assert.assertEquals(Settings.EMPTY_STRING, lines[12]);
            Assert.assertEquals("10000", lines[13]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }
}
