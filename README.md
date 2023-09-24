# Тестовое задание на позиции Junior Java разработчика

# Описание задачи 

Реализовать приложение, которая выполняет CRUD операции над Объектом (объект определяет сам кандидат).
Например: Список покупок, Онлайн магазин мобильных телефонов  
Definition of Done
- Язык программирования: Java 11 или Java 17
- Сборка приложения: Maven или Gradle
- Документирования кода: JavaDoc
- Логирование приложения: systemout или одно из реализаций logger
- Программа должна быть написана с применением ООП, DRY, YAGNI, должна компилироваться и запускаться. Плюсом будет - написаны тесты на функционал. 
- Исходники разместить на GitHub или в личном репозитории в корпоративном BitBucket (для внутренних кандидатов), должна быть видна история коммитов.

# Описание моего приложения
Я реализовал приложение, которое выплняет CRUD операции над объектом "Диспетчер задач". В своем приложение я добавил следующие возможности:
- Создание новой задачи
- Редактирование задачи
- Получение задачи по идентификатору
- Удаление задачи по идентификатору 

  Мое приложение собирается при помощи Maven, задокументировано JavaDoc, добавлено логирование systemout, и написаны юнит-тест для проверки функционала приложения. 
Я использовал следующие технологии:
- Java 17
- Spring boot
- База данных H2
- Junit
- Mockito



## Требования для запуска приложения

Для запуска этого приложения вам потребуется:

- Java 17
- Apache Maven 3.6.3+

## Установка

1. Склонируйте репозиторий на свой компьютер:

```git clone https://github.com/goldenchest19/crud-application.git```

У нас есть несколько способов для запуска проекта

  2.1 Запуск с помощью командой строки или терминала
  
  Перейдите в каталог проекта
  
  Выолните команду:
    ```mvn clean spring-boot:run```
    
   Готово! Приложение запущено локально по адресу: http://localhost:9000 

  2.2 Запуск приложения при помощи IDE
    Вам необходимо открывать в IDE проект, затем перейти в класс CrudApplication и запустить метод main

  Готово! Приложение запущено локально по адресу: http://localhost:9000 


## Использование приложения 

Для демонстрации работы приложения, Вам необходимо запустить приложение, затем открыть терминал и использовать следующие запросы:

- Создать новую задачу (POST /tasks):

```curl -X POST -H "Content-Type: application/json" -d '{"title":"New Task","completed":false}' http://localhost:9000/tasks```

- Обновить существующую задачу (PUT /tasks):

```curl -X PUT -H "Content-Type: application/json" -d '{"id":1,"title":"Updated Task","completed":true}' http://localhost:9000/tasks```

- Получить задачу по идентификатору (GET /tasks/{id}):

```curl http://localhost:9000/tasks/1```

- Удалить задачу по идентификатору (DELETE /tasks/{id}):

```curl -X DELETE http://localhost:9000/tasks/1```

Кроме того, Вы можете воспользоваться любым удобным приложением с UI интерфейсом, и выполнить запросы в нем. Так, например, можно воспользоваться приложением Postman
