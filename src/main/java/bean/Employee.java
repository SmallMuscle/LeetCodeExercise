package bean;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee() {}

    public Employee(int id, int importance, int ... subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = new ArrayList<>();
        for (int i : subordinates) {
            this.subordinates.add(i);
        }
    }
}
