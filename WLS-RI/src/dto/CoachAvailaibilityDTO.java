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
public class CoachAvailaibilityDTO {
    
    
    private final Integer AvaliID;
    private final String COACHID;
    private final String DATE;
    private final String TIME;

    public int getAvaliID() {
        return AvaliID;
    }

    public String getCOACHID() {
        return COACHID;
    }

    public String getDATE() {
        return DATE;
    }

    public String getTIME() {
        return TIME;
    }

    public CoachAvailaibilityDTO(Integer AvaliID, String COACHID, String DATE, String TIME) {
        this.AvaliID = AvaliID;
        this.COACHID = COACHID;
        this.DATE = DATE;
        this.TIME = TIME;
    }
    
    
    
}
