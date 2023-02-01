package java8.service;

import java8.entity.Bank;
import java8.repsitory.BankRepository;
import java8.repsitory.BankRepositoryImpl;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository = new BankRepositoryImpl();
    @Override
    public String saveBanks(Bank bank) {
        return bankRepository.saveBanks(bank);
    }

    @Override
    public String deleteBanksById(Long id) {
        return bankRepository.deleteBanksById(id);
    }

    @Override
    public Optional<Bank> getBanksByRegionName(String regionName) {
        return bankRepository.getBanksByRegionName(regionName);
    }

    @Override
    public String assignBankToRegion(Long bankId, Long idReg) {
        return bankRepository.assignBankToRegion(bankId,idReg);
    }
}
