package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.email.EmailSender;
import com.maven.pablo.reportingtool.email.FilePath;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import com.maven.pablo.reportingtool.exceptions.ProjectNotFoundException;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.dto.ReportFindForm;
import com.maven.pablo.reportingtool.report.dto.Statistics;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    // EMAIL SENDING //
    private final EmailSender emailSender;

    // SERVICES //
    private EmployeeService employeeService;
    private ReportService reportService;
    private ProjectService projectService;
    private ProjectDetailsService projectDetailsService;

    // MAPPERS //
    @Qualifier("myProjectMapper")
    private MyMapper<Project, ProjectDto> projectMapper;
    @Qualifier("myReportMapper")
    private MyMapper<Report, ReportDto> reportMapper;
    @Qualifier("myEmployeeMapper")
    private MyMapper<Employee,EmployeeDto> employeeMapper;

    // OTHER COMPONENTS //
    private MyCompleteReport myCompleteReport;

    @Autowired
    public ReportController(EmailSender emailSender, EmployeeService employeeService, ReportService reportService,
                            ProjectService projectService, ProjectDetailsService projectDetailsService,
                            MyMapper<Project, ProjectDto> projectMapper, MyMapper<Report, ReportDto> reportMapper,
                            MyMapper<Employee, EmployeeDto> employeeMapper, MyCompleteReport myCompleteReport) {
        this.emailSender = emailSender;
        this.employeeService = employeeService;
        this.reportService = reportService;
        this.projectService = projectService;
        this.projectDetailsService = projectDetailsService;
        this.projectMapper = projectMapper;
        this.reportMapper = reportMapper;
        this.employeeMapper = employeeMapper;
        this.myCompleteReport = myCompleteReport;
    }

    @ModelAttribute("loggedUserReports")
    private List<ReportDto> loggedUserReports(Principal principal){
        List<Report> myReports = reportService.findByEmployeeId(principal.getName());
        return reportMapper.convertToDto(myReports);
    }

    @ModelAttribute("fileList")
    private List<File> fileList(){
        return myCompleteReport.getFileList();
    }

    @ModelAttribute("allReports")
    private List<ReportDto> allReports(){
        return reportMapper.convertToDto(reportService.findAll());
    }

    @ModelAttribute("employeeList")
    private List<EmployeeDto> employeeList(){
        return employeeMapper.convertToDto(employeeService.findAll());
    }
    @ModelAttribute("reportDto")
    private ReportDto reportDto(){
        return new ReportDto();
    }

    @ModelAttribute("reportFindForm")
    private ReportFindForm reportFindForm(){
        return new ReportFindForm();
    }

    @ModelAttribute("departmentList")
    private List<String> departmentList(){
        return reportService.departmentList();
    }

    @ModelAttribute("projectList")
    private List<ProjectDto> projectList(){
        return projectMapper.convertToDto(projectService.findAll());
    }

    @ModelAttribute("unsentReports")
    private List<ReportDto> unsendReports(){
        return myCompleteReport.getReports();
    }

    @ModelAttribute("filePath")
    private FilePath filePath(){
        return new FilePath();
    }

    @GetMapping("/create")
    public ModelAndView createReport(ModelAndView modelAndView){
         modelAndView.setViewName("newreport");
        return modelAndView;
    }

    @PostMapping("/directory")
    public ModelAndView applyDirectory(@ModelAttribute FilePath filePath, BindingResult bindingResult,
                                       ModelAndView modelAndView){
        System.out.println(filePath.getDirectory());
        File file = new File(filePath.getDirectory());
        ArrayList listFiles = new ArrayList<>(Arrays.asList(file.listFiles()));
        myCompleteReport.addFiles(listFiles);
        modelAndView.setViewName("newreport");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveReportPart(@Valid @ModelAttribute("reportDto") ReportDto reportDto, BindingResult bindingResult,
                                       Principal principal, ModelAndView modelAndView ) throws ProjectNotFoundException, EmployeeNotFoundException {

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("newreport");
            return modelAndView; }

        Employee employee = employeeService.findById(principal.getName());
        reportDto.setEmployee(employee);
        reportDto.setEmployeeId(employee.getId());

        Project project = projectService.findByNumber(reportDto.getProjectId());
        reportDto.setProject(project);

        reportDto.setId(myCompleteReport.getReports().size());
        myCompleteReport.addReport(reportDto);

        modelAndView.setViewName("newreport");
        return modelAndView;
    }

    @GetMapping("/confirm")
    public ModelAndView sendReport(ModelAndView modelAndView, Principal principal) throws EmployeeNotFoundException {

        List<Report> reports = reportMapper.newInstanceFromDto(myCompleteReport.getReports());

        reportService.save(reports);
        projectDetailsService.addHoursFromReport(reports);

        emailSender.sendEmail(myCompleteReport, myCompleteReport.getFileList());
        myCompleteReport.clear();
        modelAndView.setViewName("newreport");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteReportPart(@RequestParam("id")int id,
                                           ModelAndView modelAndView){
        myCompleteReport.getReports().remove(id);
        myCompleteReport.rearangeIds();
        modelAndView.setViewName("newreport");
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findReport(@ModelAttribute ReportFindForm reportFindForm,
                                   ModelAndView modelAndView){

        List<ReportDto> reportList = reportMapper.convertToDto(reportService.findByForm(reportFindForm));
        modelAndView.addObject("allReports", reportList);
        modelAndView.addObject("summary", Statistics.of(reportList));
        modelAndView.setViewName("mydetails");
        return modelAndView;
    }

    @GetMapping("/my")
    public ModelAndView myReports(ModelAndView modelAndView, Principal principal){
        modelAndView.setViewName("mydetails");
        modelAndView.addObject("summary", Statistics.of(loggedUserReports(principal)));
        return modelAndView;
    }


}
