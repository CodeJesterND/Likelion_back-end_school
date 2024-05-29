package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {
    // CRUD
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Passport passport = em.find(Passport.class, 1L);
            log.info("Found Passport : {}", passport.getPassportNumber());
            log.info("Passport Owner : {}", passport.getPerson().getName());

            Person person = em.find(Person.class, 2L);
            log.info("Found Person : {}", person.getName());
            log.info("Person's Passport : {}", person.getPassport().getPassportNumber());

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = new Person();
            person.setName("hyoseung");

            Passport passport = new Passport();
            passport.setPassportNumber("190328");

            person.setPassport(passport);
            passport.setPerson(person);

            em.persist(person);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void deleteByPassport() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 1L);
            if (person != null) {
                Passport passport = person.getPassport();

                person.setPassport(null);
                if (passport != null) {
                    passport.setPerson(null);
                    em.remove(passport);
                }

                em.persist(person);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }



    public static void main(String[] args) {
        find();
    }
}
