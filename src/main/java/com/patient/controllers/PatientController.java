package com.patient.controllers;

import com.patient.commands.PatientForm;
//import guru.springframework.converters.PatientToPatientForm;
import com.patient.domain.Patient;
//import com.patient.repositories.PatientRepository;
import com.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import com.fasterxml.jackson.core.sym.Name;

@Controller
public class PatientController {
    private PatientService patientService;

    /*
     * private PatientToParientForm patientToPatientForm;
     * 
     * @Autowired public void setPatientToPatientForm(PatientToPatientForm
     * patientToPatientForm) { this.patientToPatientForm = patientToPatientForm; }
     */

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    
    @RequestMapping("/") 
    public String redirToList(){ 
        return "redirect:/patient/list"; 
    }
     

    @RequestMapping({ "/patient/list", "/patient" })
    public String listPatient(Model model) {
        System.out.println("Submit form 1");
        model.addAttribute("patients", patientService.listAll());
        System.out.println("sub");
        // model.addAttribute("patients", patientService.getByName(name));
        return "patient/list";
    }

    @RequestMapping("/patient/show/{id}")
    public String getPatient(@PathVariable String id, Model model) {
        Patient p = patientService.getById(id);
        //model.addAttribute("age",Period.between(patientService.getById(id).getDob(), LocalDate.now()).getYears());
        model.addAttribute("patient", p);
        //Patient xyz = patientService.getById(id);
        //System.out.println(Period.between(patientService.getById(id).getDob(), LocalDate.now()).getYears());
        return "patient/show";
    }


    
    /*
     * @RequestMapping("patient/edit/{id}") public String edit(@PathVariable String
     * id, Model model){ Patient patient = patientService.getById(id); PatientForm
     * patientForm = patientToPatientForm.convert(patient);
     * 
     * model.addAttribute("patientForm", patientForm); return "patient/patientform";
     * }
     */

    @RequestMapping("/patient/new")
    public String newPatient(Model model) {
        System.out.println("1");
        model.addAttribute("patientForm", new PatientForm());
        
        return "patient/patientform";
    }

    /*
     * @RequestMapping("/patient/search") public String newSearch(){
     * //model.addAttribute("searchName", new PatientForm()); return
     * "patient/search"; }
     */

    @RequestMapping(value = "/patient/search")
    public String searchName() {
        System.out.println("Hi search");

        return "/patient/search";

    }

    /*@GetMapping(value = "/Search")
    public String search(@RequestParam(value = "Name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("patients", patientService.getByName(name));
        System.out.println("8");
        return "/patient/searchlist";
    }*/

    @GetMapping(value = "/Search")
    public String search(@RequestParam(value = "Name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("patients", patientService.getByFnameAndLname(name, name));
        System.out.println("8");
        return "/patient/searchlist";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult) {
        System.out.println("5");
        if(bindingResult.hasErrors()){
            return "patient/patientform";
        }
        Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);
        return "redirect:/patient/show/" + savedPatient.getId();
    }
/*
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/product/list";
    }*/

}