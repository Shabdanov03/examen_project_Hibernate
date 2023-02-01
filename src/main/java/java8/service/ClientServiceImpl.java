package java8.service;

import java8.entity.Client;
import java8.repsitory.ClientRepository;
import java8.repsitory.ClientRepositoryImpl;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository = new ClientRepositoryImpl();
    @Override
    public String saveClient(Client client) {
        return clientRepository.saveClient(client);
    }

    @Override
    public String deleteByClientId(Long clientId) {
        return clientRepository.deleteByClientId(clientId);
    }

    @Override
    public Optional<Client> findByClientId(Long id) {
        return clientRepository.findByClientId(id);
    }
}
