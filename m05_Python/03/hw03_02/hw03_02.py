#  Напишите программу, которая найдёт произведение пар чисел списка. Парой считаем первый и последний элемент, второй и предпоследний и т.д.
#     Пример:
# - [2, 3, 4, 5, 6] => [12, 15, 16];
# - [2, 3, 5, 6] => [12, 15]

import random

# Генерация списка из N элементов со значениями от A до B
N = 10
A = 1
B = 9
listInts = [random.randint(A, B + 1) for i in range(1, N + 1)]
print(f"Исходный лист:\n{listInts}")

# 1-й способ - стандартный
listMultipl = []
for i in range(0, len(listInts)//2):
    listMultipl.append(listInts[i] * listInts[len(listInts) - i - 1])

# 2-ой способ - comprehensions
listMultipl1 = []
listMultipl1 = [listInts[i] * listInts[len(listInts) - i - 1] for i in range(0, len(listInts)//2)]

# Для случая когда в исходном листе нечетное количество элементов
if (len(listInts) % 2 == 1):
     listMultipl.append(listInts[len(listInts)//2] ** 2)

print(f"Лист, обработанный стандартным способом: {listMultipl}")
print(f"Лист, обработанный с применением comprehensions: {listMultipl1}")