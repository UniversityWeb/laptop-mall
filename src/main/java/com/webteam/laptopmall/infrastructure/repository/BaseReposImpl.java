package com.webteam.laptopmall.infrastructure.repository;

import com.webteam.laptopmall.infrastructure.db.DbCon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class BaseReposImpl<T, ID> implements BaseRepos<T, ID> {

    private final Logger log = LogManager.getLogger(BaseReposImpl.class);

    protected DbCon dbCon;
    protected EntityManagerFactory emf;

    protected BaseReposImpl() {
        dbCon = DbCon.getIns();
        emf = DbCon.getIns().getEmf();
    }

    @Override
    public T save(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            T savedEntity = em.merge(entity);
            trans.commit();
            return savedEntity;
        } catch (Exception e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public Optional<T> getById(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            Class<T> classType = getClassType();
            T entity = em.find(classType, id);
            if (entity != null) {
                return Optional.of(entity);
            }
        } catch (NoResultException e) {
            log.error(e.getMessage());
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public T deleteById(ID id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        T entity = null;
        try {
            trans.begin();
            Class<T> classType = getClassType();
            entity = em.find(classType, id);
            if (entity != null) {
                em.remove(entity);
            }
            trans.commit();
        } catch (NoResultException e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        String entityName = getClassType().getSimpleName();
        String sqlStr = String.format("SELECT e FROM %s e", entityName);
        List<T> list = new ArrayList<>();
        try {
            Class<T> classType = getClassType();
            TypedQuery<T> q = em.createQuery(sqlStr, classType);
            list = q.getResultList();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public int deleteAll() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int deletedRow = 0;

        try {
            trans.begin();
            String entityName = getClassType().getSimpleName();
            String sqlStr = String.format("DELETE FROM %s", entityName);
            Query query = em.createQuery(sqlStr);
            deletedRow = query.executeUpdate();
            trans.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }

        return deletedRow;
    }

    protected int executeUpdate(Function<EntityManager, Query> query) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int rowCount = 0;

        try {
            trans.begin();
            rowCount = query.apply(em).executeUpdate();
            trans.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }

        return rowCount;
    }

    protected abstract Class<T> getClassType();

    protected <V> V getSingleResult(Function<EntityManager, TypedQuery<V>> query) {
        EntityManager em = emf.createEntityManager();
        V entity = null;
        try {
            TypedQuery<V> typedQuery = query.apply(em);
            entity = typedQuery.getSingleResult();
        } catch (NoResultException e) {
            log.error(e.getMessage());
        } finally {
            em.close();
        }
        return entity;
    }

    protected <V> List<V> getResultList(Function<EntityManager, TypedQuery<V>> query) {
        EntityManager em = emf.createEntityManager();
        List<V> items = new ArrayList<>();
        try {
            TypedQuery<V> typedQuery = query.apply(em);
            items = typedQuery.getResultList();
        } catch (NoResultException e) {
            log.error(e.getMessage());
        } finally {
            em.close();
        }
        return items;
    }
}