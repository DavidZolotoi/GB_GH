# Задайте натуральное число N. Напишите программу, которая составит список простых множителей числа N.

import random

# Генерация числа в пределах от A до B
A = 1000
B = 10000
N = random.randint(A, B + 1)
print(f"Заданное число: {N}")

multipl = []
m = 2
while m <= N:
    if (N % m == 0):
        multipl.append(m)
        print(N, '\t|', m)
        N = N / m
        m = 1
    m += 1

mp = 1
for m in multipl:
    mp *= m
print(f"Проверка: {mp}")