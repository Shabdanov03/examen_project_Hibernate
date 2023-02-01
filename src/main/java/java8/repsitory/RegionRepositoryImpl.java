package java8.repsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java8.config.HibernateConfig;
import java8.entity.Region;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public class RegionRepositoryImpl implements RegionRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getManagerFactory();

    @Override
    public String saveRegion(Region region) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(region);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully saved.....";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Region> getAllRegion() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Region> region = entityManager.createQuery(" from Region  ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return region;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateRegion(Long regionId, Region region) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Region oldRegion = entityManager.find(Region.class, regionId);
            oldRegion.setRegionName(region.getRegionName());
            oldRegion.setBanks(region.getBanks());
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully updated......";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void close() throws Exception {
    entityManagerFactory.close();
    }
}
