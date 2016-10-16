/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import javax.swing.JOptionPane;

/**
 *
 * @author jronc
 */
public class ManagerGeneralValidations {
    
    public static String askNumber(String msg) {
        String s;
        s = JOptionPane.showInputDialog(null, msg, "",JOptionPane.PLAIN_MESSAGE);
        if(s == null){
            return null;
        }else{
            try{
                double dob = Double.parseDouble(s);
                return s;
            }catch(NumberFormatException e){
                return "NaN";
            }
        }
    }

    @Override
    public String toString() {
        return "ManagerGeneralValidations{" + '}';
    }
}
