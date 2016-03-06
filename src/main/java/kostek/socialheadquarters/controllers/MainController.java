package kostek.socialheadquarters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kostek on 01.03.16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage(){
        return "homepage";
    }
}
