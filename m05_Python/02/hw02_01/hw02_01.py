dopustimie = ['-','.',',']
ints = ['0','1','2','3','4','5','6','7','8','9']
number = input("Введите число: ")
s = 0
for i in number:
    if not ((i in dopustimie) or (i in ints)):
         print("Введено недопустимое значение для вводимого числа")
         break
    if i in ints: s += int(i)
print(f"Сумма цифр введенного числа равна {s}.")