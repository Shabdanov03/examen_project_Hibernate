package java8.repsitory;

import java8.entity.Client;

import java.util.Optional;

/**
 * Shabdanov Ilim
 **/
public interface ClientRepository {
    String saveClient(Client client);
    String deleteByClientId(Long clientId);
    Optional<Client> findByClientId(Long id);
}
