package org.example;

public class CompareStudentsCourse implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.avgExamScore > o2.avgExamScore) {
            return 1;
        } else if (o1.avgExamScore < o2.avgExamScore) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Student o1, Student o2) {
        if (o1.currentCourseNumber > o2.currentCourseNumber) {
            return 1;
        } else if (o1.currentCourseNumber < o2.currentCourseNumber) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compar(Student o1, Student o2) {
        if (o1.fullName == o2.fullName) {
            return 0;
        } else {
            return 1;
        }
    }
    @Override
    public int compare1(Student o1, Student o2){
        int a , a1;
        a = Integer.parseInt(o1.universityId);
        a1 = Integer.parseInt(o2.universityId);
        if (a > a1) { return 1;} else if (a < a1) {return -1;}
        else {return 0;}
    }
}

