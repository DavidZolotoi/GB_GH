import os

def GetFilePath(fileName):
    """Определяет местоположение исполняемого файла и его родителя.
    Определяет используемый разделитель в строке пути.
    Возвращает строку - созданный путь для будущего файла справочника.
    """
    filePath = os.path.abspath(__file__)
    fileParent = (os.path.dirname(os.path.normpath(filePath)))
    sep = "/" if ("/" in filePath) else "\\"
    return fileParent + sep + fileName

def CreateFile(filePath):
    """Создание файла, если он еще не существует"""
    if (not os.path.exists(filePath)):
        myFile = open(filePath, "w+")
        myFile.write("")
        myFile.close()

def AddContact(filePath):
    """Добавить контакт"""
    lastName = input("Введите фамилию: ")
    firstName = input("Введите имя: ")
    phoneNumber = input("Введите телефон: ")
    myFile = open(filePath, "a+")
    myFile.write(f"{lastName};{firstName};{phoneNumber};\n")
    myFile.close()

def FindContact(filePath):
    """Найти контакт"""
    pass

def EditContact(filePath):
    """Редактировать контакт"""
    pass

def DeleteContact(filePath):
    """Удалить контакт"""
    pass

def ExportContacts(filePath):
    """Экспортировать контакты"""
    pass

def ImportContacts(filePath):
    """Импортировать контакты"""
    pass

def ExitProgram(filePath):
    """Завершить программу через стандартный механизм выброса исключения"""
    raise SystemExit

def GetMenuDictionary():
    """Создать словарь для пунктов меню.
    Ключ - порядковый номер.
    Значение - кортеж из ссылки на функцию и текстового описания.
    """
    menuDict = {
        1: (AddContact,     "Добавить контакт"),
        2: (FindContact,    "Найти контакт"),
        3: (EditContact,    "Редактировать контакт"),
        4: (DeleteContact,  "Удалить контакт"),
        5: (ExportContacts, "Экспортировать контакты"),
        6: (ImportContacts, "Импортировать контакты"),
        7: (ExitProgram,    "Выйти из программы")
    }
    return menuDict    

def GetActionFromMenu(menuDict, filePath):
    print("Меню:")
    for key in menuDict:
        print(f"{key}. {menuDict[key][1]}.")
    print("Выберите действие: ")
    actionFromMenu = int(input())
    return actionFromMenu

def main() -> None:
    """Точка входа"""
    fileName = "Phonebook.txt"                  # имя файла справочника
    filePath = GetFilePath(fileName)            # формирование пути для справочника (рядом с file.py)
    CreateFile(filePath)                        # на всякий случай во избежание проблем - необязательно
    menuDict = GetMenuDictionary()              # создание меню
    while (True):                               # бескоченый цикл выбора пункта меню (завершается спец.пунктом)
        actionFromMenu = GetActionFromMenu(menuDict, filePath)
        menuDict[actionFromMenu][0](filePath)
        os.system('cls||clear')

if __name__ == '__main__':
    main()