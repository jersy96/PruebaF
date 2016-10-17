package code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Bill {

    private Calendar date;
    private Costumer costumer;
    private int totalValue = 0; 
    private ArrayList<Product> products = new ArrayList();
    private static final Scanner s = new Scanner(System.in);
    
    public Bill(Costumer costumer, ArrayList<Product> products) {
        this.date = Calendar.getInstance();
        this.costumer = costumer;
        addProducts(products);
        ManagerBill.addBill(this);
    }
    public Costumer getCostumer(){
        return costumer;
    }
    public int getTotalValue() {
        return totalValue;
    }
    public String getDate(){
        return date.getTime().toString();
    }
    public void setTotalValue(int v){
        this.totalValue = v;
    }
    public void setCostumer(Costumer c){
        this.costumer = c;
    }
    public void addProducts(ArrayList<Product> products) {
//        int prod, aux;
//        do {
//            ManagerProduct.getList();
//            System.out.println("Digite el indice en la lista correspondiente al producto que desea comprar:");
//            prod = s.nextInt() - 1;
//            if (prod >= 0 && prod < ManagerProduct.getSizeOfProductList()) {
//                Product p = ManagerProduct.getProductCopy(prod);
//                this.products.add(p);
//                this.totalValue += p.getPrice();
//                System.out.println("Compra exitosa, van " + products.size() + " productos por un valor total de " + totalValue);
//            } else {
//                System.out.println("El indice no corresponde a ningun producto");
//            }
//            System.out.println("Desea seguir agregando productos si(1) no(2):");
//            aux = s.nextInt();
//            if(aux == 2 && this.products.isEmpty()){
//                System.out.println("Recuerde que debe comprar almenos un producto");
//                aux = 1;
//            }
//        } while (aux != 2);
//        this.costumer.changeTotalSpended(totalValue);
        for(Product p : products){
            this.products.add(p);
            this.totalValue += p.getPrice();
        }
        this.costumer.changeTotalSpended(totalValue);
    }
    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>)this.products.clone();
    }
    public void clearProducts(){
        this.products.clear();
    }
}