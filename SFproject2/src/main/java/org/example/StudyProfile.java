package org.example;

public enum StudyProfile {
    Medicina ("Медицина"),
    Pravo ("Право"),
    Economica("Экономика"),
    Management("Менеджмент");
    private String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){
        return profileName;
    }
    @Override
    public String toString(){
        return profileName;
    }
}
