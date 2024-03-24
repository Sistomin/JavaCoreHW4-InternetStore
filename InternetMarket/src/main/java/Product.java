public class Product {
    //region Task4 Поля для присвоения уникальных идентификаторов продуктам
    private static int countID = 0;
    private final int ID;
    //endregion
    private String name;
    private int price;

    public Product(String name, int price) {
        this.ID = ++countID; //Task4
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Продукт {" +
                "ID продукта  = " + ID + //Task4
                ", название продукта - '" + name + '\'' +
                ", цена = " + price +
                '}';
    }

    public int getID() { //Task4
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
