public class Order {
    //region Поля константных значений, размера скидки
    private static final double GENDER_DISCOUNT = 0.15;
    private static final double NEW_YEAR_DISCOUNT = 0.2;
    //endregion
    //region Task4 Поля для присвоения уникальных идентификаторов заказам
    private static int countID = 0;
    private final int ID;
    //endregion
    private Client client;
    private Product product;
    private int amount;
    // Добавлено поле для хранения даты оформления заказа, учитывающей наличие праздника в этот день
    private Celebration date; // Поле хранения даты заказа, учитывающее наличие праздника в этот день

    public Order(Client client, Product product, int amount, Celebration date) {
        this.ID = ++countID;
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Заказ: {ID заказа = " + ID + " покупатель " + client.getName() + ", " + product +
                ", кол-во товара = " + amount + ", дата - " + date.getHoliday() + '}';
    }

    //region Метод расчета итоговой стоимости с учетом праздников и пола покупателя, возвращает стоимость заказа со скидкой
    public double getTotalCost() {
        if (date == Celebration.NEW_YEAR) {
            return amount * (1 - NEW_YEAR_DISCOUNT) * product.getPrice();
        }
        if (date == Celebration.MARCH_8 && client.getGender() == Gender.FEMALE ||
                date == Celebration.FEB_23 && client.getGender() == Gender.MALE) {
            return amount * (1 - GENDER_DISCOUNT) * product.getPrice();
        }
        return amount * product.getPrice();
    }
    //endregion
}
