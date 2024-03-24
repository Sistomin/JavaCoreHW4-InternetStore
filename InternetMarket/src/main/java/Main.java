
//Класс Main для проверки и запуска приложения, в котором создаётся экземпляр класса Store.


public class Main {
    public static void main(String[] args) {
        final Store store = new Store();
        final Object[][] data = {
                // новый год для мужского пола
                {store.clients.get(2), store.products.get(2), 10, Celebration.NEW_YEAR},
                // новый год для женского пола
                {store.clients.get(3), store.products.get(3), 10, Celebration.NEW_YEAR},
                // 23 февраля для мужского пола
                {store.clients.get(0), store.products.get(2), 4, Celebration.FEB_23},
                // 23 февраля для женского пола
                {store.clients.get(1), store.products.get(0), 1, Celebration.FEB_23},
                // 8 марта для женского пола
                {store.clients.get(1), store.products.get(1), 1, Celebration.MARCH_8},
                // 8 марта для мужского пола
                {store.clients.get(0), store.products.get(1), 5, Celebration.MARCH_8},
                // если нет праздника для мужского пола
                {store.clients.get(0), store.products.get(0), 2, Celebration.NONE},
                // если нет праздника для женского пола
                {store.clients.get(3), store.products.get(1), 2, Celebration.NONE},
                // не верный продукт, которого нет
                {store.clients.get(3), new Product("Холодильник", 80000), 1, Celebration.NONE},
                // отрицательное значение товара
                {store.clients.get(1), store.products.get(4), -1, Celebration.NONE},
                // Значение товара больше 100
                {store.clients.get(2), store.products.get(1), 101, Celebration.NONE},
                // не верный покупатель, которого нет
                {new Client("Roshkov Egor", 43, "+7-999-000-55-55", Gender.MALE), store.products.get(2), 4,
                        Celebration.NONE}
        };

        double totalCostOrders = 0;
        for (Object[] obj : data) {
            try {
                Order newOrder = store.makeOrder((Client) obj[0], (Product) obj[1], (Integer) obj[2], (Celebration) obj[3]);
                store.orders.add(newOrder);
                totalCostOrders += newOrder.getTotalCost();
                System.out.printf("Заказ успешно создан.\n%s\nИтоговая стоимость заказа: %.2f\n",
                        newOrder, newOrder.getTotalCost());
            } catch (ProductException e) {
                System.out.println(e.getMessage());
                System.out.println("Заказ ОТМЕНЕН!");
            } catch (AmountException e) {
                System.out.println(e.getMessage());
                Order changedOrder = new Order((Client) obj[0], (Product) obj[1], 1, (Celebration) obj[3]);
                store.orders.add(changedOrder);
                totalCostOrders += changedOrder.getTotalCost();
                System.out.printf("Создан заказ с одним товаром.\n%s\nИтоговая стоимость заказа: %.2f\n",
                        changedOrder, changedOrder.getTotalCost());
            } catch (ClientException e) {
                System.out.println(e.getMessage());
                System.out.println("Приложение завершилось с фатальной ошибкой!");
            } finally {
                System.out.printf("Номер созданного заказа: %d. Итоговая стоимость заказа: %.2f\n",
                        store.orders.size(), totalCostOrders);
                System.out.println("-------------Следующий кейс проверки-------------");
            }
        }
    }
}
