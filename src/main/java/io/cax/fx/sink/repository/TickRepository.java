package io.cax.fx.sink.repository;

import io.cax.fx.sink.domain.Tick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cq on 12/5/16.
 */
@Repository
public interface TickRepository extends CrudRepository<Tick,Long> {

}
