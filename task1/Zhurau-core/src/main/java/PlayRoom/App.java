package PlayRoom;

import java.util.Scanner;

public class App 
{
    private static void startTalk()
    {
        System.out.println("Приветствую вас в конструкторе игровых комнат!\n");
        System.out.println("В системе присутствуют 2 основные сущности:\n1) Игровая комната, параметры для которой вам предстоит задать самостоятельно;\n2) Магазин игрушек, который система сгенерирует автоматически.\n");
        System.out.println("Игровая комната будет признана готовой к работе, если:\n- Пользователь системы введёт корректные значения атрибутов комнаты;\n- Денежной суммы будет хватать на закупку товара\nхотя бы 2 разновидностей в рамках 1 категории в магазине игрушек;\n- В магазине игрушек имеются товары хотя бы 2 разновидностей в рамках 1 категории\n(например, по половому признаку должна быть\nхотя бы 1 игрушка для мальчиков и хотя бы 1 для девочек);\n");
        System.out.println("Игровая комната обладает следующими атрибутами:\n- Вместимость игровой комнаты (целое число от 1 и выше);\n- Денежная сумма на закупку игрушек (число выше 0);\n- Стоимость 1 часа пребывания в комнате для 1 посетителя (число выше 0);\n");
        System.out.println("Давайте вместе создадим игровую комнату!\n");
    }

    private static Room inputRoomAttr()
    {
        Scanner in = new Scanner(System.in);
        int inKidsNumber = 0;
        double inMoneyForToys = 0.0;
        double inHourCost = 0.0;
        boolean kidsNumberStatus = false;
        boolean moneyForToysStatus = false;
        boolean hourCostStatus = false;

        System.out.println("Введите кодичество детей, которое может вместить игровая комната\n(целое число от 1 и выше): ");
        while (!kidsNumberStatus) {
            try {
                inKidsNumber = Integer.valueOf(in.nextLine().trim());
                if (inKidsNumber < 1){
                    System.out.println("Введите целое число от 1 и выше: ");
                    continue;
                }
                kidsNumberStatus = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число от 1 и выше: ");
            }
        }
        
        System.out.println("Введите денежную сумму на закупку игрушек (число выше 0):");
        while (!moneyForToysStatus) {
            try {
                inMoneyForToys = Double.valueOf(in.nextLine().trim());
                if (inMoneyForToys <= 0){
                    System.out.println("Введите число выше 0: ");
                    continue;
                }
                moneyForToysStatus = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите число выше 0: ");
            }
        }

        System.out.println("Введите стоимость 1 часа пребывания в комнате для 1 посетителя (число выше 0):");
        while (!hourCostStatus) {
            try {
                inHourCost = Double.valueOf(in.nextLine().trim());
                if (inHourCost <= 0){
                    System.out.println("Введите число выше 0: ");
                    continue;
                }
                hourCostStatus = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите число выше 0: ");
            }
        }
        in.close();
        return new Room(inKidsNumber, inMoneyForToys, inHourCost);
    }

    public static void main( String[] args )
    {
        startTalk();
        Room testRoom = inputRoomAttr();

        System.out.println("Отлично! Вы создали игровую комнату со следующими параметрами: ");
        testRoom.showRoomParameters();

        
    }
}