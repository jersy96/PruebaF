/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jronc
 */
public class ManagerGeneralValidations {
    
    public static String askNumber(String msg) {
        String ret;
        do {
            ret = JOptionPane.showInputDialog(null, msg, "",JOptionPane.PLAIN_MESSAGE);
            if(ret != null){
                try{
                    Double.parseDouble(ret);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Debe digitar un numero", "", JOptionPane.ERROR_MESSAGE);
                    ret = "NaN";
                }
            }
        } while (ret != null && ret.equals("NaN"));
        return ret;
    }

    public static boolean validateIfTableIsNotEmpty(JTable table){
        return table.getRowCount() > 0;
    }
}
