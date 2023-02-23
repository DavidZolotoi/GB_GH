import os
import random

# КОНСТАНТЫ:
X = 'X'
O = 'O'

# первоначальное заполнение списка строк и прорисовка сетки
def GetFillTextList():
    textOutput = []
    textOutput.append(" _____________        _____________ ")       #  0
    textOutput.append(" |   |   |   |        |   |   |   | ")       #  1
    textOutput.append(" |   |   |   |        | 1 | 2 | 3 | ")       #  2
    textOutput.append(" |___|___|___|        |___|___|___| ")       #  3
    textOutput.append(" |   |   |   |        |   |   |   | ")       #  4
    textOutput.append(" |   |   |   |        | 4 | 5 | 6 | ")       #  5
    textOutput.append(" |___|___|___|        |___|___|___| ")       #  6
    textOutput.append(" |   |   |   |        |   |   |   | ")       #  7
    textOutput.append(" |   |   |   |        | 7 | 8 | 9 | ")       #  8
    textOutput.append(" |___|___|___|        |___|___|___| ")       #  9
    textOutput.append("                                    ")       # 10 итого 11 строк
    return textOutput
# вывод состояния
def Output_XO():
    textOutput[2] = textOutput[2][0:3] + list_XO[0][0] + textOutput[2][4:7] + list_XO[0][1] + textOutput[2][8:11] + list_XO[0][2] + textOutput[2][12:]
    textOutput[5] = textOutput[5][0:3] + list_XO[1][0] + textOutput[5][4:7] + list_XO[1][1] + textOutput[5][8:11] + list_XO[1][2] + textOutput[5][12:]
    textOutput[8] = textOutput[8][0:3] + list_XO[2][0] + textOutput[8][4:7] + list_XO[2][1] + textOutput[8][8:11] + list_XO[2][2] + textOutput[8][12:]
    print("\n" + "\n".join(textOutput))
# вертикальное перечеркивание
def Output_LineVertical(columnForLine):
    for i in [0,1,3,4,6,7,9,10]:
        textOutput[0] =   textOutput[0][0:columnForLine] + "|" +  textOutput[0][columnForLine+1:]
        textOutput[1] =   textOutput[1][0:columnForLine] + "|" +  textOutput[1][columnForLine+1:]
        textOutput[3] =   textOutput[3][0:columnForLine] + "|" +  textOutput[3][columnForLine+1:]
        textOutput[4] =   textOutput[4][0:columnForLine] + "|" +  textOutput[4][columnForLine+1:]
        textOutput[6] =   textOutput[6][0:columnForLine] + "|" +  textOutput[6][columnForLine+1:]
        textOutput[7] =   textOutput[7][0:columnForLine] + "|" +  textOutput[7][columnForLine+1:]
        textOutput[9] =   textOutput[9][0:columnForLine] + "|" +  textOutput[9][columnForLine+1:]
        textOutput[10] = textOutput[10][0:columnForLine] + "|" + textOutput[10][columnForLine+1:]
# горизонтальное перечеркивание
def Output_LineHorizontal(rowForLine, list_XO1, list_XO2, list_XO3):
        textOutput[rowForLine] = "-|-" + list_XO1 + "-|-" + list_XO2 + "-|-" + list_XO3 + "-|-" + textOutput[rowForLine][15:]
# перечеркивание по главной диагонали
def Output_LineDiagonal1(txtOut):
    simbol1 = 0
    for line1 in range(0, 10, +3):
         line2 = line1 + 1
         simbol2 = simbol1 + 2
         b = "\\"
         textOutput[line1] = f"{txtOut[line1][0:(simbol1)]}{b}{txtOut[line1][(simbol1+1):]}"
         textOutput[line2] = f"{txtOut[line2][0:(simbol2)]}{b}{txtOut[line2][(simbol2+1):]}"
         simbol1 += 4
# перечеркивание по обратной диагонали
def Output_LineDiagonal2(txtOut):
    simbol1 = 14
    for line1 in range(0, 10, +3):
         line2 = line1 + 1
         simbol2 = simbol1 - 2
         b = "/"
         textOutput[line1] = f"{txtOut[line1][0:(simbol1)]}{b}{txtOut[line1][(simbol1+1):]}"
         textOutput[line2] = f"{txtOut[line2][0:(simbol2)]}{b}{txtOut[line2][(simbol2+1):]}"
         simbol1 -= 4
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
        os.system('cls||clear')
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
            isMoveMade = not (list_XO[rowNumber][columnNumber] == " ")
        list_XO[rowNumber][columnNumber] = simb
        emptyCell = emptyCell.replace(str(cellNumber), "")
        return emptyCell
# функция проверки на GameOver
def CheckGameOver():
    # проверка на горизонтальные перечеркивания
    for i in [0,1,2]:
        if (list_XO[i][0] == list_XO[i][1] and list_XO[i][1] == list_XO[i][2] and list_XO[i][2] != " "):
            Output_LineHorizontal(i * 3 + 2, list_XO[i][0], list_XO[i][1], list_XO[i][2])
            return True
    # проверка на вертикальные перечеркивания
    for i in [0,1,2]:
        if (list_XO[0][i] == list_XO[1][i] and list_XO[1][i] == list_XO[2][i] and list_XO[2][i] != " "):
            Output_LineVertical(i * 4 + 3)
            return True
    if (list_XO[0][0] == list_XO[1][1] and list_XO[1][1] == list_XO[2][2] and list_XO[2][2] != " "):
        Output_LineDiagonal1(textOutput)
        return True
    if (list_XO[0][2] == list_XO[1][1] and list_XO[1][1] == list_XO[2][0] and list_XO[2][0] != " "):
        Output_LineDiagonal2(textOutput)
        return True
        

list_XO =   [[" ", " ", " "],
             [" ", " ", " "],
             [" ", " ", " "]]
textOutput = GetFillTextList()

simb1 = InputSimbol()       # simb1 - игрок, simb2 - бот
simb2 = X if (simb1 == O) else O
Output_XO()
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
        os.system('cls||clear')
        if (simb == simb1):
            print("Поздравляю! Вы победили!!!")
        else:
            print("Вы проиграли.")
        isGameOver = True
    if (not isGameOver) and (len(emptyCell) == 0):
        os.system('cls||clear')
        print("У нас ничья :)")
        isGameOver = True
    Output_XO()
    isBot = not isBot
    simb = simb2 if (isBot) else simb1