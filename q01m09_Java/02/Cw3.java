import java.io.FileWriter;
import java.io.IOException;
/*
 * Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
 * который запишет эту строку в простой текстовый файл, обработайте исключения.
 */
public class Cw3 {
    public static void main(String[] args) {
        StringBuilder text = getNewString("TEST");
        writeFile(text.toString());
    }
    public static StringBuilder getNewString(String word)
    {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            text.append(word);
            text.append("\n");
        }
        return text;
    }
    public static void writeFile(String text)
    {
        try(FileWriter writer = new FileWriter("fileText.txt", false))
        {
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
