txt = "qwweeerrrrttttt"
simbDict = {}
simb = txt[0]
simbDict[simb] = 1
for i in range(1, len(txt)):
	if txt[i] == simb:
		simbDict[simb] += 1
	else:
		simb = txt[i]
		simbDict[simb] = 1
print(simbDict)
