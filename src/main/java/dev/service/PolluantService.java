package dev.service;

import dev.entite.qualite.Polluant;
import dev.repository.PolluantRepository;
import org.springframework.stereotype.Service;

@Service
public class PolluantService {

    private PolluantRepository polluantRepository;

    public PolluantService(PolluantRepository polluantRepository) {
        this.polluantRepository = polluantRepository;
    }

    public Polluant createPolluant(Polluant polluant){
        return polluantRepository.save(polluant);
    }
}
