package com.cj.controller;

import com.cj.model.Category;
import com.cj.model.Formula;
import com.cj.service.CategoryService;
import com.cj.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/")
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
}
