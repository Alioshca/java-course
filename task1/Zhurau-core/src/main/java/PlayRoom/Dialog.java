package PlayRoom;


public class Dialog {

    public static void dialogCountdown() throws InterruptedException
    {
        for (int i = 1; i < 3; i++)
        {
            System.out.print(i + "..");
            Thread.sleep(1000);
        }

        System.out.print("3\n");
        System.out.println("Готово!\n");
    }

    public static void dialogStart()
    {
        System.out.println("Приветствую вас в конструкторе игровых комнат!\n");
        System.out.println("В системе присутствуют 2 основные сущности:\n1) Игровая комната, параметры для которой вам предстоит задать самостоятельно;\n2) Магазин игрушек, который система сгенерирует автоматически.\n");
        System.out.println("Игровая комната будет признана готовой к работе, если:\n- Пользователь системы введёт корректные значения атрибутов комнаты;\n- Денежной суммы будет хватать на закупку товара\nхотя бы 2 разновидностей в рамках 1 категории в магазине игрушек;\n- В магазине игрушек имеются товары хотя бы 2 разновидностей в рамках 1 категории\n(например, по половому признаку должна быть\nхотя бы 1 игрушка для мальчиков и хотя бы 1 для девочек);\n");
        System.out.println("Игровая комната обладает следующими атрибутами:\n- Вместимость игровой комнаты (целое число от 1 и выше);\n- Денежная сумма на закупку игрушек (число выше 0);\n- Стоимость 1 часа пребывания в комнате для 1 посетителя (число выше 0);\n");
    }

    public static void dialogCreateRoom() throws InterruptedException
    {
        System.out.println("Давайте вместе создадим игровую комнату!\n");
    }

    public static void dialogCreateToyStore() throws InterruptedException
    {
        System.out.println("Ваша игровая комната готова, но играть в ней пока не с чем.\n");
        System.out.println("Давайте это исправим.\nСейчас программа сгенерирует для вас магазин игрушек.\n");

        dialogCountdown();
    }

    public static void dialogBuyToys() throws InterruptedException
    {
        System.out.println("Производим покупку игрушек.");

        dialogCountdown();
    }

    public static void dialogNotEnoughMoney(double currentMoney, double toysCost)
    {
        double diffMoney = Math.round((toysCost - currentMoney) * 100.0) / 100.0;
        System.out.println("Минимальный набор игрушек стоит " + toysCost + " у.е.");
        System.out.println("У вас на счету сейчас " + currentMoney + " у.е.");
        System.out.println("Для покупки игрушек вам не хватает " + diffMoney + " у.е.");
    }

    public static void dialogEnoughMoney(double currentMoney, double toysCost) throws InterruptedException
    {
        System.out.println("Минимальный набор игрушек стоит " + toysCost + " у.е.");
        System.out.println("У вас на счету сейчас " + currentMoney + " у.е.");
        System.out.println("Этого достаточно для покупки минимального набора игрушек!");
    }

    public static void dialogAddMoney(double addedMoney, double currentMoney) throws InterruptedException
    {
        double updatedMoney = Math.round((currentMoney + addedMoney) * 100.0) / 100.0;
        
        System.out.println("Добавляем к вашей сумме " + addedMoney + " у.е.");

        dialogCountdown();

        System.out.println("Теперь у вас на счету " + updatedMoney + " у.е.");
    }
    
}