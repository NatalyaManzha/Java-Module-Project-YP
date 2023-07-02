import java.util.Scanner;

class Nomenclature { // класс для записи нового товара
    String name;
    double price;

    public String checkName(String x) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextLine();
            if (x.isEmpty()) {
                System.out.println("Введите название товара.");
            } else
                break;
        }
        return x;
    }

    public double checkPrice(double x) { // метод для проверки корректности ввода цены
        while (x ==0) {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextDouble()) System.out.println("Ошибка ввода. Введите цену товара в формате \"рубли,копейки\""); // если ввод текста вместо числа или "." вместо ","
            else {
                x = scanner.nextDouble();
                if (x <= 0) {
                    System.out.println("Введите цену товара в формате \"рубли,копейки\"");
                    x = 0;
                }
            }
        }
        return x;
    }
}
