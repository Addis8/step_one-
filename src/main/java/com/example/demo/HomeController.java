package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
public class HomeController{
    @Autowired
    MessagRepository messagRepository;

    @RequestMapping("/")
    public String listMessage(Model model) {
        model.addAttribute("Steps", messagRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String stepForm(Model model){
        model.addAttribute("step", new Step());
        return "stepform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Step step,
                              BindingResult result){
        if(result.hasErrors()){
            return "processform";
       }
        messagRepository.save(step);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("step", messagRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("update/{id}")
    public String updateCourse(@PathVariable("id") long id,
                               Model model){
        model.addAttribute("step", messagRepository.findById(id).get());
        return "stepform";
    }
    @RequestMapping("/delet/{id}")
    public String delcourse(@PathVariable("id") long id){
        messagRepository.deleteById(id);
        return "redirect:/";
    }
}
