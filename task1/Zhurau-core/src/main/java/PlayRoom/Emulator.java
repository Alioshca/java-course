package PlayRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Emulator {

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

    public static boolean isEnoughMoney(double roomMoney, double toysCost)
    {
        double moneyDiff = roomMoney - toysCost;

        if (moneyDiff < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void buyToys(Room room, ToyStore toyStore)
    {
        String toy1 = "toy1";
        String toy2 = "toy2";
        String toy3 = "toy3";
        String[] sortedPriceNames = new String[toyStore.getToys().size()];
        List<String> toysNames = new ArrayList<String>();
        List<Double> toysPrices = new ArrayList<Double>();
        int counter = 0;
        double currentMoney;
        double diff;

        room.addToyToRoom(toy1, toyStore.getToys().get(toy1));
        room.addToyToRoom(toy2, toyStore.getToys().get(toy2));
        room.addToyToRoom(toy3, toyStore.getToys().get(toy3));
        room.setMoneyForToys(room.getMoneyForToys() - ((Double) toyStore.getToys().get(toy1).get("price") + (Double) toyStore.getToys().get(toy2).get("price") + (Double) toyStore.getToys().get(toy3).get("price")));

        toyStore.deleteToys(toy1, toy2, toy3);

        toysNames.addAll(toyStore.getToys().keySet());

        for (String name : toysNames)
        {
            toysPrices.add((Double) toyStore.getToys().get(name).get("price"));
        }

        Collections.sort(toysPrices);

        for (double price : toysPrices)
        {
            for (String name : toysNames)
            {
                if ((Double) toyStore.getToys().get(name).get("price") == price)
                {
                    sortedPriceNames[counter] = name;
                    counter++;
                }
            }
        }

        currentMoney = room.getMoneyForToys();
        counter = 0;
        while (true)
        {
            diff = Math.round((currentMoney - (Double) toyStore.getToys().get(sortedPriceNames[counter]).get("price")) * 100.0) / 100.0;
            if (diff > 0 && counter < sortedPriceNames.length)
            {
                currentMoney = diff;
                room.addToyToRoom(sortedPriceNames[counter], toyStore.getToys().get(sortedPriceNames[counter]));
                toyStore.deleteToys(sortedPriceNames[counter]);
            } else {
                break;
            }
            counter++;
        }
        room.setMoneyForToys(currentMoney);
    }

    public static void startEmulator() throws InterruptedException
    {
        Dialog.dialogStart();
        Dialog.dialogCreateRoom();

        Room testRoom = inputRoomAttr();
        testRoom.showRoomParameters();

        Dialog.dialogCountdown();
        Dialog.dialogCreateToyStore();
        ToyStore testToyStore = Randomizer.createRandomToys(Randomizer.createBasicToys());
        testToyStore.showToyStore("sex", "age", "purpose", "price");

        if (isEnoughMoney(testRoom.getMoneyForToys(), testToyStore.getMinToyCost()) == true)
        {
            Dialog.dialogEnoughMoney(testRoom.getMoneyForToys(), testToyStore.getMinToyCost());
        } else {
            Dialog.dialogNotEnoughMoney(testRoom.getMoneyForToys(), testToyStore.getMinToyCost());
            Dialog.dialogAddMoney(testToyStore.getMinToyCost(), testRoom.getMoneyForToys());
            testRoom.setMoneyForToys(testRoom.getMoneyForToys() + testToyStore.getMinToyCost());
        }

        Dialog.dialogBuyToys();
        buyToys(testRoom, testToyStore);
        testRoom.showRoomParameters();
    }
}