# Напишите программу, удаляющую из текста все слова, содержащие ""абв"".

# Пробежаться по тексту в поисках "абв"
# Найти левую и правую границы, используя разделители , . ; : - ! ? или пробел или начало или конец строки
# Удалить найденные слова

# Функция находит левую и правую границы слова и возвращает его.
def GetWordForDell(textOutput, i):
    znaki = [' ', '.', ',', ':', ';', '-', '!', '?']
    for j in range(i, -1, -1):
        if (textOutput[j] in znaki) or (j == 0):
            wordLeftSimbol = j
            print(f"\tЛевая граница слова № {wordLeftSimbol} -> \'{textOutput[wordLeftSimbol]}\'")
            break
    for k in range(i, len(textOutput)):
        if (textOutput[k] in znaki) or (k == len(textOutput) - 1):
            wordRightSimbol = k
            print(f"\tПравая граница слова № {wordRightSimbol} -> \'{textOutput[wordRightSimbol]}\'")
            break
    wordForDell = textOutput[wordLeftSimbol:wordRightSimbol+1]
    print(f"\tНайденное слово: {wordForDell}")
    return wordForDell

# Исходные данные
textInput = "Слово1абв, абвслово2: слоабвво3, абвслово4! Слово5абв? Слоабвво6, слово7."
textForDell = "абв"
# Обработка
textOutput = textInput  # Чтоб не терять начальный ввод
isFind = True   # Индикатор присутствия в строке textForDell => необходимости удаления слова
while(isFind):  # удалять до тех пор, пока есть что удалять
    for i in range(0, len(textOutput) - len(textForDell) + 1):
        textPart = textOutput[i : i+3]
        isFind = (textPart == textForDell)
        if (isFind):
            print(f"Найден \'{textForDell}\' c позиции № {i}")
            wordForDell = GetWordForDell(textOutput, i)
            textOutput = textOutput.replace(wordForDell, "").strip()
            print(f"\tТекст после удаления: {textOutput}")
            break
