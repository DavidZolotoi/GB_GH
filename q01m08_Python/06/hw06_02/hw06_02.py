# Определить индексы элементов массива (списка),
# значения которых принадлежат заданному диапазону
# (т.е. не меньше заданного минимума и не больше заданного максимума)
import random

def inputData():
    """Функция ввода исходных данных: myList, minValue, maxValue.
    Возвращает заполненный кортеж.
    """
    myList = [random.randint(-10, 10) for i in range(0, random.randint(5, 15))]
    minValue = random.randint(-5, 0)
    maxValue = random.randint(0, 5)
    return (myList, minValue, maxValue)

def getList(myList, minValue, maxValue):
    """Функция создающая список из найденных индексов, удовлетворяющих условию.
    Принимает исходные данные: myList, minValue, maxValue.
    Возвращает список.
    """
    findList = [i for i in range(len(myList)) if minValue <= myList[i] <= maxValue]
    return findList

def printData(myList, minValue, maxValue, findList):
    """Функция вывода исходных данных и полученного списка.
    Принимает исходные данные: myList, minValue, maxValue; и список findList
    """
    print("Исходные данные:")
    print(f"myList = {myList}")
    print(f"minValue = {minValue}")
    print(f"maxValue = {maxValue}")
    if (len(findList) == 0):
        print("Условию задачи не удовлетворяет ни один элемент.")
    else:
        print("Условию задачи удовлетворяют следующие элементы:")
        for i in range(0, len(findList)):
            print(f"myList[{findList[i]}] = {myList[findList[i]]}")

def main() -> None:
    myList, minValue, maxValue = inputData()        # ввод исходных данных - разложение полученного кортежа
    findList = getList(myList, minValue, maxValue)  # создание и заполнение массива (списка)
    printData(myList, minValue, maxValue, findList)    # вывод массива (списка)

if __name__ == '__main__':
    main()