# Задайте список из нескольких чисел. Напишите программу, которая найдёт сумму элементов списка, стоящих на нечётной позиции.
# Пример:
# [2, 3, 5, 9, 3] -> на нечётных позициях элементы 3 и 9, ответ: 12

import random

# Генерация списка из N элементов со значениями от A до B
N = 5
A = 1
B = 9
listInts = [random.randint(A, B + 1) for i in range(1, N + 1)]
print(f"Исходный лист:\n{listInts}")

# 1-й способ - стандартный
summOddPos = 0
for i in range(0, len(listInts) + 1):
    if (i % 2 == 0):
        summOddPos += listInts[i]
# 2-ой способ - comprehensions
summOddPos1 = sum([listInts[i] for i in range(0, len(listInts) + 1) if (i % 2 == 0)])

print(f"Сумма элементов, стоящих на нечетных позициях, посчитанная стандартным способом: {summOddPos}")
print(f"Сумма элементов, стоящих на нечетных позициях, посчитанная с применением comprehensions: {summOddPos1}")