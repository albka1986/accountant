package ua.com.alfacell.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.com.alfacell.models.Product;

import java.util.List;

public class ProductDaoImpl extends BaseDao implements CrudDao<Product> {
    @Override
    public Product findById(int id) {
        Session session = getActiveSession();
        Product product = (Product) session.createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return product;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
