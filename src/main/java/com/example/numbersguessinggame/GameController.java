package com.example.numbersguessinggame;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("number")
public class GameController {

  private Random random = new Random();

// Initialize or reset the number
  private void initializeNumber(Model model) {
    int number = random.nextInt(100)+1;
    model.addAttribute("number", number);
    System.out.println("New number: " + number); // for developer to cheat ;)
  }


@GetMapping("/")
  public String index(Model model){
    if(!model.containsAttribute("number")){
      initializeNumber(model);
    }
  return "index";
}


  @GetMapping("/guess")
  public  String guess(@RequestParam int guess,Model model){
    // We will add our logic here
  }

}
