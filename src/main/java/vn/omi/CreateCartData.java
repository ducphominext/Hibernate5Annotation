package main.java.vn.omi;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Items;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * Created by DucPH - ducph@ominext.com
 * */

public class CreateCartData {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();

        Cart cart = new Cart();
        cart.setName("cart000001");
        cart.setTotal(500000d);
        session.save(cart);

        Items items = new Items();
        items.setItemId("CT00001");
        items.setItemTotal(250000d);
        items.setQuantity(2);
        items.setCart(cart);
        session.save(items);

        tr.commit();
        System.out.println("Successfully inserted");
        sessFact.close();
    }
}
