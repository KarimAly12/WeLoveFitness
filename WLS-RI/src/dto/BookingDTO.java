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
public class BookingDTO {
    private final String memberEmail;
    private final String time;
    private final String date;

    public BookingDTO(String memberEmail, String time, String date) {
        this.memberEmail = memberEmail;
        this.time = time;
        this.date = date;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
    
    
    
}
