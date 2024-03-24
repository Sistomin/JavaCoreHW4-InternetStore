public class ProductException extends Exception{
    private final Product product;

    public ProductException(Product product) {
        this.product = product;
    }

    @Override
    public String getMessage() {
        return String.format("Продукт не найден: \n%s", product);
    }
}
