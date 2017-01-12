package ua.com.alfacell.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.Product;

import java.util.List;

public class ProductDaoImpl extends BaseDao implements CrudDao<Product> {
    static int count = 0;
    @Override
    public Product findById(int id) {
        Session session = getActiveSession();
        Product product = (Product) session.createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = getActiveSession();
        List<Product> products = session.createCriteria(Product.class).list();
        session.close();
        return products;
    }

    @Override
    public void save(Product product) {
        Session session = getActiveSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            System.out.println(++count);
            session.close();
        }
    }

    @Override
    public void update(Product updateProduct) {
        Session session = getActiveSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(updateProduct);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Product product) {


        Session session = getActiveSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(product);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
