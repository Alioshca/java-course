package PlayRoom;


public class Room {
    private int kidsNumber;
    private double moneyForToys;
    private double hourCost;

    public Room(int kidsNumber, double moneyForToys, double hourCost)
    {
        this.kidsNumber = kidsNumber;
        this.moneyForToys = moneyForToys;
        this.hourCost = hourCost;
    }

    public void showRoomParameters()
    {
        System.out.println("Вместимость комнаты: " + this.kidsNumber + " детей.");
        System.out.println("Денежная сумма на закупку игрушек: " + this.moneyForToys + ".");
        System.out.println("Стоимость 1 часа пребывания в комнате для 1 посетителя: " + this.hourCost + ".");
    }
}