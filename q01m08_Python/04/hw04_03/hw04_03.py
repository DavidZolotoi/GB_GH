# Задайте последовательность чисел.
# Напишите программу, которая выведет список неповторяющихся элементов исходной последовательности.

import random

# Генерация списка из N элементов со значениями от A до B
N = 50
A = 1
B = 9
listInts = [random.randint(A, B) for i in range(1, N + 1)]
print(f"Исходный лист:\n{listInts}")
listUniqueValue = set(listInts)
print(f"Списко уникальных значений:\n{listUniqueValue}")