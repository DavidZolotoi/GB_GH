/*
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

 public class hw02_01 {
    public static void main(String[] args) {

        // Исходные данные
        String sqlRequestStart = "select * from students where ";
        String jsonTextForParse = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println("Входные данные:");
        System.out.println(sqlRequestStart);
        System.out.println(jsonTextForParse);

        // Обработка
        StringBuilder sqlRequest = new StringBuilder();
        sqlRequest.append(sqlRequestStart);
        sqlRequest.append("\n");
        sqlRequest.append(jsonParseToSQL(dellNullParametres(jsonTextForParse)));

        // Вывод
        System.out.println("Выходные данные:");
        System.out.println(sqlRequest);
    }

    // Поиск параметра со значением null и его удаление
    private static StringBuilder dellNullParametres(String jsonTextForParse)
    {
        String strForFindDel = "\"null\"";
        StringBuilder sqlParameters = new StringBuilder();
        sqlParameters.append(jsonTextForParse);
        Integer nullNumber = jsonTextForParse.indexOf(strForFindDel);
        if (nullNumber != -1)
        {
            // поиск левой границы для удаления - вторая кавычка при движении влево
            int nullStartForDell = -1;
            int leftQuoteNumber = 0;
            for (int i = nullNumber - 1; i >= 0; i--)
            {
                if (sqlParameters.charAt(i) == '\"')
                {
                    leftQuoteNumber += 1;
                    if (leftQuoteNumber == 2)
                    {
                        nullStartForDell = i;
                        break;
                    }
                }
            }
            // поиск правой границы
            int nullFinishForDell = nullNumber + strForFindDel.length() - 1; // strForFindDel еще содержит в себе 2 каычки
            
            // Для удаления ", " при условии, что оно есть
            // Если старт - 1 = 0 и сдвиг вправо не вылетает за конец, то сдвинуть финал на 2 вправо
            if (nullStartForDell - 1 == 0 && nullFinishForDell + 2 < sqlParameters.length() - 1)
                        nullFinishForDell += 2;     // для удаления ", " справа
            // Если финал + 1 = длина - 1 и сдвиг влево не вылетает за начало, то сдвинуть старт на 2 влево
            if (nullFinishForDell + 1 == sqlParameters.length() - 1 && nullStartForDell - 2 > 0)
                        nullStartForDell -= 2;      // для удаления ", " слева

            // удаление выражения:  "parameter" = "null" и ", " либо справа, либо слева
            sqlParameters.replace(nullStartForDell, nullFinishForDell, "" );
        }
        return sqlParameters;
    }

    // Преобразование json формата в формат SQL-запроса
    private static StringBuilder jsonParseToSQL(StringBuilder jsonTextForParse)
    {
        StringBuilder sqlParameters = new StringBuilder();
        sqlParameters.append(jsonTextForParse);

        // Замена символов
        sqlParameters.append(' ');
        Integer quotesNumber = 0;
        for (int i = 0; i < sqlParameters.length(); i++)
        {
            switch (sqlParameters.charAt(i)) {
                case '{':
                    sqlParameters.replace(i, i + 1, " " );
                    break;
                case '}':
                    sqlParameters.replace(i, i + 1, ";" );
                    break;
                case ':':
                    sqlParameters.replace(i, i + 1, "= " );
                    break;
                case '\"':
                    quotesNumber += 1;
                    if (quotesNumber % 4 == 1 || quotesNumber % 4 == 2)
                            sqlParameters.replace(i, i + 1, " " );
                    else
                            sqlParameters.replace(i, i + 1, "\'" );
                    break;
                case ',':
                    sqlParameters.replace(i, i + 2, " AND" );
                    break;
            }
        }
        return sqlParameters;
    }
}
