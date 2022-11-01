package org.example;
public class StudentAvgExamScoreComparator implements StudentComp {

    @Override
    public int compareTo(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    @Override
    public int compar(Student o1, Student o2) {
        return 0;
    }

    @Override
    public int compare1(Student o1, Student o2) {
        return 0;
    }
}