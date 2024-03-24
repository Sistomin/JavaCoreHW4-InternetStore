import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Класс Store, с данными: о покупателях, товарах, заказах.
// Также в классе Store реализован метод makeOrder создания заказа.

public class Store {
    //region Объявляем ArrayList-ты для покупателей, продуктов и заказов
    final List<Client> clients;
    final List<Product> products;
    final List<Order> orders;
    //endregion

    //region Наполняем данными магазин: Покупатели, продукты, заказы
    public Store() {
        this.clients = Arrays.asList(
                new Client("Ivanov Ivan", 22, "+7-999-000-11-11", Gender.MALE),
                new Client("Sidorova Anna", 25, "+7-999-00-22-22", Gender.FEMALE),
                new Client("Popov Oleg", 35, "+7-999-000-33-33", Gender.MALE),
                new Client("Smirnova Olga", 29, "+7-999-000-44-44", Gender.FEMALE)
        );
        this.products = Arrays.asList(
                new Product("Milk", 80),
                new Product("Bread", 30),
                new Product("spaghetti", 85),
                new Product("meat", 763),
                new Product("oil", 100)
        );
        this.orders = new ArrayList<>(20);
    }
    //endregion

    //region Метод makeOrder создаёт заказ, так же в нем реализована логика проверки исключений
    /**
     * @param client покупатель
     * @param product товар
     * @param amount количество товара
     * @param date дата заказа из перечисления Celebration, для учета скидки
     * @return экземпляр заказа
     * @throws ClientException исключение такого покупателя нет
     * @throws ProductException исключение при выборе не существуещего товара
     * @throws AmountException исключение: не корректное количество товара (ввели отрицательное, нулевое либо больше 100 единиц).
     */
    Order makeOrder(Client client, Product product, int amount, Celebration date)
            throws ClientException, ProductException, AmountException {
        if (!clients.contains(client)) {
            throw new ClientException(client);
        }
        if (!products.contains(product)) {
            throw new ProductException(product);
        }
        if (amount < 1 || amount > 100) {
            throw new AmountException(amount);
        }
        return new Order(client, product, amount, date);
    }
    //endregion
}
