@rem в качестве 1-го аргумента (%1) название новой ветки (Homework05)
@rem в качестве 2-го аргумента (%2) название новой папки (Homework05_01)
@rem в качестве 3-го аргумента (%3) комментарий для коммита (пример на следующей строке)
@rem "Д/З по знакомству с языками. Урок 5 - Функции и одномерные массивы. Создал пустой проект для задачи №2."

d:
cd D:\Catalog\Csharp\GB\gb_gh
git checkout %1
cd D:\Catalog\Csharp\GB\gb_gh\q01m06_CsharpStart
md %2
cd %2
dotnet new console
cd D:\Catalog\Csharp\GB\gb_gh
git add .
git commit -m %3
git push
git branch