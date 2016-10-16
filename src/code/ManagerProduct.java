package code;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerProduct {

    private static final ArrayList<Product> products = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_NAME_USED = 1;
    public static final int VALIDATION_ERROR_CODE_USED = 2;
    public static final int VALIDATION_ERROR_CODE_NOT_FOUND = -1;

    private static Product getProductShallowCopy(int i) {
        Product p = products.get(i);
        return new Product(p.getName(), p.getCode(), p.getPrice());
    }
    
    public static HashMap<String, String> getProductDataInHashMap(Long code){
        int i = getProductIndex(code);
        if(i == -1){
            return null;
        }else{
            Product p = getProductShallowCopy(i);
            HashMap<String, String> data = new HashMap();
            data.put("name", p.getName());
            data.put("code", p.getCode().toString());
            data.put("price", ""+p.getPrice());
            return data;
        }
    }
    

    public static ArrayList<Product> getListOfProductCopy(ArrayList<String> codes) {
        ArrayList<Product> productsCopy = new ArrayList();
        for (String s : codes) {
            Long code = Long.parseLong(s);
            int i = getProductIndex(code);
            productsCopy.add(getProductShallowCopy(i));
        }
        return productsCopy;
    }

    public static int getProductIndex(Long code) {
        int i = 0;
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return i;
            }
            i++;
        }
        return VALIDATION_ERROR_CODE_NOT_FOUND;
    }

    public static int getSizeOfProductList() {
        return products.size();
    }

    public static ArrayList<Product> getList() {
        return (ArrayList<Product>) products.clone();
    }

    public static ArrayList<HashMap<String, String>> getProductsCheaperThan(int refPrice) {
        ArrayList<HashMap<String, String>> a = new ArrayList();
        int i = 1;
        for (Product p : products) {
            if (p.getPrice() < refPrice) {
                HashMap<String, String> hm = new HashMap();
                hm.put("Numero", ""+(i++));
                hm.put("Nombre", p.getName());
                hm.put("Codigo", p.getCode().toString());
                hm.put("Total Gastado", ""+p.getPrice());
                a.add(hm);
            }
        }
        return a;
    }
    
    private static boolean validateIfNameIsUsed(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateIfCodeIsUsed(Long code) {
        return getProductIndex(code) != -1;
    }

    public static int validateProductData(HashMap<String, String> data) {
        if (validateIfNameIsUsed(data.get("name"))) {
            return VALIDATION_ERROR_NAME_USED;
        }
        if (validateIfCodeIsUsed(Long.parseLong(data.get("code")))) {
            return VALIDATION_ERROR_CODE_USED;
        }
        return VALIDATION_SUCCESS;
    }
    
    public static int validateProductDataForEdit(Long code, HashMap<String, String> data) {
        String editingProductName = products.get(getProductIndex(code)).getName();
        String newName = data.get("name");
        if (!editingProductName.equals(newName) && validateIfNameIsUsed(newName)) {
            return VALIDATION_ERROR_NAME_USED;
        }
        return VALIDATION_SUCCESS;
    }

    public static void registerProduct(HashMap<String, String> data) {
        String name = data.get("name");
        Long code = Long.parseLong(data.get("code"));
        int price = Integer.parseInt(data.get("price"));
        products.add(new Product(name, code, price));
    }

    public static void deleteProduct(Long code) {
        int i = getProductIndex(code);
        products.remove(i);
    }

    public static void editProduct(Long code, HashMap<String, String> data) {
        int i = getProductIndex(code);
        String name = data.get("name");
        int price = Integer.parseInt(data.get("price"));
        Product p = products.get(i);
        p.setName(name);
        p.setPrice(price);
    }
    
    public static String getErrorDescription(int error){
        switch(error){
            case VALIDATION_ERROR_CODE_NOT_FOUND:
                return "El codigo dado no existe";
            case VALIDATION_ERROR_CODE_USED:
                return "El codigo dado ya esta en uso, por favor digite otro";
            case VALIDATION_ERROR_NAME_USED:
                return "El nombre dado ya esta en uso";
            default:
                return "Error desconocido";
        }
    }
}
