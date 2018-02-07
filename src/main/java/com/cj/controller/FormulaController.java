package com.cj.controller;

import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Category;
import com.cj.model.Formula;
import com.cj.service.CategoryService;
import com.cj.service.FormulaService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormulaController {

    @Autowired private FormulaService formulaService;
    @Autowired private CategoryService categoryService;

    public FormulaController() {}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewMainFormulas(ModelMap modelMap) {
        List<Formula> formulas = formulaService.findAll();
        List<Category> categories = categoryService.findAll();
        modelMap.put("formulas", formulas);
        modelMap.put("categories", categories);
        return "index";
    }

    @RequestMapping(value = "/childFormula/{parentId}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Formula> ajaxGetChildFormula(@PathVariable Long parentId, @PathVariable String name, ModelMap modelMap) {
        try {
            Formula formula = formulaService.findAllChildFormulasJSON(name, parentId);
            return new ResponseEntity<>(formula, HttpStatus.OK);
        } catch (SqlResultCountException ex) {
            //modelMap.put("exception", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return "index";

    }

}
