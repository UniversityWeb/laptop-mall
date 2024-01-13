package com.webteam.laptopmall.db;

import com.webteam.laptopmall.infrastructure.db.DbCon;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbConTest {
    private EntityManagerFactory emf;

    @Test
    public void testEntityManagerFactoryNotNull() {
        emf = DbCon.getIns().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            assertNotNull(em);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}