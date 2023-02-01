package java8.repsitory;

import java8.entity.Region;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public interface RegionRepository {
    String saveRegion(Region region);
    List<Region> getAllRegion();
    String updateRegion(Long regionId,Region region);
}
