package main.java.vn.omi;

import java.util.List;

import main.java.vn.omi.entity.Items;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaQuery;

public class GetAllCartData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();


		CriteriaQuery<Items> cq = session.getCriteriaBuilder().createQuery(Items.class);
		cq.from(Items.class);
		List<Items> itemsList = session.createQuery(cq).getResultList();

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