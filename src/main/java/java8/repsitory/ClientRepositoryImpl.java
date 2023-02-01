package java8.repsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java8.config.HibernateConfig;
import java8.entity.Client;
import org.hibernate.HibernateException;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public class ClientRepositoryImpl implements ClientRepository, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getManagerFactory();

    @Override
    public String saveClient(Client client) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully saved....";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteByClientId(Long clientId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Client client = entityManager.find(Client.class, clientId);
            client.getBanks().forEach(x->x.setClients(null));
            entityManager.remove(client);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted....";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Client> findByClientId(Long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Client client = entityManager.createQuery("select c from Client c " +
                            "where c.id = :id", Client.class).
                    setParameter("id", id).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return Optional.ofNullable(client);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
