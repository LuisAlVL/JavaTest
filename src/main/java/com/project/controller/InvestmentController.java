package com.project.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvestmentController implements ApplicationRunner {


    private double initialInvestment;
    private double annualInput;
    private double annualIncrement;
    private int yearsOfInvestment;
    private double performanceOfInvestment;

    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String investment(Model model){
        model.addAttribute("a",initialInvestment);
        model.addAttribute("b",annualInput);
        model.addAttribute("c",annualIncrement);
        model.addAttribute("d",yearsOfInvestment);
        model.addAttribute("e",performanceOfInvestment);

        if(initialInvestment < 1000 || annualInput < 0 || annualIncrement < 0 || yearsOfInvestment < 0 || performanceOfInvestment < 0){
            return "error";
        }
        //create table for investment
        return "index";
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Check that inputs are correct
        initialInvestment = Double.parseDouble(args.getOptionValues("initialInvestment").get(0));
        if(args.getOptionValues("annualInput")!=null)
            annualInput = Double.parseDouble(args.getOptionValues("annualInput").get(0));
        else annualInput = 0;
        if(args.getOptionValues("annualIncrement")!=null)
            annualIncrement = Double.parseDouble(args.getOptionValues("annualIncrement").get(0));
        else annualIncrement = 0;
        yearsOfInvestment = Integer.parseInt(args.getOptionValues("yearsOfInvestment").get(0));
        performanceOfInvestment = Double.parseDouble(args.getOptionValues("performanceOfInvestment").get(0));


    }
}
