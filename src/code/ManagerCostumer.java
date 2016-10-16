package code;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagerCostumer {

    private static int earnedByDeletedCostumers = 0;
    private static final int POINTS_TO_BE_COMPETITOR = 100000;
    private static final ArrayList<Costumer> costumers = new ArrayList();
    public static final int VALIDATION_SUCCESS = 0;
    public static final int VALIDATION_ERROR_NAME = 1;
    public static final int VALIDATION_ERROR_ID_USED = 2;
    public static final int VALIDATION_ERROR_PHONE = 3;
    public static final int VALIDATION_ERROR_ID_NOT_FOUND = -1;

    public static HashMap<String, String> getCostumerDataInHashMap(Long id) {
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {
                HashMap data = new HashMap();
                data.put("name", c.getName());
                data.put("id", c.getID().toString());
                data.put("address", c.getAddress());
                data.put("mail", c.getMail());
                data.put("phone", c.getPhone().toString());
                return data;
            }
        }
        return null;
    }

    protected static Costumer getCostumerDeepCopy(Long id) {
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private static int getCostumerIndex(Long id) {
        int i = 0;
        for (Costumer c : costumers) {
            if (c.getID().equals(id)) {
                return i;
            }
            i++;
        }
        return VALIDATION_ERROR_ID_NOT_FOUND;
    }

    public static boolean validateIfIdIsUsed(Long id) {
        return getCostumerIndex(id) != -1;
    }

    public static int validateCostumerData(HashMap<String, String> data, boolean editing) {
        if (data.get("name").length() < 3 || !(data.get("name").matches("([a-z]|[A-Z]|\\s)+"))) {
            return VALIDATION_ERROR_NAME;
        }

        if (!editing && validateIfIdIsUsed(Long.parseLong(data.get("id")))) {
            return VALIDATION_ERROR_ID_USED;
        }

        if ((int) (Math.log10(Long.parseLong(data.get("phone"))) + 1) != 10) {
            return VALIDATION_ERROR_PHONE;
        }
        return VALIDATION_SUCCESS;
    }

    public static void registerCostumer(HashMap<String, String> data) {
        Long id = Long.parseLong(data.get("id"));
        Long phone = Long.parseLong(data.get("phone"));
        costumers.add(new Costumer(data.get("name"), id, data.get("address"), data.get("mail"), phone));
    }

    public static ArrayList<Costumer> getList() {
        return (ArrayList<Costumer>) costumers.clone();
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
        Costumer c = costumers.get(getCostumerIndex(id));
        c.setName(data.get("name"));
        c.setID(Long.parseLong(data.get("id")));
        c.setAddress(data.get("address"));
        c.setMail(data.get("mail"));
        c.setPhone(Long.parseLong(data.get("phone")));
    }

    public static void letBuy(Long id, ArrayList<Product> products) {
        getCostumerDeepCopy(id).buy(products);
    }

    public static String getErrorDescription(int error) {
        switch (error) {
            case VALIDATION_ERROR_NAME:
                return "El nombre debe tener longitud almenos 3 y solo debe contener letras";
            case VALIDATION_ERROR_ID_USED:
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
