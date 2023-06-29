from datetime import datetime
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
        with open(filePath, "w+", encoding="utf-8") as myFile:
            myFile.write("")

def GetMyList(filePath):
    """Вернуть справочник в виде листа"""
    with open(filePath, "r", encoding="utf-8") as myFile:
        myList = myFile.readlines()
    return myList

def ShowContacts(filePath):
    """Пункт меню. Показать весь справочник"""
    myList = GetMyList(filePath)
    report = "Показ справочника:\n"
    for myRow in myList:
        report += myRow.replace(";", " ")
    tmp = report
    return report, tmp

def AddContact(filePath):
    """Пункт меню. Добавить контакт"""
    print("Введ новых данных.")
    lastName = input("Введите фамилию: ")
    firstName = input("Введите имя: ")
    phoneNumber = input("Введите телефон: ")
    newContactRow = f"{lastName};{firstName};{phoneNumber};\n"
    mySet = set(GetMyList(filePath))
    if newContactRow in mySet:
        report = f"Контакт '{lastName} {firstName} {phoneNumber}' уже существует."
        tmp = "Error"
        return report, tmp
    with open(filePath, "a+", encoding="utf-8") as myFile:
        myFile.write(newContactRow)
    report = f"Контакт '{lastName} {firstName} {phoneNumber}' добавлен."
    tmp = (lastName, firstName, phoneNumber)
    return report, tmp

def FindContact(filePath):
    """Пункт меню. Найти контакт"""
    findText = input("Введите текст для поиска контакта: ")
    myList = GetMyList(filePath)
    report = f"Текст '{findText}' не найден."
    tmp = "Error"
    for rowNumber in range(0, len(myList)):
        if findText in myList[rowNumber]:
            contact = myList[rowNumber].replace(";", " ").replace("\n", "")
            report = f"На строке № {rowNumber} найден контакт: {contact}"
            tmp = rowNumber
            return report, tmp
    return report, tmp

def DeleteContact(filePath):
    """Пункт меню. Удалить контакт"""
    myList = GetMyList(filePath)
    FindContactReport, FindContactTMP = FindContact(filePath)
    if (FindContactTMP == "Error"):         # если не удалось найти
        report = FindContactReport
        tmp = "Error"
        return report, tmp
    rowForDel = FindContactTMP                                           # фикс номера строки
    contact = myList[FindContactTMP].replace(";", " ").replace("\n", "") # для отчета в консоль
    myList.remove(myList[FindContactTMP])                                # удалить
    with open(filePath, "w+", encoding="utf-8") as myFile:               # перезаписать в файл изменения
            myFile.write("".join(myList))
    report = f"Контакт '{contact}' удален."
    tmp = rowForDel
    return report, tmp

def EditContact(filePath):
    """Пункт меню. Редактировать контакт"""
    # 1. удалить
    DeleteContactReport, DeleteContactTMP = DeleteContact(filePath)
    if (DeleteContactTMP == "Error"):         # если не удалось удалить (т.е скорее всего найти)
        report = DeleteContactReport
        tmp = "Error"
        return report, tmp
    # 2. разбить список на два
    myList = GetMyList(filePath)
    myList1 = myList[:DeleteContactTMP]
    myList2 = myList[DeleteContactTMP:]
    # 3. записать первый список в файл
    with open(filePath, "w+", encoding="utf-8") as myFile:
            myFile.write("".join(myList1))
    # 4. вызов функции добавления нового контакта
    AddContactReport, AddContactTMP = AddContact(filePath)
    if (AddContactTMP == "Error"): # если не удалось добавить (т.е скорее всего такой контакт уже есть)
        report = AddContactReport
        tmp = "Error"
        return report, tmp
    # 5. дописать в конец второй список
    with open(filePath, "a+", encoding="utf-8") as myFile:
            myFile.write("".join(myList2))
    # 6. отчитаться
    report = f"Контакт {AddContactTMP[0]} {AddContactTMP[1]} {AddContactTMP[2]} в строке {DeleteContactTMP} отредактирован."
    tmp = DeleteContactTMP
    return report, tmp

