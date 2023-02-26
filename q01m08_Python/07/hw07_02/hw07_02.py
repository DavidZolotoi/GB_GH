# Напишите функцию print_operation_table(operation, num_rows=6, num_columns=6),
# которая принимает в качестве аргумента функцию, вычисляющую элемент по номеру строки и
# столбца. Аргументы num_rows и num_columns указывают число строк и столбцов таблицы,
# которые должны быть распечатаны. Нумерация строк и столбцов идет с единицы (подумайте,
# почему не с нуля). Примечание: бинарной операцией называется любая операция, у которой
# ровно два аргумента, как, например, у операции умножения.
# Ввод: Вывод:
# print_operation_table(lambda x, y: x * y)         1 2 3 4 5 6
#                                                   2 4 6 8 10 12
#                                                   3 6 9 12 15 18
#                                                   4 8 12 16 20 24
#                                                   5 10 15 20 25 30
#                                                   6 12 18 24 30 36

def printOperationTable(operation, numRows: int = 6, numColumns: int = 6) -> None:
    # for y in range(1, numRows + 1):
    #     print(*([operation(x, y) for x in range(1, numColumns + 1)]), sep='\t')
    # расшифровка 2 строк выше:
    listOutput = []
    for y in range(1, numRows + 1):
        rowOutput = ""
        for x in range(1, numColumns + 1):
            rowOutput += str(operation(x, y)) + "\t"
        listOutput.append(rowOutput)
    print(*listOutput, sep="\n")


def main() -> None:
    # Лист из кортежей, содержащих наименование операции и лямбда с такой операцией
    operations = [
        ('Умножение', lambda x, y: x * y),
        ('Сложение', lambda x, y: x + y),
        ('Вычитание', lambda x, y: x - y),
        ('Степень', lambda x, y: x**y)
    ]
    # Прогон по листу с кортежами и вызов функции вывода
    for operationName, operationFunction in operations:
        print(operationName)
        printOperationTable(operationFunction)
        print()

if __name__ == '__main__':
    main()
