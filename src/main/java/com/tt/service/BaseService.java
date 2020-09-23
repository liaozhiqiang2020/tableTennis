package com.tt.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAllEntities();

}
