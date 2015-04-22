package com.nuzbox.model.service;

import com.nuzbox.model.AbstractModel;

/**
 * Created by james on 22/04/15.
 */
public interface ModelService {
    public void save(AbstractModel model);

    public AbstractModel getById();
}
