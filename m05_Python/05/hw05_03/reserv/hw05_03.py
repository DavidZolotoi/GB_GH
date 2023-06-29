import random

# КОНСТАНТЫ:
X = 'X'
O = 'O'

# вывод состояния
def Output_XO(list_XO):
    print("_________________________        _________________________")
    print("|       |       |       |        |       |       |       |")
    print("|   " + list_XO[0][0] + "   |   " + list_XO[0][1] + "   |   " + list_XO[0][2] + "   |        |   1   |   2   |   3   |")
    print("|_______|_______|_______|        |_______|_______|_______|")
    print("|       |       |       |        |       |       |       |")
    print("|   " + list_XO[1][0] + "   |   " + list_XO[1][1] + "   |   " + list_XO[1][2] + "   |        |   4   |   5   |   6   |")
    print("|_______|_______|_______|        |_______|_______|_______|")
    print("|       |       |       |        |       |       |       |")
    print("|   " + list_XO[2][0] + "   |   " + list_XO[2][1] + "   |   " + list_XO[2][2] + "   |        |   7   |   8   |   9   |")
    print("|_______|_______|_______|        |_______|_______|_______|")
# выбор символа
def InputSimbol():
    isInputSimb = True
    while(isInputSimb):
        simb = input("Чем играть будете? (X/O) ")
        if(simb in ['X', 'x', 'Х', 'х', 'Ч', 'ч', '{', '[', '1', 1]):
            simb = X
            print(f"В качестве символа выбран: {simb}")
            isInputSimb = False
            return simb
        elif(simb in ['O', 'o', 'О', 'о', 'Щ', 'щ', 'J', 'j', '0', 0]):
            simb = O
            print(f"В качестве символа выбран: {simb}")
            isInputSimb = False
            return simb
        else:
            print("Не понял :( Давайте попробуем еще раз.")
            isInputSimb = True
# определение того, кто пойдет первым
def DrawBotPlayer():
    isInputDrawNumber = True
    isBot = True
    while isInputDrawNumber:
        drawNumber = input("Кто пойдет 1-ым?\n(0-Вы, 1-Компьютер, 2-выбрать случайно): ")
        if(drawNumber in ['0', '1', '2']):
            drawNumber = int(drawNumber)
            isInputDrawNumber = False
            if(drawNumber == 0):
                isBot = False
            elif(drawNumber == 1):
                isBot = True
            else:
                isBot = bool(random.randint(0, 1))
        else:
            print("Не понял :( Давайте попробуем еще раз.")
            isInputDrawNumber = True
    return isBot
# выбор клетки для ввода ботом, будет вложена в MoveMade в виде аргумента FuncCellNumber
def GenerateCellNumber(simb, emptyCell):
        cellNumber = int(emptyCell[random.randint(0, len(emptyCell))-1])     # номер клетки
        print(f"\nЯ поставил {simb} в {cellNumber} клетку.")
        return cellNumber
# выбор клетки для ввода пользователем, будет вложена в MoveMade в виде аргумента FuncCellNumber
def InputCellNumber(simb, emptyCell):
    isInputCell = True
    while isInputCell:
        cellNumber = input(f"\nВ какую клетку поставите {simb}? (1..9) ")
        if(cellNumber in emptyCell):
            cellNumber = int(cellNumber)
            isInputCell = False
            return cellNumber
        else:
            print("Не понял :( Давайте попробуем еще раз.")
            isInputCell = True
# функция, которая делает ход, как от бота, так и от пользователя - отличаются вложенной ф-ей FuncCellNumber
def MoveMade(simb, emptyCell, FuncCellNumber):
        isMoveMade = True
        while isMoveMade:
            cellNumber = FuncCellNumber(simb, emptyCell)
            rowNumber = int(cellNumber / 3.5)     # номер строки
            columnNumber = (cellNumber + 2) % 3   # номер столбца
            isMoveMade = not (list_XO[rowNumber][columnNumber] == ' ')
        list_XO[rowNumber][columnNumber] = simb
        emptyCell = emptyCell.replace(str(cellNumber), '')
        return emptyCell
# функция проверки на GameOver
def CheckGameOver():
    if     ((list_XO[0][0] == list_XO[0][1] and list_XO[0][1] == list_XO[0][2] and list_XO[0][2] != ' ')
        or  (list_XO[1][0] == list_XO[1][1] and list_XO[1][1] == list_XO[1][2] and list_XO[1][2] != ' ')
        or  (list_XO[2][0] == list_XO[2][1] and list_XO[2][1] == list_XO[2][2] and list_XO[2][2] != ' ')
        or  (list_XO[0][0] == list_XO[1][0] and list_XO[1][0] == list_XO[2][0] and list_XO[2][0] != ' ')
        or  (list_XO[0][1] == list_XO[1][1] and list_XO[1][1] == list_XO[2][1] and list_XO[2][1] != ' ')
        or  (list_XO[0][2] == list_XO[1][2] and list_XO[1][2] == list_XO[2][2] and list_XO[2][2] != ' ')
        or  (list_XO[0][0] == list_XO[1][1] and list_XO[1][1] == list_XO[2][2] and list_XO[2][2] != ' ')
        or  (list_XO[0][2] == list_XO[1][1] and list_XO[1][1] == list_XO[2][0] and list_XO[2][0] != ' ')):
        return True

list_XO =   [[' ', ' ', ' '],
             [' ', ' ', ' '],
             [' ', ' ', ' ']]

simb1 = InputSimbol()           # simb1 - игрок, simb2 - бот
simb2 = X if (simb1 == O) else O
Output_XO(list_XO)
isBot = DrawBotPlayer()     # переключатель игрока (True - ход бота, False - ход пользователя)
simb = simb2 if (isBot) else simb1
isGameOver = False
emptyCell = "123456789"     # в этой строке номера пустых клеток, постепенно будет уменьшаться
while not isGameOver:
    if (isBot):
        emptyCell = MoveMade(simb, emptyCell, GenerateCellNumber)
    else:
        emptyCell = MoveMade(simb, emptyCell, InputCellNumber)
    if (CheckGameOver()):
        if (simb == simb1):
            print("Поздравляю! Вы победили!!!")
        else:
            print("Вы проиграли.")
        isGameOver = True
    if (not isGameOver) and (len(emptyCell) == 0):
        print("У нас ничья :)")
        isGameOver = True
    Output_XO(list_XO)
    isBot = not isBot
    simb = simb2 if (isBot) else simb1