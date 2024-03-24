public enum Celebration {
    NEW_YEAR("Скидка на Новый Год"), MARCH_8("Скидка на 8 марта"),
    FEB_23("Скидка на 23 февраля"), NONE("Обычный день. Скидки нет.");
    private final String holiday;

    Celebration(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }
}
