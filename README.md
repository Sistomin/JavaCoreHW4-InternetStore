![JavaCore Home Work# 4. Internet Store.](https://github.com/Sistomin/JavaCoreHW4-InternetStore/blob/main/Image.PNG)

Задание 1.  
Доделать задания про интернет-магазин. Обработать исключения, показывать "говорящие" сообщения о том, что пошло не так.  
-------------------------------------------------------

Созданы классы исключений унаследоваемых от классса Exception:  
ClientException - искллючение если пользователь не найден.  
AmountException - исключение не корректного колличества товара.  
ProductException - исключение товара нет.  

В классе Store реализован метод makeOrder который создаёт заказ, так же в нем реализована логика проверки исключений.
Реализация сообщений об исключениях в классе Main.  
+++++++++++++++++++++++++++++++++++++++++++++++  