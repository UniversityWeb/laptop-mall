package com.webteam.laptopmall.infrastructure.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbCon {
    private static DbCon ins;
    private EntityManagerFactory emf;
    private final Logger log = LogManager.getLogger(DbCon.class);

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
            log.info("EntityManagerFactory initialized successfully.");
        } catch (Exception e) {
            log.error("Error initializing EntityManagerFactory: {}", e.getMessage());
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
