# Реализуйте RLE алгоритм: реализуйте модуль сжатия и восстановления данных.

# ЗАшифроватор: qwweeerrrrttttty -> q1w2e3r4t5y1
def encryptFunc(decryptTxt):
	encryptDict = {}
	lastSimbol = decryptTxt[0]
	encryptDict[lastSimbol] = 1
	for i in range(1, len(decryptTxt)):
		if (decryptTxt[i] == lastSimbol):
			encryptDict[lastSimbol] += 1
		else:
			lastSimbol = decryptTxt[i]
			encryptDict[lastSimbol] = 1
			encryptTxt = ""
	encryptTxt = "".join([str(simbolKey) + str(encryptDict[simbolKey]) for simbolKey in encryptDict])
	return encryptTxt

# РАЗшифроватор: q1w2e3r4t5y1 -> qwweeerrrrttttty
def decryptFunc(encryptTxt):
	# создание словаря - по идее можно и без этого обойтись, но тут логично создать словарь
	decryptDict = {}
	for i in range(0, len(encryptTxt)-1):
		simbolKey = encryptTxt[i]
		# на случай, если после буквы указано значение больше 9 (двух- трех- ...значное)
		simbolCount = '0'
		if (not simbolKey in ['1','2','3','4','5','6','7','8','9']):
			for j in range(i + 1, len(encryptTxt)):
				if (encryptTxt[j] in ['1','2','3','4','5','6','7','8','9']):
					simbolCount += encryptTxt[j]
				else:
					break
		decryptDict[simbolKey] = int(simbolCount)
	# создание расшифрованного текста
	decryptTxt = ""
	for simbolKey in decryptDict:
		decryptTxt += "".join([simbolKey for i in range(0, decryptDict[simbolKey])])
	return decryptTxt

# ввод
inputTxt = "qwweeerrrrtttttyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
print(f"inputTxt = \t{inputTxt}")
# зашифровка
encryptTxt = encryptFunc(inputTxt)
print(f"encryptTxt = \t{encryptTxt}")
# расшифровка
decryptTxt = decryptFunc(encryptTxt)
print(f"decryptTxt = \t{decryptTxt}")