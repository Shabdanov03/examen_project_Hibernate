package java8.service;

import java8.entity.Region;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public interface RegionService {
    String saveRegion(Region region);
    List<Region> getAllRegion();
    String updateRegion(Long regionId,Region region);
}
