print("Введите координаты точек A и B.")
xA = float(input("Абсцисса x точки A: "))
yA = float(input("Ордината y точки A: "))
xB = float(input("Абсцисса x точки B: "))
yB = float(input("Ордината y точки B: "))

length = ((xB - xA) ** 2 + (yB - yA) ** 2) ** 0.5
# округляю, не применяя библиотеки math
length = float(((length * 100) // 1) / 100)

print(f"Расстояние между точками A({xA}; {yA}) и B({xB}; {yB}) равно {length}.")