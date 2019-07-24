package leetcode;

import java.util.List;

public class Problem_690_Employee_Importance {


// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};



    public int getImportance(List<Employee> employees, int id) {
        int[] indexes = new int[2001];

        int index = 0;
        for(Employee emp: employees) {
            indexes[emp.id] = index;
            index++;
        }

        return DFS(employees, id, indexes);

    }

    private int DFS(List<Employee> employees, int id, int[] indexes) {
        Employee emp = employees.get(indexes[id]);

        int count = emp.importance;

        for(int subId: emp.subordinates) {
            count += DFS(employees, subId, indexes);
        }

        return count;

    }
}