def ExportContacts(filePath):
    """Пункт меню. Экспортировать контакты"""
    myList = GetMyList(filePath)                            # данные для экспорта в файл
    dateName = "Phonebook_" + str(datetime.now()).replace(" ", "").replace("-", "").replace(".", "").replace(":", "") + ".csv"
    fileParent = (os.path.dirname(os.path.normpath(filePath)))
    sep = "/" if ("/" in filePath) else "\\"
    exportFilePath = fileParent + sep + dateName                    # имя экспортного файла
    CreateFile(exportFilePath)                                      # создание файла - на всякий - необязательно
    with open(exportFilePath, "a+", encoding="utf-8") as myFile:    # запись данных в файл
            myFile.write("".join(myList))
    report = f"Выполнен экспорт в файл: {exportFilePath}"
    tmp = exportFilePath
    return report, tmp

def ImportContacts(filePath):
    """Пункт меню. Импортировать контакты"""
    fileParent = (os.path.dirname(os.path.normpath(filePath)))
    sep = "/" if ("/" in filePath) else "\\"
    defaultPathForImport = fileParent + sep + "FileForImport.csv"
    importFilePath = input(f"Введите путь к файлу csv для импортирования данных с файла.\n(Enter -  ввод адреса по умолчанию: '{defaultPathForImport}') ")
    if importFilePath == "": importFilePath = defaultPathForImport
    if (not os.path.exists(importFilePath)):
        report = f"Неверный адрес файла: {importFilePath}"
        tmp = "Error"
        return report, tmp
    listFromImport = GetMyList(importFilePath)
    with open(filePath, "a+", encoding="utf-8") as myFile:
        myFile.write("".join(listFromImport))
    report = f"Данные из файла '{importFilePath}' импортированы."
    tmp = importFilePath
    return report, tmp

def ExitProgram(filePath):
    """Пункт меню. Завершить программу через стандартный механизм выброса исключения"""
    raise SystemExit

def GetMenuDictionary():
    """Создать словарь для пунктов меню.
    Ключ - порядковый номер.
    Значение - кортеж из ссылки на функцию и текстового описания.
    """
    menuDict = {
        1: (ShowContacts,   "Показать справочник"),
        2: (AddContact,     "Добавить контакт"),
        3: (FindContact,    "Найти контакт"),
        4: (DeleteContact,  "Удалить контакт"),
        5: (EditContact,    "Редактировать контакт"),
        6: (ExportContacts, "Экспортировать контакты"),
        7: (ImportContacts, "Импортировать контакты"),
        8: (ExitProgram,    "Выйти из программы")
    }
    return menuDict    

def GetActionFromMenu(menuDict, filePath):
    """Показ меню и выбор действия"""
    print("Меню:")
    for key in menuDict:
        print(f"{key}. {menuDict[key][1]}.")
    actionFromMenu = int(input("Выберите действие: "))
    return actionFromMenu

def main() -> None:
    """Точка входа"""
    fileName = "Phonebook.txt"                  # имя файла справочника
    filePath = GetFilePath(fileName)            # формирование пути для справочника (рядом с file.py)
    CreateFile(filePath)                        # на всякий случай во избежание проблем - необязательно
    menuDict = GetMenuDictionary()              # создание меню
    report = ""                                 # отчет о проделанной работе по выбранному действию
    while (True):                               # бескоченый цикл выбора пункта меню (завершается спец.пунктом)
        actionFromMenu = GetActionFromMenu(menuDict, filePath)
        # Каждый метод возвращает report и tmp
        # report - отчет для вывода на консоль - для пользователя
        # tmp - какой-то объект для технических целей - в зависимости от метода - для программиста
        report, tmp = menuDict[actionFromMenu][0](filePath)
        os.system('cls||clear')
        print(report)

if __name__ == '__main__':
    main()
