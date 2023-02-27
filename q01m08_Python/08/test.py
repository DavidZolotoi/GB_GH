from datetime import datetime
print(str(datetime.now()).replace(" ", "").replace("-", "").replace(".", "").replace(":", ""))