package com.br.relogio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.relogio.domain.RelogioEntity;

@Repository
public interface RelogioRepository extends CrudRepository<RelogioEntity, Long>{

}
