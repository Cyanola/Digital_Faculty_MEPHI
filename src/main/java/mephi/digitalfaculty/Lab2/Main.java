package mephi.digitalfaculty.Lab2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)
    {
        List<User> users=new ArrayList<>();
        users.add(new User("Иван", "Иванов", 60,"Россия"));
               users.add( new User("Илья", "Чернышов", 20,"Россия"));
           users.add(     new User("Александр", "Белов",15,"Россия"));
               users.add( new User("Георгий", "Петров",10,"Белоруссия"));
             users.add(   new User("Анна", "Иванова", 30,"Казахстан"));
             sortBylastName(users);
             System.out.println("--------------------------------------------------------");
             sortByAge(users);
        System.out.println("--------------------------------------------------------");
        isOlder7(users);
        System.out.println("--------------------------------------------------------");
        AvgAge(users);
        System.out.println("--------------------------------------------------------");
        uniqueCountries(users);

    }
    public static void sortBylastName(List<User> users)
    {
        users.stream().sorted(new UserComparator())
                .forEach(p->System.out.printf("%d %s %s\n",p.getId(),
                        p.getLastName(), p.getFirstName()));
    }
    public static void sortByAge(List<User> users) {
        users.stream()
                .sorted(Comparator.comparingDouble(User::getAge))
                .collect(Collectors.toList()).forEach(p->System.out.printf("%d %s %s %.2f лет\n",p.getId(),
                        p.getLastName(), p.getFirstName(),p.getAge()));
    }
    public static void isOlder7(List<User> users) {
        System.out.println("Все пользователи старше 7 лет: " +
                users.stream()
                .allMatch(user -> user.getAge() > 7));
    }
    public static void AvgAge(List<User> users)
    {
        System.out.println("Средний возраст пользователей: " +
                users.stream().mapToDouble(User::getAge).average());
    }
    public static void uniqueCountries(List<User> users)
    {
        System.out.println("Количество уникальных стран проживания: "
                + users.stream().map(User::getCountry).distinct().count());
        System.out.println("Уникальные страны: " + users.stream().map(User::getCountry).collect(Collectors.toSet()));
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User a, User b){
        return a.getLastName().toUpperCase().compareTo(b.getLastName().toUpperCase());
    }
}
