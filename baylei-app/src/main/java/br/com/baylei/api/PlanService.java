package br.com.baylei.api;

import br.com.baylei.dto.PlanDTO;

import java.util.List;

public interface PlanService {

    PlanDTO save(PlanDTO planDTO);

    PlanDTO update(PlanDTO planDTO);

    List<PlanDTO> getAll();

    PlanDTO getById(String id);

    void deleteById(String id);
}
