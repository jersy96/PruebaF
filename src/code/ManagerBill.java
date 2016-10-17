package code;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerBill {

    private static final ArrayList<Bill> bills = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_COSTUMER_NOT_FOUND = 1;

    public static void addBill(Bill bill) {
        bills.add(bill);
    }

    public static int editBill(int i, Long id, ArrayList<Product> products) {
        Costumer c;
        c = ManagerCostumer.getCostumerDeepCopy(id);
        if (c == null) {
            return VALIDATION_ERROR_COSTUMER_NOT_FOUND;
        }
        Bill b = bills.get(i);
        b.getCostumer().changeTotalSpended(-1 * b.getTotalValue());
        b.setTotalValue(0);
        b.clearProducts();
        b.setCostumer(c);
        b.addProducts(products);
        return VALIDATION_SUCCESS;
    }

    public static void deleteBill(int i) {
        bills.get(i).getCostumer().changeTotalSpended(-1 * bills.get(i).getTotalValue());
        bills.remove(i);
    }

    public static ArrayList<HashMap<String, String>> getList() {
        ArrayList<HashMap<String, String>> a = new ArrayList();
        HashMap<String, String> hm;
        int i = 1;
        for (Bill b : bills) {
            hm = new HashMap();
            hm.put("Numero", "" + (i++));
            hm.put("Nombre Cliente", b.getCostumer().getName());
            hm.put("Cedula Cliente", b.getCostumer().getID().toString());
            hm.put("Fecha", b.getDate());
            hm.put("Valor Factura", b.getTotalValue() + "");
            a.add(hm);
        }
        if (i == 1) {
            hm = new HashMap();
            hm.put("", "Aun no hay Facturas");
            a.add(hm);
        }
        return a;
    }

    public static ArrayList<String> getListOfProductsByBill() {
        ArrayList<String> ret = new ArrayList();
        for (Bill b : bills) {
            String s = "";
            for (Product p : b.getProducts()) {
                s += p.getCode().toString()+ "     ->    "+p.getName()+"\n";
            }
            ret.add(s);
        }
        return ret;
    }

    public static ArrayList<HashMap<String, String>> getBillsByCostumer(Long id) {
        ArrayList<HashMap<String, String>> a = new ArrayList();
        HashMap<String, String> hm;
        int i = 1;
        if (ManagerCostumer.validateIfIdIsUsed(id)) {
            for (Bill b : bills) {
                if (b.getCostumer().getID().equals(id)) {
                    hm = new HashMap();
                    hm.put("Numero", "" + (i++));
                    hm.put("Nombre Cliente", b.getCostumer().getName());
                    hm.put("Cedula Cliente", b.getCostumer().getID().toString());
                    hm.put("Fecha", b.getDate());
                    hm.put("Valor Factura", b.getTotalValue() + "");
                    a.add(hm);
                }
            }
            if (i == 1) {
                hm = new HashMap();
                hm.put("", "El cliente un no tiene Facturas");
                a.add(hm);
            }
        } else {
            hm = new HashMap();
            hm.put("", "La cedula no corresponde a ningun cliente");
            a.add(hm);
        }
        return a;
    }

    public static int getListSize() {
        return bills.size();
    }
}
