package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import com.jamesmhare.examples.viewthequeueservice.repo.ThemeParkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A service class for communicating with the {@link ThemeParkRepository}.
 *
 * @author James Hare
 */
@Service
public class ThemeParkServiceImpl implements ThemeParkService {

    private final ThemeParkRepository repository;

    public ThemeParkServiceImpl(final ThemeParkRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    public List<ThemePark> findAllThemeParks() {
        return this.repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public Optional<ThemePark> findThemeParkById(final UUID id) {
        return this.repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public ThemePark saveThemePark(final ThemePark themePark) {
        return this.repository.save(themePark);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteThemePark(final UUID id) {
        this.repository.deleteById(id);
    }
}