package com.cj.controller;

import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Category;
import com.cj.model.Formula;
import com.cj.service.CategoryService;
import com.cj.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String ajaxGetChildFormula(@PathVariable Long parentId, @PathVariable String name, ModelMap modelMap) {
        try {
            return formulaService.findAllChildFormulasJSON(name, parentId);
        } catch (SqlResultCountException ex) {
            modelMap.put("exception", ex.getMessage());
            return "index";
        }
        //return "index";

    }

    /*@RequestMapping(value = "/child-formula", method = RequestMethod.GET)
    public Formula getChildFormula(ModelMap modelMap) {

    }*/
}
