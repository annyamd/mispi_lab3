package com.example.web3.db;

import com.example.web3.AreaShot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AreaShotDAO {

    private EntityManagerFactory emf;

    public EntityManagerFactory getEMF (){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("Lab3WebApp");
        }
        return emf;
    }

    public void addAreaShot(AreaShot shot){
        EntityManager em = getEMF().createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(shot);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    public List<AreaShot> findAllAreaShots() {
        TypedQuery<AreaShot> query = getEMF().createEntityManager().createQuery("Select e from AreaShot e", AreaShot.class);
        return query.getResultList();
    }

}
