import java.util.Scanner;

class Nomenclature { // класс для записи нового товара
    String name;
    double price;

    public String checkName() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Введите название товара.");
            } else
                break;
        }
        return name;
    }

    public double checkPrice() { // метод для проверки корректности ввода цены
        while (price ==0) {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextDouble()) System.out.println("Ошибка ввода. Введите цену товара в формате \"рубли,копейки\""); // если ввод текста вместо числа или "." вместо ","
            else {
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Введите цену товара в формате \"рубли,копейки\"");
                    price = 0;
                }
            }
        }
        return price;
    }
}
