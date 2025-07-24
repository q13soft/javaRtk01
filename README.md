## Домашняя работа 4
Для выполнения 4 домашней работы созданы 2 файла Tv.java и App.java в папке проекта src\ru\rtk\java\hw\hw04
В пакете ru.rtk.java.hw.hw04 реализован главный основной класс App.java приложения и механизм работы программы, создается 2 телевизора затем оба телевизора включаются, нажимаются кнопки следующие и предыдущий каналы, нажимается кнопка выбора канала. Отключается один телевизор и у него не работают кнопки переключения и выбора каналов.

В пакете ru.rtk.java.hw.hw04 реализован класс  Tv.java работа телевизора.
Основные методы класса 
pressPower      -включение/выключение телевизора
infoAboutTv     -информация о телевизоре
setProgram      -установить канал
inputProgram    -выбор канала 
nextProgram     -переключить на следующий канал
prevProgram     -переключить на предыдущий канал
infoProgram     -информация о выбранном канале
getStatusString -возвращает статус телевизора, текст
setStatus       -изменяет статус телевизора
setLedStatus    -изменяет статус индикатора


Основные свойства класса 
name      -Строка, фирма производитель ТВ
model     -Строка, модель ТВ
status    -Логическая  (true - вкл, false - выкл)
ledStatus -Строка, статус индикатора 
program   -Число, активная программа 
codePage  -Строка, кодовая страница вывода, по умолчанию "cp866"


## Домашняя работа 3
Для выполнения 3 домашней работы созданы 2 файла Hw0301.java и Hw0302.java в папке проекта src\ru\rtk\java\hw\hw03
__Hw0301.java - выполнение первого задания__
Во время исполнения файла задачи 1 нужно ввести имя пользователя, после получения данных программа поздоровается с пользователем
__Hw0302.java - выполнение второго задания__
Во время исполнения файла задачи 2 начинается игра, игроки Вася и Петя показывают свою фигуру (камень-0, ножницы-1, бумага-2) и программа определяет, кто из них выиграл.

## Домашняя работа 2
JAVA проект сгенерирован инструментом VS Code плагин IDE Java, создать новый Java проект.
затем в системе управления версиями данный проект загружен на github 1 коммит.
Добавлена данная информация создан 2 коммит.
Добавим 3 коммит

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
