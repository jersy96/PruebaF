package code;

//import java.io.BufferedReader;
import gui.MainMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
public class Main {

    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.setVisible(true);
    }
//    private static final Scanner s = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int op, aux;
//        Long auxl;
//        do {
//            System.out.println("Buenos dias, usted es un cliente(1) o administrador(2)");
//            op = s.nextInt();
//            switch (op) {
//                case 1:
//                    System.out.println("Digite su numero de cedula:");
//                    long id = s.nextLong();
//                    Costumer c = ManagerCostumer.getCostumer(id);
//                    if (c == null) {
//                        System.out.println("Usted no se encuentra en nuestra base de datos, por favor digite los datos solicitados para registrarse");
//                        do{
//                            aux = ManagerCostumer.registerCostumer(askCostumer());
//                        }while(aux != ManagerCostumer.VALIDATION_SUCCESS);
//                        c = ManagerCostumer.getLastCostumer();
//                    }
////                    c.buy();
//                    break;
//                case 2:
//                    Costumer cos;
//                    do {
//                        System.out.println("Usted desea relizar acciones con respecto a fidelizacion de clientes(1), gestion de productos(2), gestion de facturas(3), gestion de informacion(4)");
//                        op = s.nextInt();
//                    } while (op < 1 || op > 4);
//                    switch (op) {
//                        case 1:
//                            do {
//                                System.out.println("listar clientes(1), crear cliente(2), eliminar cliente(3), editar un cliente(4)");
//                                op = s.nextInt();
//                            } while (op < 1 || op > 4);
//                            switch (op) {
//                                case 1:
//                                    Main.writeList(ManagerCostumer.getList());
//                                    break;
//                                case 2:
//                                    do{
//                                        aux = ManagerCostumer.registerCostumer(askCostumer());
//                                    } while (aux != ManagerCostumer.VALIDATION_SUCCESS);
//                                    break;
//                                default:
//                                    do {
//                                        System.out.println("Digite la cedula del cliente:");
//                                        auxl = s.nextLong();
//                                    } while (ManagerCostumer.getCostumerIndex(auxl) == -1);
//                                    switch (op) {
//                                        case 3:
//                                            ManagerCostumer.deleteCostumer(auxl);
//                                            break;
//                                        case 4:
//                                            System.out.println("A continuacion digite los nuevos datos");
//                                            do{
//                                                aux = ManagerCostumer.editCostumer(auxl,askCostumer());
//                                            } while (aux != ManagerCostumer.VALIDATION_SUCCESS);
//                                            break;
//                                    }
//                                    break;
//                            }
//                            break;
//                        case 2:
//                            do {
//                                System.out.println("listar productos(1), crear producto(2), eliminar producto(3), editar un producto(4), mostrar los productos con un precio menor a un valor(5)");
//                                op = s.nextInt();
//                            } while (op < 1 || op > 5);
//                            switch (op) {
//                                case 1:
//                                    Main.writeList(ManagerProduct.getList());
//                                    break;
//                                case 2:
//                                    HashMap<String,String> data;
//                                    do{
//                                        data = askProduct();
//                                    }while(ManagerProduct.registerProduct(data) != ManagerProduct.VALIDATION_SUCCESS);
//                                    break;
//                                case 3:
//                                case 4:
////                                    do {
////                                        System.out.println("Digite el codigo del producto:");
////                                        aux = ManagerProduct.getProductIndex(s.nextLong());
////                                        if (aux == -1) {
////                                            System.out.println("El codigo no pertenece a ningun producto");
////                                        }
////                                    } while (aux == -1);
////                                    switch (op) {
////                                        case 3:
////                                            ManagerProduct.deleteProduct(aux);
////                                            break;
////                                        case 4:
////                                            System.out.println("A continuacion digite los nuevos datos");
////                                            ManagerProduct.editProduct(aux);
////                                            break;
////                                    }
//                                    break;
//                                case 5:
//                                    do {
//                                        System.out.println("Digite el precio de referencia:");
//                                        aux = s.nextInt();
//                                        if (aux < 0) {
//                                            System.out.println("el precio de referencia debe ser mayor que 0");
//                                        }
//                                    } while (aux < 0);
//                                    Main.writeList(ManagerProduct.getProductsCheaperThan(aux));
//                            }
//                            break;
//                        case 3:
////                            do {
////                                System.out.println("crear factura(1), mostrar facturas(2), eliminar factura(3), editar una factura(4), listar todas las facturas de un cliente(5)");
////                                op = s.nextInt();
////                            } while (op < 1 || op > 5);
////                            switch (op) {
////                                case 1:
////                                    do {
////                                        System.out.println("Digite la cedula del cliente al que se le asignara la nueva factura:");
////                                        c = ManagerCostumer.getCostumer(s.nextLong());
////                                        if (c == null) {
////                                            System.out.println("La cedula no pertenece a ningun cliente");
////                                        }
////                                    } while (c == null);
////                                    c.buy();
////                                    break;
////                                case 2:
////                                    Main.writeList(ManagerBill.getList());
////                                    break;
////                                case 3:
////                                case 4:    
////                                    do {
////                                        Main.writeList(ManagerBill.getList());
////                                        System.out.println("Digite el indice de la factura que desea eliminar");
////                                        aux = s.nextInt() - 1;
////                                    } while (aux < 0 || aux >= ManagerBill.getListSize());
////                                    switch (op) {
////                                        case 3:
////                                            ManagerBill.deleteBill(aux);
////                                            break;
////                                        case 4:
////                                            System.out.println("A continuacion digite los nuevos datos");
////                                            ManagerBill.editBill(aux);
////                                            break;
////                                    }
////                                    break;
////                                case 5:
////                                    do {
////                                        System.out.println("Digite la cedula del cliente del que quiere ver todas sus factura:");
////                                        cos = ManagerCostumer.getCostumer(s.nextLong());
////                                        if (cos == null) {
////                                            System.out.println("La cedula no pertenece a ningun cliente");
////                                        }
////                                    } while (cos == null);
////                                    ManagerBill.getBillsByCostumer(cos.getID());
////                                    break;
////                            }
//                            break;
//                        case 4:
//                            do {
//                                System.out.println("(1)listar todos los clientes seleccionables para participar por premios\n(2)listar todos los clientes cuyo valor total en compras sea mayor a un millon de pesos\n(3)mostrar el dinero total producido por todas las ventas");
//                                op = s.nextInt();
//                            } while (op < 1 || op > 3);
//                            switch (op) {
//                                case 1:
//                                    Main.writeList(ManagerCostumer.getCompetitors());
//                                    break;
//                                case 2:
//                                    Main.writeList(ManagerCostumer.getCostumersSpendMoreThan(1000000));
//                                    break;
//                                case 3:
//                                    Main.writeList(ManagerCostumer.getTotalSales());
//                                    break;
//                            }
//                            break;
//                    }
//                    break;
//            }
//        } while (true);
//    }
//    public static String readString() {
//        try {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//            return bf.readLine();
//        } catch (IOException ex) {
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//    public static void writeList(ArrayList<String> a){
//        for(String s : a){
//            System.out.println(s);
//        }
//    }
//    private static HashMap<String,String> askCostumer() {
//        String name;
//        Long id;
//        String address;
//        String mail;
//        Long phone;
//        HashMap<String,String> ret = new HashMap();
//        System.out.println("Digite un nombre completo en un formato de solo letras y una longitud de almenos 3:");
//        name = Main.readString();
//        ret.put("name",name);
//        System.out.println("Digite un numero de cedula:");
//        id = s.nextLong();
//        ret.put("id",id.toString());
//        System.out.println("Digite una direccion:");
//        address = Main.readString();
//        ret.put("address",address);
//        System.out.println("Digite un correo electronico:");
//        mail = Main.readString();
//        ret.put("mail",mail);
//        System.out.println("Digite un numero de celular(10 digitos):");
//        phone = s.nextLong();
//        ret.put("phone",phone.toString());
//        return ret;
//    }
//    private static HashMap<String,String> askProduct(){
//        String name = "";
//        Long code;
//        int price;
//        HashMap<String,String> data = new HashMap();
//        System.out.println("Digite el nombre del producto:");
//        name = Main.readString();
//        data.put("name", name);
//        System.out.println("Digite un codigo para el producto:");
//        code = s.nextLong();
//        data.put("code", code.toString());
//        System.out.println("Digite un precio para el producto:");
//        price = s.nextInt();
//        data.put("price", ""+price);
//        return data;
//    }

    public static void refreshTable(JTable table, ArrayList<LinkedHashMap<String, String>> data) {
        if(data.size() > 0){
            DefaultTableModel newModel = new DefaultTableModel() {
    //            Class[] types = new Class[]{
    //                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
    //            };
    //            boolean[] canEdit = new boolean[]{
    //                false, false, true
    //            };

    //            public Class getColumnClass(int columnIndex) {
    //                return types[columnIndex];
    //            }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            Set<String> set = data.get(0).keySet();
            for (String s : set) {
                newModel.addColumn(s);
            }
            for (HashMap<String, String> hm : data) {
                String[] sa = (String[]) hm.values().toArray(new String[hm.size()]);
                newModel.addRow(sa);
            }
            table.setModel(newModel);
        }
    }
}
