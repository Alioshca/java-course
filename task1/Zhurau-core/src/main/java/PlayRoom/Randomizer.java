package PlayRoom;

import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class Randomizer {

    private static String ranSex()
    {
        String[] toyAttrSex = new String[] {"boys", "girls", "neutral"};
        int ranIndex = (int) (Math.random() * 3);

        return toyAttrSex[ranIndex];
    }

    private static String ranAge()
    {
        String[] toyAttrAge = new String[] {"toddler", "preschool", "school"};
        int ranIndex = (int) (Math.random() * 3);

        return toyAttrAge[ranIndex];
    }

    private static String ranPurpose()
    {
        String[] toyAttrPurpose = new String[] {"puzzle", "educational", "sport"};
        int ranIndex = (int) (Math.random() * 3);

        return toyAttrPurpose[ranIndex];
    }

    private static double ranPrice(double initMin)
    {
        initMin += 0.1;
        double initMax = (initMin + 99.9);
        double ranNum = Math.round((((Math.random() * (initMax - initMin)) + initMin) * 100.0)) / 100.0 ;
        return ranNum;
    }

    private static double ranPrice()
    {
        double initMin = 0.1;
        double initMax = 100.0;

        double ranNum = Math.round((((Math.random() * (initMax - initMin)) + initMin) * 100.0)) / 100.0 ;
        return ranNum;
    }

    private static int ranQuan()
    {
        int initMin = 10;
        int initMax = 30;

        int ranNum = (int) ((Math.random() * (initMax - initMin)) + initMin);
        return ranNum;
    }

    public static Map<String, Map> createBasicToys()
    {
        Map<String, Map> toysStorage = new HashMap<String, Map>();
        Map<String, Object> baseToyOne = new HashMap<String, Object>();
        Map<String, Object> baseToyTwo = new HashMap<String, Object>();
        Map<String, Object> baseToyThree = new HashMap<String, Object>();

        baseToyOne.put("sex", "boys");
        baseToyOne.put("age", "toddler");
        baseToyOne.put("purpose", "puzzle");
        baseToyOne.put("price", ranPrice());

        baseToyTwo.put("sex", "girls");
        baseToyTwo.put("age", "preschool");
        baseToyTwo.put("purpose", "educational");
        baseToyTwo.put("price", ranPrice());

        baseToyThree.put("sex", "neutral");
        baseToyThree.put("age", "school");
        baseToyThree.put("purpose", "sport");
        baseToyThree.put("price", ranPrice());

        toysStorage.put("toy1", baseToyOne);
        toysStorage.put("toy2", baseToyTwo);
        toysStorage.put("toy3", baseToyThree);

        return toysStorage;
    }

    public static ToyStore createRandomToys(Map<String, Map> toysStorage)
    {
        int maxToys = ranQuan();
        double initialCost;

        initialCost = Double.max((double) toysStorage.get("toy1").get("price"), Double.max((double) toysStorage.get("toy2").get("price"), (double) toysStorage.get("toy3").get("price")));

        for (int i = 0; i < maxToys; i++)
        {
            Map<String, Object> oneToy = new HashMap<String, Object>();
            String toyName = "toy" + (i + 4);

            oneToy.put("sex", ranSex());
            oneToy.put("age", ranAge());
            oneToy.put("purpose", ranPurpose());
            oneToy.put("price", ranPrice(initialCost));

            toysStorage.put(toyName, oneToy);
        }

        ToyStore testToys = new ToyStore(toysStorage);
        testToys.setMinToyCost((double) toysStorage.get("toy1").get("price") + (double) toysStorage.get("toy2").get("price") + (double) toysStorage.get("toy3").get("price"));

        return testToys;
    }
}