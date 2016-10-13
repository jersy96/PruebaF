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
    
    public static Costumer getCostumer(Long id) {
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {//Objects.equals(c.getID(), id)
                return c;
            }
        }
        return null;
    }

    public static int getCostumerIndex(Long id) {
        int i = 0;
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {//Objects.equals(c.getID(), id)
                return i;
            }
            i++;
        }
        return VALIDATION_ERROR_ID_NOT_FOUND;
    }

    public static Costumer getLastCostumer() {
        return costumers.get(costumers.size() - 1);
    }

    private static boolean verifyCostumerID(Long id) {
        for (Costumer c : costumers) {
            if (c.getID().equals(id) && (editing >= 0 ? !(costumers.get(editing).getID().equals(id)) : true)) {
                return true;
            }
        }
        return false;
    }

    private static int validateCostumerData(HashMap<String,String> data) {
        if(data.get("name").length() < 3 || !(data.get("name").matches("([a-z]|[A-Z]|\\s)+"))){
            return VALIDATION_ERROR_NAME;
        }
        if(verifyCostumerID(Long.parseLong(data.get("id")))){
            return VALIDATION_ERROR_ID;
        }
        if((int)(Math.log10(Long.parseLong(data.get("phone")))+1) != 10){
            return  VALIDATION_ERROR_PHONE;
        }
        return VALIDATION_SUCCESS;
    }
    
    public static int registerCostumer(HashMap<String,String> data){
        int aux = validateCostumerData(data);
        if(aux == VALIDATION_SUCCESS){
            Long id = Long.parseLong(data.get("id"));
            Long phone = Long.parseLong(data.get("phone"));
            costumers.add(new Costumer(data.get("name"),id,data.get("address"),data.get("mail"),phone));
        }
        return aux;
    }

    public static ArrayList<String> getList() {
        ArrayList<String> a = new ArrayList();
        int i = 1;
        for (Costumer c : costumers) {
            a.add((i++) + ") nombre: " + c.getName() + ", cedula: " + c.getID() + ", direccion: " + c.getAddress() + ", correo: " + c.getMail() + ", celular: " + c.getPhone());
        }
        if (i == 1) {
            a.add("Aun no hay clientes");
        }
        return a;
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

    public static int deleteCostumer(Long id) {
        int i = getCostumerIndex(id);
        int aux;
        if (i == VALIDATION_ERROR_ID_NOT_FOUND) {
            aux = VALIDATION_ERROR_ID_NOT_FOUND;
        } else {
            costumers.remove(i);
            earnedByDeletedCostumers += costumers.get(i).getTotalSpended();
            aux = VALIDATION_SUCCESS;
        }
        return aux;
}

    public static int editCostumer(Long id, HashMap<String,String> data) {
        int i = getCostumerIndex(id);
        int aux;
        if(i == VALIDATION_ERROR_ID_NOT_FOUND){
            aux = VALIDATION_ERROR_ID_NOT_FOUND;
        }else{
            editing = i;
            Costumer c = costumers.get(i);
            aux = validateCostumerData(data); 
            if(aux == VALIDATION_SUCCESS){
                Long idd = Long.parseLong(data.get("id"));
                Long phone = Long.parseLong(data.get("phone"));
                c.setName(data.get("name"));
                c.setID(idd);
                c.setAddress(data.get("address"));
                c.setMail(data.get("mail"));
                c.setPhone(phone);
            }
            editing = -1;
        }
        return aux; 
    }
    
    public static String getErrorDescription(int error){
        switch(error){
            case VALIDATION_ERROR_NAME:
                return "El nombre debe tener longitud almenos 3 y solo debe contener letras";
            case VALIDATION_ERROR_ID:
                return "Esta cedula ya existe en nuestra base de datos por favor digite otra";
            case VALIDATION_ERROR_PHONE:
                return "El ceulular debe tener exactamente 10 numeros";
            case VALIDATION_ERROR_ID_NOT_FOUND:
                return "Esta cedula no existe en nuestra base de datos";
            default:
                return "Error desconocido";
        }
    }
}