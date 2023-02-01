package java8.repsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java8.config.HibernateConfig;
import java8.entity.Bank;
import java8.entity.Client;
import java8.entity.Passport;
import java8.entity.Region;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public class BankRepositoryImpl implements BankRepository, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getManagerFactory();

    @Override
    public String saveBanks(Bank bank) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(bank);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully saved.....";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteBanksById(Long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Bank bank = entityManager.find(Bank.class, id);
            entityManager.remove(bank);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted.....";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Bank> getBanksByRegionName(String regionName) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Bank singleResult = entityManager.createQuery(
                            "select b from Bank b join Region r on r.id = b.region.id" +
                                    " where r.regionName = :regionName", Bank.class)
                    .setParameter("regionName", regionName).getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();
            return Optional.ofNullable(singleResult);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String assignBankToRegion(Long bankId, Long idReg) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Bank bank = entityManager.createQuery("select p from Bank p where p.id = :bankId",Bank.class).
                    setParameter("bankId",bankId).getSingleResult();
            Region region = entityManager.createQuery("select c from Region c where c.id = :idReg", Region.class).
                    setParameter("idReg",idReg).getSingleResult();
            List<Bank> bankList = new ArrayList<>(Arrays.asList(bank));
            bank.setRegion(region);
            region.setBanks(bankList);
            entityManager.merge(bank);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully assigned at region.....";
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
