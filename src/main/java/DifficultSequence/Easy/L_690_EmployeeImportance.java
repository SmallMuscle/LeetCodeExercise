package DifficultSequence.Easy;

import bean.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class L_690_EmployeeImportance {

    /*
        You are given a data structure of employee information, which includes the
        employee's unique id, his importance value and his direct subordinates' id.

        For example, employee 1 is the leader of employee 2, and employee 2 is the
        leader of employee 3. They have importance value 15, 10 and 5, respectively.
        Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
        [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3
        is also a subordinate of employee 1, the relationship is not direct.

        Now given the employee information of a company, and an employee id, you need
        to return the total importance value of this employee and all his subordinates.

        Example 1:
            Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
            Output: 11
            Explanation:
            Employee 1 has importance value 5, and he has two direct subordinates: employee
            2 and employee 3. They both have importance value 3. So the total importance
            value of employee 1 is 5 + 3 + 3 = 11.

        Note:
            One employee has at most one direct leader and may have several subordinates.
            The maximum number of employees won't exceed 2000.

     */

    public static void main(String[] args) {
        L_690_EmployeeImportance l = new L_690_EmployeeImportance();
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(1, 5, 2, 3);
        Employee employee2 = new Employee(2, 3);
        Employee employee3 = new Employee(3, 3);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println(l.getImportance(list, 1));
    }

    public int getImportance(List<Employee> employees, int id) {
        return getImportance1(employees, id);
    }

    public int getImportance1(List<Employee> employees, int id) {
        Employee[] es = new Employee[2001];
        for (Employee e : employees) {
            es[e.id] = e;
        }
        return getAllImportance2(es, id);
    }

    private int getAllImportance1(Map<Integer, Employee> map, int id) {
        Employee lead = map.get(id);
        int sum = lead.importance;
        for (Integer subId : lead.subordinates) {
            sum += getAllImportance1(map, subId);
        }
        return sum;
    }

    private int getAllImportance2(Employee[] es, int id) {
        Employee lead = es[id];
        int sum = lead.importance;
        for (Integer subId : lead.subordinates) {
            sum += getAllImportance2(es, subId);
        }
        return sum;
    }
}
