package org.example.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<TENTITY, TID> {

    // Create
    void create(TENTITY entity);

    // Read
    List<TENTITY> getAll();

    Optional<TENTITY> getOne(TID id);

    // Update
    boolean update(TID id, TENTITY entity);

    // Delete
    void delete(TID id);
}
