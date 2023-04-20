package org.example.view;

/**
 * Класс для вывода информации (монитор, файл, почта, телега, принтер)
 */
public class OutputInfo {
    /**
     * Информация для отправки на вывод (в сохранении лежит последний вариант)
     */
    private String infoForSend;

    /**
     * Отправляет на вывод информацию из переменной infoForSend
     * @return результат выполнения операции
     */
    public Boolean sendInfo(){
        System.out.println(this.infoForSend);
        return true;
    }

    /**
     * Отправляет на вывод информацию из переменной infoForSend (предварительно получив ее из аргумента и сохранив)
     * @param infoForSend информация для отправки на вывод
     * @return результат выполнения операции
     */
    public Boolean sendInfo(String infoForSend){
        this.infoForSend = infoForSend;
        sendInfo();
        return true;
    }

    /**
     * Создает объект для вывода информации
     */
    public OutputInfo() {
        this.infoForSend = "Нет информации для вывода";
    }

    /**
     * Создает объект для вывода информации
     * @param infoForSend информация для вывода
     */
    public OutputInfo(String infoForSend) {
        this.infoForSend = infoForSend;
    }
}
