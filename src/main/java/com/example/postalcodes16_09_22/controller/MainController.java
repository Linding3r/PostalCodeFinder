package com.example.postalcodes16_09_22.controller;


import com.example.postalcodes16_09_22.services.DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {


  @GetMapping("/")
  public String homePage(Model model){
    return "homePage";
  }

  @PostMapping("/city")
  public String bmiPage(@RequestParam("postalCode") String postalCode, RedirectAttributes redirectAttributes){
    redirectAttributes.addAttribute("postalCode",postalCode);
    return "redirect:/city";
  }

  @GetMapping("/city")
  public String makeBMIPage(@RequestParam("postalCode") String postalCode, Model model){
    DTO dto = new DTO();
    model.addAttribute("postalCode", postalCode);
    model.addAttribute("city", dto.correctCity(postalCode));
    return "cityPage";
  }

}
