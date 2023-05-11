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
public class MembershipDTO {
    
    private final String name;
    private final Double price;
    private final Integer length;
    private final String description;

    public String getName() {
        return name;
    }

   

    

    public Double getPrice() {
        return price;
    }

    

    public Integer getLength() {
        return length;
    }

   

    public String getDescription() {
        return description;
    }

   

    public MembershipDTO(String name, Double price, Integer length, String description) {
        this.name = name;
        this.price = price;
        this.length = length;
        this.description = description;
    }
    
    
    
}
