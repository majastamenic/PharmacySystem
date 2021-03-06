package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.service.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private IReportService reportService;

    @PostMapping("/add")
    public Report save(@RequestBody Report report) { return reportService.save(report); }

    @GetMapping
    public List<Report> getAll() { return reportService.getAll(); }
}
