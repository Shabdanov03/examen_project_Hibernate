package java8.service;

import java8.entity.Passport;
import java8.repsitory.PassportRepository;
import java8.repsitory.PassportRepositoryImpl;

/**
 * Shabdanov Ilim
 **/
public class PassportServiceImpl implements PassportService{
    PassportRepository passportRepository = new PassportRepositoryImpl();

    @Override
    public String savePassport(Passport passport) {
        return passportRepository.savePassport(passport);
    }

    @Override
    public String deleteAllPassportsById(Long id) {
        return passportRepository.deleteAllPassportsById(id);
    }


    @Override
    public String assignPassportToClient(Long passportId, Long clientId) {
        return passportRepository.assignPassportToClient(passportId,clientId);
    }
}
