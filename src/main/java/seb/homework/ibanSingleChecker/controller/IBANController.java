package seb.homework.ibanSingleChecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import seb.homework.ibanSingleChecker.dto.Response;
import seb.homework.ibanSingleChecker.service.IBANService;

@Controller
public class IBANController {
    private final IBANService ibanService;

    public IBANController(@Autowired IBANService ibanService) {
        this.ibanService = ibanService;
    }

    @GetMapping("/")
    public String inputForm(Model model) {
        model.addAttribute("response", new Response());
        return "index";
    }

    @PostMapping("/")
    public String inputSubmit(@ModelAttribute Response response, Model model) {
        boolean isValid = ibanService.checkIfValid(response.getContent());
        boolean belongToSeb = ibanService.checkIfBelongsToSEB(response.getContent());

        response.setBelongToSEB(belongToSeb);
        response.setIsValid(isValid);

        model.addAttribute("response", response);
        return "result";
    }
}
