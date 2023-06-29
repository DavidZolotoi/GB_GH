# Создайте программу для игры с конфетами человек против человека.
# Условие задачи: На столе лежит 2021 конфета.
# Играют два игрока делая ход друг после друга.
# Первый ход определяется жеребьёвкой.
# За один ход можно забрать не более чем 28 конфет.
# Все конфеты оппонента достаются сделавшему последний ход.
# Сколько конфет нужно взять первому игроку, чтобы забрать все конфеты у своего конкурента?
# a) Добавьте игру против бота
# b) Подумайте как наделить бота ""интеллектом

import random

playerName = input("Здравствуйте!\nКак Вас зовут? ")
candyCount = random.randint(60, 100)
print(f"Изначально {candyCount} конфет.")
player = bool(random.randint(0, 1))    # 1 - его ход, 0 - ход игрока № 2
while(candyCount > 0):
    if player:
        print(f"Ваш ход")
        roundCount = 29
        while(roundCount>28):   # чтоб не халтурил
            roundCount = int(input("Сколько конфет возьмете?(<= 28): "))
    else:
        print("Мой ход")
        if (candyCount <= 28):  # минимальное наделение интеллектом
            roundCount = candyCount
        elif (28 < candyCount <= 56):
            roundCount = random.randint(1, 2)
        else:
            roundCount = random.randint(1, 28)

    if (roundCount < candyCount):
        candyCount -= roundCount
    else:
        roundCount = candyCount
        candyCount = 0
        if player: print("Поздравляю! Вы победили!")
        else: print("Ха-ха, я победил :-р")
    print(f"Изъято {roundCount} конфет. Осталось {candyCount}.")
    print("--------------")
    player = not player