package com.hedleyproctor.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Igor Baiborodine
 */
@MappedSuperclass()
public class BaseDomain implements Serializable {
	private static final long serialVersionUID = 2046817797043495174L;
	@Version
    protected Long version;

    public Long getVersion() {
        return version;
    }
}
