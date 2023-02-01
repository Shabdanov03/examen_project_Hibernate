package java8.repsitory;

import java8.entity.Bank;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public interface BankRepository {
    String saveBanks(Bank bank);
    String deleteBanksById(Long id);
    Optional<Bank> getBanksByRegionName(String regionName);
    String assignBankToRegion(Long bankId,Long idReg);

}
