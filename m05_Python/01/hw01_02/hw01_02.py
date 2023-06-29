x = float(input("Введите координату X:"))
y = float(input("Введите координату Y:"))

if (x==0) or (y==0):
    print("Точка лежит не в четверти, а на оси")
elif (x>0) and (y>0):
    print("Точка лежит в I четверти")
elif (x<0) and (y>0):
    print("Точка лежит в II четверти")
elif (x<0) and (y<0):
    print("Точка лежит в III четверти")
else:
    print("Точка лежит в IV четверти")