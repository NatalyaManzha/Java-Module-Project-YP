
public class Main {
    public static void main(String[] args) {
        Calculation receipt = new Calculation(); // создаем новый чек
        receipt.setNumberOfPeople(); // определяем количество персон для распределения расходов
        receipt.setListOfProducts(); // формируем список товаров и общую сумму
        receipt.resultPerPerson(); // распределяем расходы и выводим результат
    }
}

