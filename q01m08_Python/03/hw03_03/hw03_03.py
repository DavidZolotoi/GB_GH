#     Задайте список из вещественных чисел.
#     Напишите программу, которая найдёт разницу между максимальным и минимальным значением дробной части элементов.
#     Пример
#     [1.1, 1.2, 3.1, 5, 10.01] => 0.19

import random

# Генерация списка из N элементов со значениями от A до B
N = 10  # кол-во
A = 1   # мин значение
B = 9   # макс значение
listFloats = [round(random.randint(A, B - 1) + random.random(), random.randint(1, 3)) for i in range(1, N + 1)]
print(f"Исходный лист:\n{listFloats}")

# Определение Мин и Макс среди дробных частей
minFract = 1.0
maxFract = 0.0
for i in listFloats:
    k = len(str(i)[str(i).index('.') + 1:]) # определяем точность числа - сколько знаков после "."
    fract = round(i - i // 1, k)    # это округление для того, чтоб число float  в выоде было красивым и точным
    if (fract < minFract):
                minFract = fract
    if (fract > maxFract):
                maxFract = fract

# Разница и вывод
delta = maxFract - minFract
deltaStr = str(delta)[str(delta).index('.') + 1:]  # избавляемся от "0." через поиск точки, хотя и можно было просто написать str(delta)[2:]
print(f"Разница между максимальным и минимальным значением дробной части элементов: {deltaStr}")