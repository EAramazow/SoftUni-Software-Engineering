package com.workshoplab.controllers;

import com.workshoplab.services.EmployeeService;
import com.workshoplab.services.ProjectService;
import com.workshoplab.utils.XmlConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final ProjectService projectService;
    private final XmlConverter xmlConverter;
    private final EmployeeService employeeService;

    public ExportController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.xmlConverter = null;
    }


    @GetMapping("/project-if-finished")
    public String finishedProjects(Model model, HttpServletRequest req) {

        if (!this.isLogged(req)) {
            return "redirect:/";
        }
        model.addAttribute("projectsIfFinished", this.projectService
                .finishedProjects()
                .stream()
                .map(this.xmlConverter::serialize)
                .collect(Collectors.joining("%n"))
        );
        return "export/export-project-if-finished";
    }

    @GetMapping("/employees-above")
    public String employeesAbove(Model model, HttpServletRequest req){
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        model.addAttribute("employeesAbove", this.employeeService.getEmployeesAfter25()
                .stream()
                .map(this.xmlConverter::serialize)
                .collect(Collectors.joining("%n")));


        return "export/export-employees-with-age";

    }

}
