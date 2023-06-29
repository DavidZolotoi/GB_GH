#!/bin/bash

### ФУНКЦИИ ###
# Функция для создания заданного количества папок
create_folders() {
    local num_folders=$1

    for ((i=1; i<=num_folders; i++))
    do
        folder_name="folder$i"
        mkdir "$folder_name"
    done
}

# Функция для создания заданного количества файлов
create_files() {
    local num_files=$1

    for ((i=1; i<=num_files; i++))
    do
        file_name="file$i"

        # ТРИ КОМАНДы НИЖЕ ТОЛЬКО ДЛЯ РЕШЕНИЯ ЗАДАЧИ 4
        # ДЛЯ УНИВЕРСАЛЬНОГО ПРМЕНЕНИЯ УДАЛИТЬ
        random_number=$(shuf -i 1-4 -n 1)
        if [ "$random_number" -eq 1 ]; then
            extension=".bak"
        elif [ "$random_number" -eq 2 ]; then
            extension=".tmp"
        elif [ "$random_number" -eq 3 ]; then
            extension=".backup"
        else
            extension=".txt"
        fi
        file_name="file$i$extension"

        touch "$file_name"
    done
}

# Функция для создания случайной файловой системы
generateFoldersFiles() {
    # Генерируем случайное количество папок и файлов (от 1 до 10)
    local num_folders=$(( (RANDOM % 10) + 1 ))
    local num_files=$(( (RANDOM % 10) + 1 ))

    # Создаем папки в директории
    create_folders "$num_folders"

    # Создаем файлы в директории
    create_files "$num_files"
}

### КОД СКРИПТА ###

targetFolder=$1

# Проверяем, было ли передано название папки
if [ -z "$targetFolder" ]; then
  echo "Не указано название папки. Используйте: ./script.sh <название_папки>"
  exit 1
fi

# Создаем папку с указанным названием
mkdir "$targetFolder"

echo "Создана папка: $targetFolder"

# Переходим в папку targetFolder
cd "$targetFolder" || exit

# Генерируем случайную файловую структуру внути текущей папки
generateFoldersFiles
echo "Сгенерирована случайная файловая структура в папке: $targetFolder"

# Получаем список папок внутри targetFolder
subfolders=$(ls -d */)

# Цикл для обхода папок
for folder in $subfolders
do
  # Удаляем символ "/" из имени папки
  folder=${folder%/}
  
  # Переходим в папку
  cd "$folder" || continue
 
  # Генерируем случайную файловую систему внути текущей папки
  generateFoldersFiles
  echo "Сгенерирована случайная файловая структура в папке: $(pwd)"
   
  # Возвращаемся обратно в папку targetFolder
  cd ..
done

# Возвращаемся обратно из папки targetFolder
cd ..

