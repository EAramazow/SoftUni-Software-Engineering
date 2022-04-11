package com.workshoplab.controllers;

import com.workshoplab.dto.*;
import com.workshoplab.services.CompanyService;
import com.workshoplab.services.EmployeeService;
import com.workshoplab.services.ProjectService;
import com.workshoplab.utils.XmlConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final XmlConverter xmlConverter;

    public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
        xmlConverter = null;
    }

    @GetMapping("/import/xml")
    public String importXml(HttpServletRequest request, Model model) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("areImported", new boolean[]{this.companyService.exists(), this.projectService.exists(), this.employeeService.exists()});
        return "xml/import-xml";
    }

    @GetMapping("/import/companies")
    public String importCompanies(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "companies", this.companyService.getXmlForImport());
        return "xml/import-companies";
    }


    @PostMapping("/import/companies")
    public String importCompanies(ImportCompaniesDto request, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }
        var companyRoot = this.xmlConverter.deserialize(request.getCompanies(), CompanyCollectionDto.class);

        companyRoot.getCompanies().forEach(this.companyService::create);

        return "redirect:/xml/import-xml";
    }


    @GetMapping("/import/projects")
    public String importProjects(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("projects", this.projectService.getXmlForImport());

        return "xml/import-projects";
    }

    @PostMapping("/import/projects")
    public String importProjects(ImportProjectsDto request, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }
        var projectRoot = this.xmlConverter.deserialize(request.getProjects(), ProjectCollectionDto.class);

        projectRoot.getProjects().forEach(this.projectService::create);

        return "redirect:/xml/import-xml";
    }


    @GetMapping("/import/employees")
    public String importEmployees(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("employees", this.employeeService.getXmlForImport());

        return "xml/import-employees";
    }

    @PostMapping("/import/employees")
    public String importEmployees(ImportEmployeesDto request, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }
        var employeeRoot = this.xmlConverter.deserialize(request.getEmployees(), EmployeeCollectionDto.class);

        employeeRoot.getEmployees().forEach(this.employeeService::create);

        return "redirect:/xml/import-xml";
    }



}
