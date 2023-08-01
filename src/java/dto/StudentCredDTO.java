/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Shreyanshi
 */
public class StudentCredDTO
{
    private String roll_no;
    private String name;
    public StudentCredDTO(){
        
    }

    @Override
    public String toString() {
        return "StudentCredDTO{" + "roll_no=" + roll_no + ", name=" + name + '}';
    }

    public StudentCredDTO(String roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
