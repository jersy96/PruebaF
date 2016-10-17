package code;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ManagerBill {

    private static final ArrayList<Bill> bills = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_COSTUMER_NOT_FOUND = 1;

    public static void addBill(Bill bill) {
        bills.add(bill);
    }

    public static void editBill(int i, Long id, ArrayList<Product> products) {
        Costumer c;
        c = ManagerCostumer.getCostumerDeepCopy(id);
        Bill b = bills.get(i);
        b.getCostumer().changeTotalSpended(-1 * b.getTotalValue());
        b.setTotalValue(0);
        b.clearProducts();
        b.setCostumer(c);
        b.addProducts(products);
    }

    public static void deleteBill(int i) {
        bills.get(i).getCostumer().changeTotalSpended(-1 * bills.get(i).getTotalValue());
        bills.remove(i);
    }

    public static ArrayList<LinkedHashMap<String, String>> getList() {
        ArrayList<LinkedHashMap<String, String>> a = new ArrayList();
        LinkedHashMap<String, String> hm;
        int i = 1;
        for (Bill b : bills) {
            hm = new LinkedHashMap();
            hm.put("Numero", "" + (i++));
            hm.put("Nombre Cliente", b.getCostumer().getName());
            hm.put("Cedula Cliente", b.getCostumer().getID().toString());
            hm.put("Fecha", b.getDate());
            hm.put("Valor Factura", b.getTotalValue() + "");
            a.add(hm);
        }
        return a;
    }

    public static ArrayList<ArrayList<Product>> getListOfProductsByBill() {
        ArrayList<ArrayList<Product>> ret = new ArrayList();
        for (Bill b : bills) {
            ret.add(b.getProducts());
        }
        return ret;
    }

    public static ArrayList<LinkedHashMap<String, String>> getBillsByCostumer(Long id) {
        ArrayList<LinkedHashMap<String, String>> a = new ArrayList();
        LinkedHashMap<String, String> hm;
        int i = 1;
        if (ManagerCostumer.validateIfIdIsUsed(id)) {
            for (Bill b : bills) {
                if (b.getCostumer().getID().equals(id)) {
                    hm = new LinkedHashMap();
                    hm.put("Numero", "" + (i++));
                    hm.put("Nombre Cliente", b.getCostumer().getName());
                    hm.put("Cedula Cliente", b.getCostumer().getID().toString());
                    hm.put("Fecha", b.getDate());
                    hm.put("Valor Factura", b.getTotalValue() + "");
                    a.add(hm);
                }
            }
        }
        return a;
    }

    public static int getListSize() {
        return bills.size();
    }
}
