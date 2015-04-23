package com.nuzbox.model.service;

import com.nuzbox.model.BaseIdentifiableModel;

/**
 * Created by james on 22/04/15.
 */
public interface ModelService {
    public void save(BaseIdentifiableModel model);

    public BaseIdentifiableModel lookupByIdentity();
}
