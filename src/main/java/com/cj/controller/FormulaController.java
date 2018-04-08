package com.cj.controller;

import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Category;
import com.cj.model.Formula;
import com.cj.service.CategoryService;
import com.cj.service.FormulaService;
import com.cj.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class FormulaController {

    @Autowired private FormulaService formulaService;
    @Autowired private CategoryService categoryService;
    @Autowired private LookupService lookupService;

    public FormulaController() {}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTopLevelFormulas(@RequestParam(value = "searchCategory", required = false, defaultValue = "") String categoryId,
                                      @RequestParam(value = "searchName", required = false, defaultValue = "") String name,
                                      ModelMap modelMap) {
        List<Formula> formulas;
        if (! categoryId.equals("")) {
            formulas = formulaService.findAllByCategory(Long.parseLong(categoryId));
        } else if (! name.equals("")) {
            formulas = formulaService.findByName(name);
        } else {
            formulas = formulaService.findAll();
        }

        List<Category> categories = categoryService.findAll();
        modelMap.put("formulas", formulas);
        modelMap.put("categories", categories);
        return "index3";
    }

    @RequestMapping(value = "/childFormula")
    @ResponseBody
    public ResponseEntity<Formula> getChildFormula(@RequestParam(value = "id") Long id,
                                                       ModelMap modelMap) {
        try {
            Formula formula = formulaService.findById(id);
            return new ResponseEntity<>(formula, HttpStatus.OK);
        } catch (SqlResultCountException ex) {
            //modelMap.put("exception", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return "index";
    }

    @RequestMapping(value = "/allFormulas")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getAllFormulas() {
        try {
            Map<String, String> formulas = formulaService.findAllIDsAndNames();
            return new ResponseEntity<>(formulas, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getDbVersion")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDbVersion() {
        try {
            Map<String, Object> dbVersion = lookupService.getDbVersion();
            return new ResponseEntity<>(dbVersion, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @RequestMapping(value = "/formulasById/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<Formula>> getFormulasById(@PathVariable Long id) {
//        List<Formula> formulas = formulaService.findAllByCategory(id);
//        return new ResponseEntity<>(formulas, HttpStatus.OK);
//    }


}
