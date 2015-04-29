package com.nuzbox.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by james on 22/04/15.
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable, BaseModelInterface {

}
