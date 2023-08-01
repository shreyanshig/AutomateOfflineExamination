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
public class Subjects
{
    private String roll_no;
    private String s;
    private String d;
    public Subjects(){
        
    }

    public Subjects(String roll_no, String s, String d) {
        this.roll_no = roll_no;
        this.s = s;
        this.d = d;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Subjects{" + "roll_no=" + roll_no + ", s=" + s + ", d=" + d + '}';
    }
}
