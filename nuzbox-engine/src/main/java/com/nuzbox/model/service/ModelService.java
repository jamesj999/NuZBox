package com.nuzbox.model.service;

import com.nuzbox.model.BaseModel;

import java.util.Collection;

/**
 * Created by james on 22/04/15.
 */
public interface ModelService {
    public void save(BaseModel model);

    public BaseModel lookupByIdentity();

    public <T extends BaseModel> Collection<T> getAll();
}
