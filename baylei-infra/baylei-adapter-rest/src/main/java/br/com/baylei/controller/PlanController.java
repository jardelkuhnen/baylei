package br.com.baylei.controller;

import br.com.baylei.api.PlanService;
import br.com.baylei.dto.PlanDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = {"PlanEntity service"})
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping
    @ApiOperation("Save plan")
    public ResponseEntity<PlanDTO> save(@Valid @RequestBody @Validated PlanDTO planDTO) {
        return new ResponseEntity<>(planService.save(planDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update plan")
    public ResponseEntity<PlanDTO> update(@Valid @RequestBody @Validated PlanDTO planDTO) {
        return new ResponseEntity<>(planService.update(planDTO), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all plans")
    public ResponseEntity<List<PlanDTO>> getAll() {
        return new ResponseEntity<>(planService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get plan by id")
    public ResponseEntity<PlanDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(planService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete plan by id")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.planService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
