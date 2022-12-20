package jpaShop;

import jpaShop.domain.Book;
import jpaShop.domain.OrderItem;
import jpaShop.domain.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        try {
//            Orders orders = new Orders();
////            orders.addOrderItem(new OrderItem());
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrders(orders);
//
//            em.persist(orderItem);
//
//            tx.commit();
        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("aa");
            em.persist(book);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
        em.close();
        }
        emf.close();
    }
}
