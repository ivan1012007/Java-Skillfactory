package org.example;

public class Student {
    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;

    public Student(String universityId, String fullName, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "студент " + fullName + " " + "id университета " + universityId + " " + "номер курса " + currentCourseNumber + " " + "средний балл за экзамены " + avgExamScore;
    }

    public int compareTo(Student o) {
        if (this.currentCourseNumber > o.currentCourseNumber){
            return 1; } else if (this.currentCourseNumber < o.currentCourseNumber) {
            return 0; } else {return 2;}
    }
}