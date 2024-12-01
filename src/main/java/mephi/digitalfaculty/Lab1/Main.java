package mephi.digitalfaculty.Lab1;

import java.util.*;

public class Main {

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
    public static void deleteStudents(List<Student> studentList)
    {
        double avg=0;
        double sum=0;
        double sumsub=0;
        double avgsub=0;
        int subjectCount=0;
        int voidSubjects=0;
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            printStudents(studentList,s.getCourse());
            for (var entry : s.getMarks().entrySet()) {

              avg=0;
                sum=0;
                 sumsub=0;
                 avgsub=0;
                 subjectCount=0;
                 voidSubjects=0;
               Subjects subject = entry.getKey();
               List<Integer> marks = entry.getValue();
                if (marks == null || marks.isEmpty()) {
                    System.out.printf("Предмет '%s' у студента '%s' не имеет оценок.%n",
                            s.getSubs(entry.getKey()), s.getName());
                    subjectCount++;
                    voidSubjects++;
                    continue;
                }
                for (int mark : marks) {
                    sumsub += mark;
                }

                 avgsub = sumsub / (double) marks.size();

                System.out.printf("Оценки по предмету '%s': %s%n", s.getSubs(subject), marks);
                System.out.printf("Средний балл по предмету '%s': %.2f%n", s.getSubs(subject), avgsub);

                    sum += avgsub;
                subjectCount++;

                }
            if (subjectCount > 0) {
                if(voidSubjects==0)
                {
                    avg = sum / subjectCount;
                }
                else {
                  avg=sum/(subjectCount-voidSubjects);
                }
                System.out.printf("Средний балл студента '%s' (%s): %.2f%n", s.getName(), s.getGroup(), avg);

                if (avg < 3.0) {
                    System.out.printf("Студент '%s' (%s) отчислен из-за низкой успеваемости.%n", s.getName(), s.getGroup());
                    iterator.remove();
                } else {
                    if (s.getCourse() != 4) {
                        s.setCourse(s.getCourse() + 1);
                        System.out.printf("Студент '%s' (%s) переведён на следующий курс: %d.%n", s.getName(), s.getGroup(), s.getCourse());
                    }
                    else{
                        System.out.printf("Студент '%s' '%d' курса (%s) завершил обучение", s.getName(), s.getCourse(), s.getGroup());

                    }
                }
            }
            else {
                System.out.printf("Студент '%s' (%s) не имеет оценок ни по одному предмету и не может быть обработан.%n",
                        s.getName(), s.getGroup());
            }
        }}

    public static void printStudents(List<Student> students, int course)
    {
        for (Student s: students)
        {
            if (s.getCourse()==course){
                System.out.println(s.getName());
            }
        }
    }
}