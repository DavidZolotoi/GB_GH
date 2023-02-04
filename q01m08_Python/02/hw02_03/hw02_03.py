valueIsInt = False
while not valueIsInt:
    number = input("Введите n для расчета последовательности (1 + 1/n)^n: ")
    simbolIsInt = True
    for i in number:
        simbolIsInt = simbolIsInt and (i in ['0','1','2','3','4','5','6','7','8','9'])
    if simbolIsInt: valueIsInt = True
number = int(number)

dictionary = {}
for i in range(1, number + 1):
    dictionary[i] = (1 + 1/i) ** i
    dictionary[i] = ((dictionary[i] * 1000) // 1) / 1000    #округление до 3х знаков

print(dictionary)