package com.exame.spotfree.services;

import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReproductionListRequest;

import java.util.List;

public interface ReproductionListService {

    ReproductionList getOne(Long id);

    List<ReproductionList> getAll();

    List<ReproductionList> getByName(String name);

    ReproductionList create(ReproductionListRequest reproductionList);

    void delete(Long id);

    void deleteByName(String name);

    ReproductionList update(Long Long, ReproductionListRequest updatedReproductionList);
}
