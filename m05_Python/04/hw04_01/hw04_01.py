#     Вычислить число π c заданной точностью d
#     Пример:
# - при $d = 0.001, π = 3.141.$    $10^{-1} ≤ d ≤10^{-10}$

from random import random
d = 0.0001
k = len(str(d)[str(d).index('.') + 1:]) # кол-во знаков после запятой - для округления float при выводе
# 1 способ - стандартный
piList = []
for i in range(int(1 / d)):
    if random()**2 + random()**2 < 1:
            piList.append(1)
pi1 = 4.0 * d * len(piList)

# 2-ой способ - comprehensions
pi2 = 4.0 * d * len([1 for i in range(int(1 / d)) if random()**2 + random()**2 < 1])

print(round(pi1, k))
print(round(pi2, k))