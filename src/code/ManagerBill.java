package code;

import java.util.ArrayList;

public class ManagerBill {
    private static ArrayList<Bill> bills = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_COSTUMER_NOT_FOUND = 1;
    public static void addBill(Bill bill){
        bills.add(bill);
    }
    public static int editBill(int i, Long id, ArrayList<Product> products){
        Costumer c;
        c = ManagerCostumer.getCostumer(id);
        if(c == null){
            return VALIDATION_ERROR_COSTUMER_NOT_FOUND;
        }
        Bill b = bills.get(i);
        b.getCostumer().changeTotalSpended(-1*b.getTotalValue());
        b.setTotalValue(0);
        b.clearProducts();
        b.setCostumer(c);
        b.addProducts(products);
        return VALIDATION_SUCCESS;
    }
    public static void deleteBill(int i){
        bills.get(i).getCostumer().changeTotalSpended(-1*bills.get(i).getTotalValue());
        bills.remove(i);
    }
    public static ArrayList<String> getList(){
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for(Bill b : bills){
            a.add((i++)+") cliente: "+b.getCostumer().getName()+" ,fecha: "+b.getDate()+" ,valor total: "+b.getTotalValue()+" ,productos: "+b.getProducts());
        }
        if(i == 1){
            a.add("Aun no hay facturas");
        }
        return a;
    }
    public static ArrayList<String> getBillsByCostumer(Long id){
        int i = 1;
        ArrayList<String> ret = new ArrayList();
        for(Bill b : bills){
            if(b.getCostumer().getID().equals(id)){
                ret.add((i++)+") cliente: "+b.getCostumer().getName()+" fecha: "+b.getDate()+" valor total: "+b.getTotalValue()+" productos: "+b.getProducts());
            }
        }
        if(i == 1){
            ret.add("El cliente con cedula "+id+" aun no tiene facturas");
        }
        return ret;
    }
    public static int getListSize(){
        return bills.size();
    }
}