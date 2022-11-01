package org.example;

public class University{
    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFullNAme(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    @Override
    public String toString() {
        return "id университета " + id + " " + "название университета " + fullName + " " + "сокращенное название " + shortName + " " + "год основания " + yearOfFoundation + " " + "основное направление " + mainProfile;
    }

    public int compareTo(University b) {
        if (this.yearOfFoundation > b.yearOfFoundation) {
            return 1;
        } else if (this.yearOfFoundation < b.yearOfFoundation) {
            return 0;
        } else  {
            return 2;
        }

    }
}
