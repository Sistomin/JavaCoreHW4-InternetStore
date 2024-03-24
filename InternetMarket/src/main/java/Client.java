public class Client {

    //region Task4 Переменные для присвоения индификатора покупателю
    private static int countID = 0;
    private final int ID;
    //endregion
    private String name;
    private int age;
    private String phone;
    private Gender gender; // Task2 Поле хранения "пола" покупателя

    // Конструктор класса покупатель
    public Client(String name, int age, String phone, Gender gender) {
        this.ID = ++countID; //Task4
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    //region Переопределение метода toString класса покупатель
    @Override
    public String toString() {
        return "Покупатель: " + "ID покупателя = " + ID + ", " + name + ", возраст " + age +
                ", телефон " + phone + ", пол " + gender.getGender();
    }
    //endregion

    //region Гетторы и Сетторы
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    } // Task2

    public void setGender(Gender gender) { this.gender = gender; } // Task2
    //endregion
}
