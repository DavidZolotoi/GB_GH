#    Задана натуральная степень k.
#    Сформировать случайным образом список коэффициентов (значения от 0 до 100) многочлена и записать в файл многочлен степени k.
#    Пример:
#- k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0

import random

N = random.randint(5, 20)
kMin = 0
kMax = 100  # чтоб увидеить обработку коэффициентов 0 и 1, лучше уменьшить kMax до 5
coefficients = [random.randint(kMin, kMax) for i in range(1, N + 2)]    # +1, чтоб зацепить само N и еще +1 для одночлена нулевой степени
print(f"Исходные данные:\nСтепень многочлена: {N}\nСписок коэффициентов: {coefficients}")

mono = []
for i in range(N, -1, -1): 
    # i - степень, N-i - номер коэффициента
    # k - коэф, z - знак *, xst - икс в степени
    k = str(coefficients[N - i])
    z = "*"
    xst = f"x^{i}"
    if k == "0":
        continue
    if k == "1" and i != 0:
        k = ""
        z = ""
    if k == "1" and i == 0:
        k = "1"
        z = ""
        xst = ""
    if i == 1:
        xst = "x"
    if i == 0:
        z = ""
        xst = ""
    monomial = k + z + xst
    mono.append(monomial)
poly = " + ".join(mono) + " = 0"

print(f"Многочлен: {poly}")