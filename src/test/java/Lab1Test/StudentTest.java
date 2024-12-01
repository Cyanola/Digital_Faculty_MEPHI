package Lab1Test;

import mephi.digitalfaculty.Lab1.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    void testSetCourse() {
        Student student = new Student("Иванов Иван", "ИКП-214", 3);
        assertEquals(3, student.getCourse(), "Изначальный курс должен быть 3");

        student.setCourse(4);
        assertEquals(4, student.getCourse(), "Курс должен обновиться до 4");
    }
    @Test
    void testStudentSubjectsForZeroCourse() {
        Student student = new Student("Сидоров Сергей Владимирович", "ИКП-216", 0);

        assertNull(student.getMarks(), "Список предметов должен быть null для недопустимого курса");
    }
}
