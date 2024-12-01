# Описание приложения "Обработчик студентов"

## Условие задачи
Создать класс Student, содержащий следующие характеристики: имя, группа, курс, оценки по предметам.
<p>
Создать коллекцию, содержащую объекты класса Student.

Написать метод, который удаляет студентов со средним баллом < 3.
Если средний балл >= 3, студент переводится на следующий курс.
<p>
Реализовать метод printStudents(List<Student> students, int course), который получает список студентов и номер курса и выводит в консоль имена тех студентов из списка, которые обучаются на данном курсе.
<p>
	
## Выполнение задания 
<p>
	
> [!IMPORTANT]
> Реализация метода `main`:

```java
public static void main(String[] args) {
    List<Student> students=new ArrayList<>();
    students.add(new Student("Иванов Иван Иванович","ИКП-214", 3));
    students.add(new Student("Соколов Илья Юрьевич","ИПР-214", 1));
    students.add(new Student("Николаев Данил Иванович","ИСТ-214", 2));
    students.add(new Student("Васнецова Дарья Сергеевна","ПКП-214", 4));

    for(Student s: students)
    {
        for (Map.Entry<Subjects, List<Integer>> entry : s.getMarks().entrySet()) {
            Subjects key = entry.getKey();
            List<Integer> marks = s.getMarks().computeIfAbsent(key, k->new ArrayList<>());
            for (int i = 0; i < new Random().nextInt(0, 10); i++) {
                marks.add(new Random().nextInt(2, 6));
            }
            s.getMarks().put(key, marks);
        }
    }
    deleteStudents(students);

}
```
> [__Содержимое класса Student__](src/main/java/mephi/digitalfaculty/Lab1/Student.java) `Student`<br>
> [__Реализация класса Main__](src/main/java/mephi/digitalfaculty/Lab1/Main.java) `Main`<br>
>  [__Реализация класса-перечисления Subjects__](src/main/java/mephi/digitalfaculty/Lab1/Subjects.java) `Subjects`<br>

## Unit-тесты
Тест на геттеры и сеттеры курса:
```java
	@Test
void testSetCourse() {
    Student student = new Student("Иванов Иван", "ИКП-214", 3);
    assertEquals(3, student.getCourse(), "Изначальный курс должен быть 3");
    student.setCourse(4);
    assertEquals(4, student.getCourse(), "Курс должен обновиться до 4");
}
```
Тест на ввод недопустимого курса:
```java
@Test
void testStudentSubjectsForZeroCourse() {
    Student student = new Student("Сидоров Сергей Владимирович", "ИКП-216", 0);

    assertNull(student.getMarks(), "Список предметов должен быть null для недопустимого курса");
}
```
