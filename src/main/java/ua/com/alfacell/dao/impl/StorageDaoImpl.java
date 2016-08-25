package ua.com.alfacell.dao.impl;

// Created by Ponomarenko Oleh on 22.08.2016.

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.Storage;

import java.util.List;

public class StorageDaoImpl extends BaseDao implements CrudDao<Storage> {
    @Override
    public Storage findById(int id) {
        Session session = getActiveSession();

        Storage storage = (Storage) session.createCriteria(Storage.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return storage;
    }

    @Override
    public List<Storage> findAll() {
        Session session = getActiveSession();
        List<Storage> storages = session.createCriteria(Storage.class).list();
        return storages;
    }

    @Override
    public void save(Storage storage) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(storage);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void update(Storage updateStorage) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(updateStorage);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Storage storage) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(storage);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
