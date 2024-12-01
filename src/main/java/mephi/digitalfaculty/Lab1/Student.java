package mephi.digitalfaculty.Lab1;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class  Student{
    String name;
    String group;
    int course;
    Map<Subjects, List<Integer>> marks;

    public String getSubs(Subjects subjects) {
        switch(subjects){
            case Databases: return "Базы данных";
            case TechProg: return "Технология программирования";
            case Interfaces: return "Форматы и интерфейсы обмена данными";
            case Physics: return "Физика";
            case Math: return "Математика";
            case II: return "Интеллектуальные системы и технологии";
            case WEB: return "Web-технологии";
            case TIPIS: return "Теория информационных процессов и систем";
            case AIS: return "Архитектура информационных систем";
            case ECM: return "Архитектура и организация ЭВМ";

            default: return "Undefined";
        }
    }
        public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.marks=new HashMap<>();
        if(course>0 &&course<=4) {
            this.course = course;
            switch (course) {
                case 1:
                    this.marks.put(Subjects.Physics, null);
                    this.marks.put(Subjects.Math, null);
                    this.marks.put(Subjects.ECM, null);
                    break;
                case 2:
                    this.marks.put(Subjects.Databases, null);
                    this.marks.put(Subjects.AIS, null);
                    this.marks.put(Subjects.TIPIS, null);
                    this.marks.put(Subjects.Math, null);
                    break;

                case 3:
                    this.marks.put(Subjects.WEB, null);
                    this.marks.put(Subjects.TechProg, null);
                    break;

                case 4:
                    this.marks.put(Subjects.Interfaces, null);
                    this.marks.put(Subjects.II, null);
                    break;
            }
        }
        else {
            System.out.println("Курс должен быть 1-4");
        }
    }
}