package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Area;
import com.jamesmhare.examples.viewthequeueservice.repo.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A service class for communicating with the {@link AreaRepository}.
 *
 * @author James Hare
 */
@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository repository;

    public AreaServiceImpl(final AreaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Area> findAllAreas() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Area> findAreaById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Area saveArea(Area area) {
        return this.repository.save(area);
    }

    @Override
    public void deleteArea(Long id) {
        this.repository.deleteById(id);
    }
}
