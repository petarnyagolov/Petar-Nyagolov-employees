package org.example.Controllers;

import org.example.Services.UploadCVSService;
import org.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.5.2022 г. Time: 11:29
 * <p>
 *  TODO: WRITE THE DESCRIPTION HERE
 *
 * @author petar
 */
@Controller
public class UploadCVSController
{
  private final UploadCVSService uploadService;
  @Autowired
  public UploadCVSController(UploadCVSService uploadService)
  {
    this.uploadService = uploadService;
  }
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException
  {
    modelMap.addAttribute("file", file);
//    List<List<String>> records = new ArrayList<>();
    List<Employee> result =uploadService.getWhoWorkedLongestPerProject(file);
    modelMap.addAttribute("results",result);
    return "index";
  }

  @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
  public String getHomePage(ModelMap modelMap) {
//    List<Employee> result =uploadService.getWhoWorkedLongestPerProject(file);
    modelMap.addAttribute("results",new ArrayList<Employee>());
    return "index";
  }
}
