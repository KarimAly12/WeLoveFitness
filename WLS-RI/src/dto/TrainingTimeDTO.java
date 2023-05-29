/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author karimosama
 */
public class TrainingTimeDTO {
    private final String coachName;
    private  final String gender;
    private final int age;
    private final String time;
    private final String date;

    public String getCoachName() {
        return coachName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public TrainingTimeDTO(String coachName, String gender, int age, String time, String date) {
        this.coachName = coachName;
        this.gender = gender;
        this.age = age;
        this.time = time;
        this.date = date;
    }
    
}
