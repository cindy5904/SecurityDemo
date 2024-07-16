package org.example.securityproduct.service;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BaseService <TPost, TGet>{
    TGet create (TPost post);
    TGet update (Long id,TPost post) throws ChangeSetPersister.NotFoundException;
    boolean delete (Long id) throws ChangeSetPersister.NotFoundException;
    TGet findById (Long id) throws ChangeSetPersister.NotFoundException;
    List<TGet> findAll ();
}
