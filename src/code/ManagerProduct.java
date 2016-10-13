package code;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerProduct {

    private static int editing = -1;
    private static final ArrayList<Product> products = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_NAME = 1;
    public static final int VALIDATION_ERROR_CODE = 2;
    public static final int VALIDATION_ERROR_CODE_NOT_FOUND = -1;

    public static Product getProductCopy(int i) {
        Product p = products.get(i);
        return new Product(p.getName(), p.getCode(), p.getPrice());
    }
    
    public static ArrayList<Product> getListOfProductCopy(ArrayList<String> codes) {
        ArrayList<Product> productsCopy = new ArrayList();
        for(String s : codes){
            Long code = Long.parseLong(s);
            int i = getProductIndex(code);
            productsCopy.add(getProductCopy(i));
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

    public static ArrayList<String> getList() {
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for (Product p : products) {
            a.add((i++) + ") nombre: " + p.getName() + ", codigo: " + p.getCode() + ", precio: " + p.getPrice());
        }
        if (i == 1) {
            a.add("Aun no hay productos");
        }
        return a;
    }
    
    public static Product[] getProductsArray() {
        Product[] ret = new Product[products.size()];
        ret = products.toArray(ret);
        return ret;
    }

    public static ArrayList<String> getProductsCheaperThan(int refPrice) {
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for (Product p : products) {
            if (p.getPrice() < refPrice) {
                a.add((i++) + ") nombre: " + p.getName() + ", codigo: " + p.getCode() + ", precio: " + p.getPrice());
            }
        }
        if (i == 1) {
            a.add("No hay productos que cuesten menos de " + refPrice);
        }
        return a;
    }

    private static boolean verifyProductName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name) && (editing >= 0 ? (!products.get(editing).getName().equals(name)) : true)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verifyProductCode(Long code) {
        for (Product p : products) {
            if (p.getCode().equals(code) && (editing >= 0 ? (!products.get(editing).getCode().equals(code)) : true)) {
                return true;
            }
        }
        return false;
    }

    private static int validateProductData(HashMap<String, String> data) {
        if (verifyProductName(data.get("name"))) {
            return VALIDATION_ERROR_NAME;
        }
        if (verifyProductCode(Long.parseLong(data.get("code")))) {
            return VALIDATION_ERROR_CODE;
        }
        return VALIDATION_SUCCESS;
    }

    public static int registerProduct(HashMap<String, String> data) {
        int aux = validateProductData(data);
        if (aux == VALIDATION_SUCCESS) {
            String name = data.get("name");
            Long code = Long.parseLong(data.get("code"));
            int price = Integer.parseInt(data.get("price"));
            products.add(new Product(name, code, price));
        }
        return aux;
    }

    public static int deleteProduct(Long code) {
        int i = getProductIndex(code);
        int aux;
        if (i == VALIDATION_ERROR_CODE_NOT_FOUND) {
            aux = VALIDATION_ERROR_CODE_NOT_FOUND;
        } else {
            products.remove(i);
            aux = VALIDATION_SUCCESS;
        }
        return aux;
    }

    public static int editProduct(Long code, HashMap<String, String> data) {
        int i = getProductIndex(code);
        if (i == VALIDATION_ERROR_CODE_NOT_FOUND) {
            return VALIDATION_ERROR_CODE_NOT_FOUND;
        } 
        editing = i;
        int aux = validateProductData(data);
        if (aux == VALIDATION_SUCCESS) {
            String name = data.get("name");
            Long codee = Long.parseLong(data.get("code"));
            int price = Integer.parseInt(data.get("price"));
            Product p = products.get(i);
            p.setName(name);
            p.setCode(codee);
            p.setPrice(price);
        }
        editing = -1;
        return aux;
    }
}