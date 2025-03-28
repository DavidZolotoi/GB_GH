# Дан список чисел. Посчитайте, сколько в нем пар
# элементов, равных друг другу. Считается, что любые
# два элемента, равные друг другу образуют одну пару,
# которую необходимо посчитать.
# Вводится список чисел.
# Все числа списка находятся на разных строках.
# Ввод:                 Вывод:
# 1 2 3 2 3             2

import random
# Генерация списка из N элементов со значениями от A до B
N = 5
A = 1
B = 5
listInts1 = [random.randint(A, B + 1) for i in range(1, N + 1)]
print(f"Лист1:\n{listInts1}")

count = 0
for i in range(len(listInts1) - 1):
    for j in range(i+1, len(listInts1)):
        if(listInts1[i] == listInts1[j]):
            count += 1
print(f"Количество пар: {count}")