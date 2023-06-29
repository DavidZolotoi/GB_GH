#     Задайте число. Составьте список чисел Фибоначчи, в том числе для отрицательных индексов.
#     Пример:
# - для k = 8 список будет выглядеть так: [-21 ,13, -8, 5, −3, 2, −1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21]

import random

# Генерация числа в пределах от A до B
A = 1
B = 10
count = random.randint(A, B + 1)
print(f"Количество чисел слева и справа от 0: {count}")

fbListPositive = []         # для движения вправо
fbListPositive.append('0')
fbListPositive.append('1')
fbListNegative = []         # для движения влево
fbListNegative.append('0')
fbListNegative.append('1')

for i in range(1, count):
    fbListPositive.append(str(int(fbListPositive[i-1]) + int(fbListPositive[i])))
    fbListNegative.append(str(int(fbListNegative[i-1]) - int(fbListNegative[i])))

# Составление вывода
fbListPositiveForOutput = ', '.join(fbListPositive[1:])
# Реверс текста через comprehensions
fbListNegativeForOutput = ', '.join([fbListNegative[len(fbListNegative) - i - 1] for i in range(0, len(fbListNegative))])
fbListForOutput = fbListNegativeForOutput + ", " + fbListPositiveForOutput

print(fbListForOutput)