package org.example;

public class ComparatorR {
    private ComparatorR() {
    }

    public static CourseComp getStudentComparator(StudentEnum studentEnumz) {

        switch (studentEnumz) {

            case Universityid:
                return new UniversityIdComp();
            case Fullname:
                return new FullnameComp();
            case Currentcoursenumber:
                return new CourseComp();
            case Avgexamscore:
                return new StudentAvgExamScoreComparator();
            default:
                return new FullnameComp();
        }
    }


}
