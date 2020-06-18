package org.MMF.web.controller;

import org.MMF.model.Income;
import org.MMF.model.IncomeStatus;
import org.MMF.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@Controller
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @RequestMapping("income/index")
    public String SetIncomes(Model model)
    {
        model.addAttribute("Income", new Income());
        return "Income/index";
    }

    @PostMapping("income/display")
    public List<Income>  getIncomes(Date fromDate, Date toDate)
    {
        List<Income> incomes = incomeService.findBetweenDate(fromDate, toDate);
        return incomes;
    }

    @PostMapping("/income/save")
    public RedirectView AddIncome(@ModelAttribute Income income)
    {
        incomeService.Save(income);
        return new RedirectView("/income/index");
    }

}
