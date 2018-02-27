package main.java.vn.omi;

/*
 * Created by DucPH - ducph@ominext.com
 * */

import main.java.vn.omi.entity.Items;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllCartDataNativeQuery {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        Transaction tr = session.beginTransaction();

        List<Items> itemsList = session.createNativeQuery(
                "SELECT * FROM items", Items.class )
                .getResultList();


        for (Items items : itemsList) {
            System.out.println("Item ID: " + items.getId());
            System.out.println("Item Total: " + items.getItemTotal());
            System.out.println("Item Quantity: " + items.getQuantity());
            System.out.println("Cart ID: " + items.getCart().getCartId());
            System.out.println("Cart Name: " + items.getCart().getName());
            System.out.println("Cart Total: " + items.getCart().getTotal());
        }


        tr.commit();
        System.out.println("Data printed");
        sessFact.close();
    }
}