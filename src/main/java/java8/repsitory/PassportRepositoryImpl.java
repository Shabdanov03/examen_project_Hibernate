package java8.repsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java8.config.HibernateConfig;
import java8.entity.Client;
import java8.entity.Passport;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public class PassportRepositoryImpl implements PassportRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getManagerFactory();

    @Override
    public String savePassport(Passport passport) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(passport);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully saved...";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public String deleteAllPassportsById(Long id) {
        try{

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Passport passport = entityManager.find(Passport.class, id);
            List<Client> clientL = entityManager.createQuery("select c from Client  c",Client.class).getResultList();
            for (Client client : clientL) {
                client.setPassport(null);
            }
            entityManager.remove(passport);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted....";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String assignPassportToClient(Long passportId, Long clientId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Passport passport = entityManager.createQuery("select p from Passport p where p.id = :passportId", Passport.class).
                    setParameter("passportId",passportId).getSingleResult();
            Client client = entityManager.createQuery("select c from Client c where c.id = :clientId", Client.class).
                    setParameter("clientId",clientId).getSingleResult();
            passport.setClient(client);
            client.setPassport(passport);
            entityManager.merge(passport);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully assigned at Client.....";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return  null;
    }

    @Override
    public void close() throws Exception {
 entityManagerFactory.close();
    }
}
