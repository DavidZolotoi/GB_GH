#     Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
#     Пример:
# - 6 -> да
# - 7 -> да
# - 1 -> нет

message = "Введите цифру, обозначающую день недели [1..7]: "

day = -1
while(day < 1 or day > 7):
    day = int(input(message))

if day > 5:
    print("Выходной")
else:
    print("Будни")