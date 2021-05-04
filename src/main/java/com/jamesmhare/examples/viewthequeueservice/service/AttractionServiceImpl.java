package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Attraction;
import com.jamesmhare.examples.viewthequeueservice.repo.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A service class for communicating with the {@link AttractionRepository}.
 *
 * @author James Hare
 */
@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository repository;

    public AttractionServiceImpl(final AttractionRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> findAllAttractions() {
        return this.repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Attraction> findAttractionById(final UUID id) {
        return this.repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public Attraction saveAttraction(final Attraction attraction) {
        return this.repository.save(attraction);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteAttraction(final UUID id) {
        this.repository.deleteById(id);
    }
}