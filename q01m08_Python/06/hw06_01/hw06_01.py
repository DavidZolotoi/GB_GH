# Задача 30: Заполните массив элементами арифметической прогрессии.
# Её первый элемент, разность и количество элементов нужно ввести с клавиатуры.
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d.
# Каждое число вводится с новой строки.
import random

def inputData():
    """Функция ввода исходных данных для прогрессии: d, n, a1.
    Возвращает заполненный кортеж.
    """
    d = random.randint(-5, 5)    # ведь разность может быть и отрицательной
    n = random.randint(5, 15)
    a1 = random.randint(1, 5)    # 1-ый элемент (в математике) задается отдельно (0-ой в программировании)
    return (d, n, a1)

def getList(d, n, a1):
    """Функция создающая и заполняющая список с заданной прогрессией.
    Принимает исходные данные: разность d, количество n, первый элемент a1.
    Возвращает список с прогрессией.
    """
    progressionList = []
    progressionList.append(a1)
    for i in range(1, n):
        # ниже специально убираем +1, т.к. нумерация в математике с 1, а у нас с 0
        progressionList.append(progressionList[0] + (i) * d)
    return progressionList

def printData(d, n, a1, progressionList):
    """Функция вывода исходных данных и полученного списка с прогрессией.
    Принимает исходные данные: разность d, количество n, первый элемент a1; и список progressionList
    """
    print("Исходные данные")
    print(f"d = {d}")
    print(f"n = {n}")
    print(f"a[{1}] = {a1}")       # нумерация в математике с 1, а у нас с 0    
    print("Заполненный массив:")
    for i in range(0, len(progressionList)):
        print(f"a[{i + 1}] = {progressionList[i]}") # аналогично комментарию выше

def main() -> None:
    # (d, n, a1) - разность, количество, первый элемент
    d, n, a1 = inputData()                  # ввод исходных данных - разложение полученного кортежа
    progressionList = getList(d, n, a1)     # создание и заполнение массива (списка)
    printData(d, n, a1, progressionList)    # вывод массива (списка)

if __name__ == '__main__':
    main()