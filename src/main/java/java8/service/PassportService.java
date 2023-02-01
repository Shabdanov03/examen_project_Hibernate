package java8.service;

import java8.entity.Passport;

/**
 * Shabdanov Ilim
 **/
public interface PassportService {
    String savePassport(Passport passport);
    String deleteAllPassportsById(Long id);
    String assignPassportToClient(Long passportId,Long clientId);
}
