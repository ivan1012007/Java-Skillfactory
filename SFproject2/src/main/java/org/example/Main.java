package org.example;
import java.util.*;
import java.util.Set;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComp studentComparator =
                ComparatorR.getStudentComparator(StudentEnum.Avgexamscore);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });
    }
}