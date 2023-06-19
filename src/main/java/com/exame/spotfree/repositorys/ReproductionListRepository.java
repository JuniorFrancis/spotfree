package com.exame.spotfree.repositorys;

import com.exame.spotfree.models.ReproductionList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReproductionListRepository extends JpaRepository<ReproductionList, Long> {

    ReproductionList findByName(String name);

    List<ReproductionList> findByNameContaining(String name);
}
