package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.dto.ReportFindForm;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private EmployeeService employeeService;
    private ReportService reportService;
    private ProjectService projectService;
    private ProjectDetailsService projectDetailsService;

    @Qualifier("myProjectMapper")
    private MyMapper<Project, ProjectDto> projectMapper;
    @Qualifier("myReportMapper")
    private MyMapper<Report, ReportDto> reportMapper;

    private MyCompleteReport myCompleteReport;

    public ReportController(EmployeeService employeeService, ReportService reportService,
                            ProjectService projectService, ProjectDetailsService projectDetailsService,
                            MyMapper<Project, ProjectDto> projectMapper, MyMapper<Report, ReportDto> reportMapper,
                            MyCompleteReport myCompleteReport) {
        this.employeeService = employeeService;
        this.reportService = reportService;
        this.projectService = projectService;
        this.projectDetailsService = projectDetailsService;
        this.projectMapper = projectMapper;
        this.reportMapper = reportMapper;
        this.myCompleteReport = myCompleteReport;
    }

    @ModelAttribute("loggedUserReports")
    private List<ReportDto> loggedUserReports(Principal principal){
        List<Report> myReports = reportService.findByEmployeeId(principal.getName());
        return reportMapper.convertToDto(myReports);
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

    @ModelAttribute
    private List<ReportDto> unreadReports(Principal principal){
        Employee employee = employeeService.findById(principal.getName());
        List<Report> unreadReports = employeeService.getUnreadReports(employee);
        return reportMapper.convertToDto(unreadReports);
    }


    @GetMapping("/create")
    public ModelAndView createReport(ModelAndView modelAndView){

        modelAndView.setViewName("report/send");
        modelAndView.addObject("reportDto");
        modelAndView.addObject("departmentList");
        modelAndView.addObject("projectList");
        modelAndView.addObject("unsentReports");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveReportPart(@Valid @ModelAttribute("reportDto") ReportDto reportDto, BindingResult bindingResult,
                                       Principal principal, ModelAndView modelAndView ){

        modelAndView.addObject("departmentList");
        modelAndView.addObject("projectList");

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("report/send");
            modelAndView.addObject("unsentReports");
            return modelAndView; }

        Employee employee = employeeService.findById(principal.getName());
        reportDto.setEmployee(employee);
        reportDto.setEmployeeId(employee.getId());

        Project project = projectService.findByNumber(reportDto.getProjectId());
        reportDto.setProject(project);

        reportDto.setId(myCompleteReport.getReports().size());
        myCompleteReport.addReport(reportDto);

        modelAndView.setViewName("report/send");
        modelAndView.addObject("reportDto");
        modelAndView.addObject("unsentReports");
        return modelAndView;
    }

    @GetMapping("/confirm")
    public ModelAndView sendReport(ModelAndView modelAndView, Principal principal)  {

        List<Report> reports = reportMapper.newInstanceFromDto(myCompleteReport.getReports());

        reportService.save(reports);
        employeeService.addUnreadReport(reports);
        projectDetailsService.addHoursFromReport(reports);

        myCompleteReport.clear();
        modelAndView.setViewName("report/send");
        modelAndView.addObject("reportDto");
        modelAndView.addObject("unsentReports");
        modelAndView.addObject("departmentList");
        modelAndView.addObject("projectList");

        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteReportPart(@RequestParam("id")int id,
                                           ModelAndView modelAndView){
        myCompleteReport.getReports().remove(id);
        myCompleteReport.rearangeIds();
        modelAndView.setViewName("report/send");
        modelAndView.addObject("reportDto");
        modelAndView.addObject("unsentReports");
        modelAndView.addObject("departmentList");
        modelAndView.addObject("projectList");
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findReport(@ModelAttribute ReportFindForm reportFindForm, BindingResult bindingResult,
                                   ModelAndView modelAndView,Principal principal){

        reportFindForm.setEmployee(principal.getName());
        List<ReportDto> reportList = reportMapper.convertToDto(reportService.findByForm(reportFindForm));
        modelAndView.addObject("loggedUserReports", reportList);
        modelAndView.addObject("reportFindFrom");
        modelAndView.setViewName("report/find");
        return modelAndView;
    }

    @GetMapping("/my")
    public ModelAndView myReports(ModelAndView modelAndView){

        modelAndView.addObject("loggedUserReports");
        modelAndView.addObject("reportFindForm");
        modelAndView.addObject("projectList");
        modelAndView.addObject("departmentList");
        modelAndView.setViewName("report/my");
        return modelAndView;
    }

    @GetMapping("/unread")
    public ModelAndView unreadReports(ModelAndView modelAndView,
                                  Principal principal){

        modelAndView.addObject("unreadReports",unreadReports(principal));
        modelAndView.setViewName("report/unread");
        return modelAndView;
    }

    @GetMapping("/read")
    public ModelAndView readReport(@RequestParam("reportId") Integer reportId,
                                           ModelAndView modelAndView,Principal principal){


        Report report = reportService.findById(reportId);
        employeeService.markReportAsRead(report);

        modelAndView.clear();
        modelAndView.setViewName("report/unread");
        modelAndView.addObject("unreadReports",unreadReports(principal));
        return modelAndView;
    }


}
