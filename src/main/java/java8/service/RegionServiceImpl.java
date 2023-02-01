package java8.service;

import java8.entity.Region;
import java8.repsitory.RegionRepository;
import java8.repsitory.RegionRepositoryImpl;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public class RegionServiceImpl implements RegionService{
    private final RegionRepository regionRepository = new RegionRepositoryImpl();

    @Override
    public String saveRegion(Region region) {
        return regionRepository.saveRegion(region);
    }

    @Override
    public List<Region> getAllRegion() {
        return regionRepository.getAllRegion();
    }

    @Override
    public String updateRegion(Long regionId, Region region) {
        return regionRepository.updateRegion(regionId,region);
    }
}
