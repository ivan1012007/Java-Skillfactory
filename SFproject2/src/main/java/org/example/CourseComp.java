package org.example;

    public class CourseComp implements StudentComp {

        @Override
        public int compareTo(Student o1, Student o2) {
            return 0;
        }

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
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

