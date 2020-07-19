package PlayRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ToyStore {

    private Map<String, Map> toys;
    private double minToyCost;

    public ToyStore(Map<String, Map> toys) {
        this.toys = toys;
    }

    public double getMinToyCost()
    {
        return this.minToyCost;
    }

    public Map<String, Map> getToys()
    {
        return this.toys;
    }

    public void addToys(String key, Map value) {
        this.toys.put(key, value);
    }

    public void setToys(Map<String, Map> toysToSet) {
        this.toys = toysToSet;
    }

    public void setMinToyCost(double cost) {

        if (cost >= 0)
        {
            this.minToyCost = Math.round(cost * 100.0) / 100.0;
        } else {
            System.out.println("Стоимость не может быть отрицательной, попробуйте снова.");
        }
    }

    public void deleteToys(String... toysToDelete)
    {
        for (int i = 0; i < toysToDelete.length; i++)
        {
            this.toys.remove(toysToDelete[i]);
        }
    }

    public void showToyStore(String... attrs) {

        List<String> toysNames = new ArrayList<String>();

        toysNames.addAll(this.toys.keySet());
        Collections.sort(toysNames);

        for (int i = 0; i < toysNames.size(); i++)
        {
            System.out.println("<< " + toysNames.get(i) + " >>");

            for (int j = 0; j < attrs.length; j++)
            {
                System.out.println("-- " + attrs[j] + " = " + this.toys.get(toysNames.get(i)).get(attrs[j]));
            }
        }
    }

    public void showToyStore()
    {
        System.out.println(this.toys);
    }
}