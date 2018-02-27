package main.java.vn.omi;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Items;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GetAllCartData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();



		CriteriaQuery<Cart> cq1 = session.getCriteriaBuilder().createQuery(Cart.class);
		cq1.from(Cart.class);
		List<Cart> cartList = session.createQuery(cq1).getResultList();
        for (Cart cart : cartList) {
            System.out.println("Cart ID: " + cart.getCartId());
            System.out.println("Cart Name: " + cart.getName());
            System.out.println("Cart Total: " + cart.getTotal());
        }

		CriteriaQuery<Items> cq2 = session.getCriteriaBuilder().createQuery(Items.class);
		cq2.from(Items.class);
		List<Items> itemsList = session.createQuery(cq2).getResultList();

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