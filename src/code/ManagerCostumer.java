package code;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerCostumer {

    private static int editing = -1;
    private static int earnedByDeletedCostumers = 0;
    private static final int POINTS_TO_BE_COMPETITOR = 100000;
    private static final ArrayList<Costumer> costumers = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_NAME = 1;
    public static final int VALIDATION_ERROR_ID = 2;
    public static final int VALIDATION_ERROR_PHONE = 3;
    public static final int VALIDATION_ERROR_ID_NOT_FOUND = -1;

    protected static Costumer getCostumer(Long id) {
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {//Objects.equals(c.getID(), id)
                return c;
            }
        }
        return null;
    }

    private static int getCostumerIndex(Long id) {
        int i = 0;
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {//Objects.equals(c.getID(), id)
                return i;
            }
            i++;
        }
        return VALIDATION_ERROR_ID_NOT_FOUND;
    }

    private static boolean verifyCostumerID(Long id) {//es necesario dejarla porque esta no solo me dice si la cedula existe o no sino que tambien tiene en cuenta si esa cedula la estan editando o no, y eso no lo tiene en cuenta getCsotumerINdex
        for (Costumer c : costumers) {
            if (c.getID().equals(id) && (editing >= 0 ? !(costumers.get(editing).getID().equals(id)) : true)) {
                return true;
            }
        }
        return false;
    }

    public static int validateExistingCostumer(Long id) {
        if (verifyCostumerID(id)) {
            return VALIDATION_SUCCESS;
        }
        return VALIDATION_ERROR_ID_NOT_FOUND;
    }

    public static int validateCostumerData(HashMap<String, String> data) {
        if (data.get("name").length() < 3 || !(data.get("name").matches("([a-z]|[A-Z]|\\s)+"))) {
            return VALIDATION_ERROR_NAME;
        }
        if (verifyCostumerID(Long.parseLong(data.get("id")))) {
            return VALIDATION_ERROR_ID;
        }
        if ((int) (Math.log10(Long.parseLong(data.get("phone"))) + 1) != 10) {
            return VALIDATION_ERROR_PHONE;
        }
        return VALIDATION_SUCCESS;
    }

    public static int validateCostumerDataAndExist(Long id, HashMap<String,String> data){
        int aux = validateExistingCostumer(id);
        if(aux!=VALIDATION_SUCCESS){
            return aux;
        }
        aux = validateCostumerData(data);
        if(aux!=VALIDATION_SUCCESS){
            return aux;
        }
        return VALIDATION_SUCCESS;
    }
    
    public static void registerCostumer(HashMap<String, String> data) {
        Long id = Long.parseLong(data.get("id"));
        Long phone = Long.parseLong(data.get("phone"));
        costumers.add(new Costumer(data.get("name"), id, data.get("address"), data.get("mail"), phone));
    }

    public static ArrayList<Costumer> getList() {
//        ArrayList<String> a = new ArrayList();
//        int i = 1;
//        for (Costumer c : costumers) {
//            a.add((i++) + ") nombre: " + c.getName() + ", cedula: " + c.getID() + ", direccion: " + c.getAddress() + ", correo: " + c.getMail() + ", celular: " + c.getPhone());
//        }
//        if (i == 1) {
//            a.add("Aun no hay clientes");
//        }
        return (ArrayList<Costumer>)costumers.clone();
    }

    public static ArrayList<String> getCompetitors() {
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for (Costumer c : costumers) {
            if (c.getPoints() > POINTS_TO_BE_COMPETITOR) {
                a.add((i++) + ") nombre: " + c.getName() + ", cedula: " + c.getID() + ", direccion: " + c.getAddress() + ", correo: " + c.getMail() + ", celular: " + c.getPhone());
            }
        }
        if (i == 1) {
            a.add("Aun no hay clientes que cumplan las condiciones para participar por premios");
        }
        return a;
    }

    public static ArrayList<String> getCostumersSpendMoreThan(int value) {
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for (Costumer c : costumers) {
            if (c.getTotalSpended() > value) {
                a.add((i++) + ") nombre: " + c.getName() + ", cedula: " + c.getID() + ", direccion: " + c.getAddress() + ", correo: " + c.getMail() + ", celular: " + c.getPhone());
            }
        }
        if (i == 1) {
            a.add("No hay clientes que hayan comprado mas de " + value);
        }
        return a;
    }

    public static ArrayList<String> getTotalSales() {
        ArrayList<String> a = new ArrayList();
        int suma = earnedByDeletedCostumers;
        int i = 1;
        for (Costumer c : costumers) {
            a.add((i++) + ") nombre: " + c.getName() + ", cedula: " + c.getID() + ", total gastado: " + c.getTotalSpended());
            suma += c.getTotalSpended();
        }
        a.add("Gastos de los clientes eliminados: " + earnedByDeletedCostumers);
        a.add("El total ganado en ventas es " + suma);
        return a;
    }

    public static void deleteCostumer(Long id) {
        int i = getCostumerIndex(id);
        costumers.remove(i);
        earnedByDeletedCostumers += costumers.get(i).getTotalSpended();
    }

    public static void editCostumer(Long id, HashMap<String, String> data) {
        int i = getCostumerIndex(id);
        editing = i;
        Costumer c = costumers.get(i);
        Long idd = Long.parseLong(data.get("id"));
        Long phone = Long.parseLong(data.get("phone"));
        c.setName(data.get("name"));
        c.setID(idd);
        c.setAddress(data.get("address"));
        c.setMail(data.get("mail"));
        c.setPhone(phone);
        editing = -1;
    }

    public static void letBuy(Long id, ArrayList<Product> products) {
        getCostumer(id).buy(products);
    }

    public static String getErrorDescription(int error) {
        switch (error) {
            case VALIDATION_ERROR_NAME:
                return "El nombre debe tener longitud almenos 3 y solo debe contener letras";
            case VALIDATION_ERROR_ID:
                return "Esta cedula ya existe en nuestra base de datos por favor digite otra";
            case VALIDATION_ERROR_PHONE:
                return "El celular debe tener exactamente 10 numeros";
            case VALIDATION_ERROR_ID_NOT_FOUND:
                return "Esta cedula no existe en nuestra base de datos";
            default:
                return "Error desconocido";
        }
    }
}
