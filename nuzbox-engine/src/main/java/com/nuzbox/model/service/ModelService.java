package com.nuzbox.model.service;

import com.nuzbox.model.BaseIdentifiableModel;

import java.util.Collection;

/**
 * Created by james on 22/04/15.
 */
public interface ModelService {
    public void save(BaseIdentifiableModel model);

    public BaseIdentifiableModel lookupByIdentity();

    public <T extends BaseIdentifiableModel> Collection<T> getAll();
}
