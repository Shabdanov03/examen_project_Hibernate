package java8.service;

import java8.entity.Client;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public interface ClientService {
    String saveClient(Client client);
    String deleteByClientId(Long clientId);
    Optional<Client> findByClientId(Long id);
}
