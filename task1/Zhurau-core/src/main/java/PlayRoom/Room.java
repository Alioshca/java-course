package PlayRoom;

import java.util.HashMap;
import java.util.Map;

public class Room {
    
    private int kidsNumber;
    private double moneyForToys;
    private double hourCost;
    private Map<String, Map> roomToys;
    Map<String, Map> baseToys = new HashMap<String, Map>();

    public Room(int kidsNumber, double moneyForToys, double hourCost, Map<String, Map> roomToys)
    {
        this.kidsNumber = kidsNumber;
        this.moneyForToys = moneyForToys;
        this.hourCost = hourCost;
        this.roomToys = roomToys;
    }

    public Room(int kidsNumber, double moneyForToys, double hourCost)
    {
        this.kidsNumber = kidsNumber;
        this.moneyForToys = moneyForToys;
        this.hourCost = hourCost;
        this.roomToys = this.baseToys;
    }

    public Room()
    {
        this.kidsNumber = 10;
        this.moneyForToys = 199.99;
        this.hourCost = 20.0;
        this.roomToys = this.baseToys;
    }

    public int getKidsNumber()
    {
        return this.kidsNumber;
    }

    public double getMoneyForToys()
    {
        return this.moneyForToys;
    }

    public double getHourCost()
    {
        return this.hourCost;
    }

    public Map<String, Map> getRoomToys()
    {
        return this.roomToys;
    }

    public void setKidsNumber(int kidsAdded)
    {
        if (kidsAdded >= 0)
        {
            this.kidsNumber = kidsAdded;
        } else {
            System.out.println("Количество детей не может быть отрицательным, попробуйте снова.");
        }
    }

    public void setMoneyForToys(double money)
    {
        if (money >= 0)
        {
            this.moneyForToys = Math.round(money * 100.0) / 100.0;
        } else {
            System.out.println("Стоимость не может быть отрицательной, попробуйте снова.");
        }
    }

    public void setHourCost(double money)
    {
        if (money >= 0)
        {
            this.moneyForToys = Math.round(money * 100.0) / 100.0;
        } else {
            System.out.println("Стоимость не может быть отрицательной, попробуйте снова.");
        }
    }

    public void setRoomToys(Map<String, Map> toysAdded)
    {
        this.roomToys = toysAdded;
    }

    public void addToyToRoom(String toyName, Map<String, String> toyAttrs)
    {
        this.roomToys.put(toyName, toyAttrs);
    }

    public void showRoomParameters()
    {
        System.out.println("Вместимость комнаты: " + this.kidsNumber + " детей.");
        System.out.println("Денежная сумма на закупку игрушек: " + this.moneyForToys + " у.е.");
        System.out.println("Стоимость 1 часа пребывания в комнате для 1 посетителя: " + this.hourCost + " у.е.");
        System.out.println("Игрушки в комнате:");
        System.out.println(this.roomToys);
    }

}