#     Напишите программу, которая будет преобразовывать десятичное число в двоичное.
#     Пример:
# - 45 -> 101101
# - 3 -> 11
# - 2 -> 10

import random

# Генерация числа в пределах от A до B
A = 1
B = 5
randomInt10 = random.randint(A, B + 1)
print(f"В десятичной с.ч.: {randomInt10}")

# Перевод числа в двоичную систему счисления
randomStrForReverse2 = ''
while randomInt10 > 0:
        randomStrForReverse2 += str(randomInt10 % 2)
        randomInt10 = randomInt10 // 2

# Реверс текста обычным способом через цикл
# randomStr2 = ''
# for i in range(0, len(randomStrForReverse2)):
#        randomStr2 += randomStrForReverse2[len(randomStrForReverse2) - i - 1]

# Реверс текста через comprehensions
randomStr2 = ''.join([randomStrForReverse2[len(randomStrForReverse2) - i - 1] for i in range(0, len(randomStrForReverse2))])

print(f"В двоичной с.ч.: {randomStr2} ")