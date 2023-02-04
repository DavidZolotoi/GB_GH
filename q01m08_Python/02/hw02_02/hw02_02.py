MAX_VALUE = 1000
number = -1
while(not (number >= 0 and number <= MAX_VALUE)):
    number = int(input(f"Введите число N (0;{MAX_VALUE}): "))
numbers = []
numbers.append(1)
print(f"numbers[{0}] = {numbers[0]}")
for i in range(1, number+1):
    numbers.append(numbers[i-1] * i)
print(numbers)