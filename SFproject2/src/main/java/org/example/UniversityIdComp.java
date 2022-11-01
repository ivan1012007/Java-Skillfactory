package org.example;

public class UniversityIdComp implements StudentComp {

    @Override
    public int compareTo(Student o1, Student o2) {
        return 0;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
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
