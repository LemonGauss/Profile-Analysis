package com.FinalProject.Controller;

import com.FinalProject.Servlet.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    @GetMapping("/getResume")
    public List GetResume()
    {
        return resumeService.getAllResume();
    }
}
