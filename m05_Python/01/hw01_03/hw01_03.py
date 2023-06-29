rangesValues = {
    1: "x ϵ (0; +∞), y ϵ (0; +∞)",
    2: "x ϵ (-∞; 0), y ϵ (0; +∞)",
    3: "x ϵ (-∞; 0), y ϵ (-∞; 0)",
    4: "x ϵ (0; ∞), y ϵ (-∞; 0)"
}

isQuater = False
while(not isQuater):
    quarter = int(input("Введите номер четверти цифрой 1/2/3/4: "))
    isQuater = (quarter == 1) or (quarter == 2) or (quarter == 3) or (quarter == 4)

print(rangesValues[quarter])