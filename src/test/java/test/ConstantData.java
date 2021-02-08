/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author p.krupitsa
 */
public class ConstantData {
    
   private String mnemo;
   private String value;
   private String periodicalDate;
   
   public ConstantData(String mnemo, String value) {
        this.mnemo = mnemo;
        this.value = value;
    }
     
   public ConstantData(String mnemo, String value, String periodicalDate) {
        this.mnemo = mnemo;
        this.value = value;
        this.periodicalDate = periodicalDate;
    }


    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPeriodicalDate() {
        return periodicalDate;
    }

    public void setPeriodicalDate(String periodicalDate) {
        this.periodicalDate = periodicalDate;
    }

  
    
}
