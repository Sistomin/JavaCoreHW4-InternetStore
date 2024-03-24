public class AmountException extends Exception{
    private final int currentAmount;

    public AmountException(int currentAmount) {
        super();
        this.currentAmount = currentAmount;
    }

    @Override
    public String getMessage() {
        return String.format("введено не корректное кол-во товара: %d.", currentAmount);
    }
}
