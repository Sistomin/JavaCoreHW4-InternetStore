public class ClientException extends Exception{
    private final Client client;

    public ClientException(Client client) {
        this.client = client;
    }

    @Override
    public String getMessage() {
        return String.format("Не известный покупатель: \n%s", client);
    }
}
