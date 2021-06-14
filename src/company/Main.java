package company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List <Worker> workers = Arrays.asList(
                new Worker("Vasya", 35, 5000, "manager"),
                new Worker("Petya", 26, 2700, "accountant"),
                new Worker("Masha", 57, 1500, "programmer"),
                new Worker("Danya", 57, 9000, "accountant"),
                new Worker("Lena", 35, 8300, "programmer"),
                new Worker("Kasper", 28, 7700, "programmer"),
                new Worker("Barsik", 19, 1900, "manager")
        );

        //1. Поделить рабочих на тех кто зарабатывает меньше 3000 и тех кто зарабатывает больше 3000
        Map<Boolean, List<Worker>> workersBySalary = workers
                .stream()
                .collect(Collectors.partitioningBy(salary -> salary.getSalary() < 3000));
//        System.out.println(workersBySalary);


//        2. Сгруппировать список рабочих по их должности
        Map<String, List<Worker>> workersByPosition = workers
                .stream()
                .collect(Collectors.groupingBy(Worker::getPosition));
//        System.out.println(workersByPosition);

//        3. Подсчитать количество рабочих, занимаемых конкретную должность (counting)
        Long workersCountByPosition = workers
                .stream()
                .filter(worker -> worker.getPosition().equals("programmer")).count();
//        System.out.println(workersCountByPosition);

//        4. Сгруппировать список рабочих по их возрасту, внести в список только тех, кто старше 31.
        Map<Integer, List<Worker>> workersGroupByAge = workers
                .stream()
                .filter(worker -> worker.getAge()>30)
                .collect(Collectors.groupingBy(Worker::getAge));
//        System.out.println(workersGroupByAge);


//        5. Суммировать зарплаты всех работников по должностям
        Map<String,Integer> sumSalariesByPosition = workers
                .stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.summingInt(Worker::getSalary)));
//        System.out.println(sumSalariesByPosition);




    }
}






