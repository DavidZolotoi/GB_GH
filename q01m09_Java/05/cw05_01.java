import java.util.HashMap;

public class cw05_01
{
    public static void main(String[] args)
    {
        String text1 = "pppca";
        String text2 = "abbcc";

        System.out.println(getCheckIzo(text1, text2));
    }

    private static Boolean getCheckIzo(String text1, String text2)
    {
        Boolean result = false;
        if (text1.length() != text2.length()) return false;

        HashMap<Character, Integer> charText1 = new HashMap<>();
        HashMap<Character, Integer> charText2 = new HashMap<>();

        // Заполнение словарей
        // Вместо replace можно использовать тотже put(,)
        for (int i = 0; i < text1.length(); i++)
        {
            if (charText1.containsKey(text1.charAt(i)))
                charText1.replace(text1.charAt(i), charText1.get(text1.charAt(i)) + 1);
            else 
                charText1.put(text1.charAt(i), 1);

            if (charText2.containsKey(text2.charAt(i)))
                charText2.replace(text2.charAt(i), charText2.get(text2.charAt(i)) + 1);
            else 
                charText2.put(text2.charAt(i), 1);
        }

        // печать словарей
        System.out.println(charText1);
        System.out.println(charText2);

        if (charText1.size() == charText2.size()) result = true;
        // добавить проверку по значениям в словаре
        
        return result;
    }
}