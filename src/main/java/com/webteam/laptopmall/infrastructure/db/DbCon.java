package com.webteam.laptopmall.infrastructure.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbCon {
    private static DbCon ins;
    private EntityManagerFactory emf;
    private final Logger log = Logger.getLogger(DbCon.class.getName());

    public static DbCon getIns() {
        if (ins == null) {
            synchronized (DbCon.class) {
                if (ins == null) {
                    ins = new DbCon();
                }
            }
        }
        return ins;
    }

    private DbCon() {
        initEmf();
    }

    private void initEmf() {
        try {
            emf = Persistence.createEntityManagerFactory("laptopMall");
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
