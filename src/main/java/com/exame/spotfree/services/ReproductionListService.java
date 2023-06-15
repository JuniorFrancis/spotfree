package com.exame.spotfree.services;

import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReprodutionListRequest;

import java.util.List;

public interface ReproductionListService {

    ReproductionList getOne(Long id);

    List<ReproductionList> getAll();

    ReproductionList getByName(String name);

    ReproductionList create(ReprodutionListRequest reproductionList);

    void delete(Long id);

    void deleteByName(String name);
}
