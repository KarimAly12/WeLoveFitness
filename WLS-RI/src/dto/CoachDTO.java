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
public class CoachDTO {
    
    private final String coachid;
    private final  String name;
    private final int age;
    private final String gender;
    private final double salary;

    public CoachDTO(String coachid, String name, int age, String gender, double salary) {
        this.coachid = coachid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getCoachid() {
        return coachid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }
    
    
    
    
    
    
}
