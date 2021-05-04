package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Show;
import com.jamesmhare.examples.viewthequeueservice.repo.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A service class for communicating with the {@link ShowRepository}.
 *
 * @author James Hare
 */
@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository repository;

    public ShowServiceImpl(final ShowRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    public List<Show> findAllShows() {
        return this.repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Show> findShowById(final UUID id) {
        return this.repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public Show saveShow(final Show show) {
        return this.repository.save(show);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteShow(final UUID id) {
        this.repository.deleteById(id);
    }
}