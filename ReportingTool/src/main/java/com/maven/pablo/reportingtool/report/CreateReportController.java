package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.email.EmailSender;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import com.maven.pablo.reportingtool.exceptions.ProjectNotFoundException;
import com.maven.pablo.reportingtool.files.Attachment;
import com.maven.pablo.reportingtool.files.FileDto;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;
import com.maven.pablo.reportingtool.report.implementation.ReportTimeRound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/report/create")
public class CreateReportController {

    private final EmailSender emailSender;
    private Attachment attachment;

    private ReportService reportService;
    private ProjectService projectService;
    private EmployeeService employeeService;
    private ProjectDetailsService projectDetailsService;

    private MyCompleteReport myCompleteReport;

    @Qualifier("myProjectMapper")
    private MyMapper<Project, ProjectDto> projectMapper;
    @Qualifier("myReportMapper")
    private MyMapper<Report, ReportDto> reportMapper;

    @Autowired
    public CreateReportController(EmailSender emailSender, Attachment attachment,
                                  ReportService reportService, ProjectService projectService,
                                  EmployeeService employeeService, ProjectDetailsService projectDetailsService, MyCompleteReport myCompleteReport, MyMapper<Project, ProjectDto> projectMapper,
                                  MyMapper<Report, ReportDto> reportMapper) {
        this.emailSender = emailSender;
        this.attachment = attachment;
        this.reportService = reportService;
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.projectDetailsService = projectDetailsService;
        this.myCompleteReport = myCompleteReport;
        this.projectMapper = projectMapper;
        this.reportMapper = reportMapper;
    }

    @ModelAttribute("fileList")
    private List<File> fileList(){
        return attachment.attachedFilesList() == null ?  Collections.emptyList() : attachment.attachedFilesList(); }

    @ModelAttribute("projectList")
    private List<ProjectDto> projectList(){
        return projectMapper.convertToDto(projectService.findAll());
    }

    @ModelAttribute("departmentList")
    private List<String> departmentList(){
        return reportService.departmentList();
    }

    @ModelAttribute("reportDto")
    private ReportDto reportDto(){
        return new ReportDto();
    }

    @ModelAttribute("unsentReports")
    private List<ReportDto> unsendReports(){
        return myCompleteReport.getReports();
    }

    @ModelAttribute("fileDto")
    private FileDto fileDto(){
        return new FileDto(); }

    @GetMapping("/")
    public ModelAndView createReport(ModelAndView modelAndView){
        modelAndView.setViewName("report/new");
        return modelAndView;
    }

    @PostMapping("/add-files")
    public ModelAndView applyDirectory(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,
                                       ModelAndView modelAndView) {
        attachment.save(uploadingFiles);
        modelAndView.addObject("fileList", fileList());
        modelAndView.setViewName("report/new");
        return modelAndView;
    }

    @GetMapping("/clear-attachment")
    public ModelAndView clearAttachment(ModelAndView modelAndView){
        attachment.clear();
        modelAndView.addObject("fileList", fileList());
        modelAndView.setViewName("report/new");
        return modelAndView;
    }

    @PostMapping("/add-report-part")
    public ModelAndView saveReportPart(@Valid @ModelAttribute("reportDto") ReportDto reportDto, BindingResult bindingResult,
                                       Principal principal, ModelAndView modelAndView ) throws ProjectNotFoundException, EmployeeNotFoundException {

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("report/new");
            return modelAndView; }

        Employee employee = employeeService.findByUsername(principal.getName());
        reportDto.setEmployee(employee);
        reportDto.setEmployeeId(employee.getId());
        reportDto.setTime(ReportTimeRound.round(reportDto.getTime(), new BigDecimal(0.5), RoundingMode.HALF_UP));

        Project project = projectService.findByNumber(reportDto.getProjectId());
        reportDto.setProject(project);

        reportDto.setId(myCompleteReport.getReports().size());
        myCompleteReport.addReport(reportDto);

        modelAndView.setViewName("report/new");
        return modelAndView;
    }

    @GetMapping("/send-report")
    public ModelAndView sendReport(ModelAndView modelAndView, Principal principal) throws EmployeeNotFoundException {

        List<Report> reports = reportMapper.newInstanceFromDto(myCompleteReport.getReports());

        reportService.save(reports);
        projectDetailsService.addHoursFromReport(reports);

        emailSender.sendEmail(myCompleteReport);
        myCompleteReport.clear();
        modelAndView.setViewName("report/new");
        return modelAndView;
    }

    @GetMapping("/delete-report-part")
    public ModelAndView deleteReportPart(@RequestParam("id")int id,
                                         ModelAndView modelAndView){
        myCompleteReport.getReports().remove(id);
        myCompleteReport.rearangeIds();
        modelAndView.setViewName("report/new");
        return modelAndView;
    }
}
