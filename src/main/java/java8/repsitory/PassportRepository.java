package java8.repsitory;

import java8.entity.Passport;

/**
 * Shabdanov Ilim
 **/
public interface PassportRepository {
    String savePassport(Passport passport);
    String deleteAllPassportsById(Long id);
    String assignPassportToClient(Long passportId,Long clientId);
}
