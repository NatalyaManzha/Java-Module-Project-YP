import java.util.Scanner;

public class Calculation {
    int numberOfPeople; // количество человек
    String listOfProducts; // список товаров
    double result; // сумма покупки

    public void setNumberOfPeople() {
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            Scanner scanner = new Scanner(System.in);
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople == 1) {
                System.out.println("В этом случае нет смысла ничего считать и делить.");
            } else if (numberOfPeople < 1) {
                System.out.println("Это некорректное значение для подсчёта.");
            } else
                break;
        }
    }

    public void setListOfProducts() { // составляем список приобретенных товаров и сумму покупки
        listOfProducts = "Добавленные товары:\n";
        while (true) {
            Nomenclature item = new Nomenclature();
            item.name = "Наименование товара";
            System.out.println("Введите название товара.");
            item.name = item.checkName(item.name);
            System.out.println("Введите цену товара в формате \"рубли,копейки\"");
            item.price = item.checkPrice(item.price); // ввод цены с защитой от ошибки
            result = result + item.price;
            listOfProducts = listOfProducts + item.name + "   " + item.price + "\n";
            System.out.println("Товар успешно добален.");
            System.out.println("Если желаете завершить список, введите \"Завершить\", если продолжаем - любой символ.");
            Scanner scanner1 = new Scanner(System.in);
            String answer = scanner1.nextLine();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }


    public void resultPerPerson() { // рассчитываем сумму расходов на каждого человека и печатаем рассчет
        System.out.println(listOfProducts);
        double resultPerPerson = result / numberOfPeople;
        String rubl = chooseTheCorrectCase(result); // определяем правильные число и падеж для слова "рубль"
        String rubl1 = chooseTheCorrectCase(resultPerPerson);
        System.out.println("Итого:         " + String.format("%.2f", result) + " " + rubl + ";\nС каждого по:  " + String.format("%.2f", resultPerPerson) + " " + rubl1 + ".");
    }

    String chooseTheCorrectCase(double x) {  // метод для определения правильного падежа слова "рубль"
        String correctCase;
        int numberRoundUp = (int) Math.floor(x); // округление суммы до целого в меньшую сторону
        if (numberRoundUp % 100 >= 11 && numberRoundUp % 100 <= 14) { //последние 2 цифры (остаток от деления на 100 нацело) от 11 до 14
            correctCase = "рублей";
        } else {
            int lastDigit = numberRoundUp % 10; // определение последней цифры (остаток от деления на 10 нацело)
            correctCase = switch (lastDigit) {
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
        }
        return correctCase;
    }

}

