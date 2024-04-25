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


  @GetMapping("/result")
  public  String guess(@RequestParam int guess,Model model){
    Integer number = (Integer) model.getAttribute("number");
    String message;

    if(guess == number){
      message="Correct! The number was " + number + ". Start a new game!";
      initializeNumber(model); // Reset the number for a new game
    }else if( guess < number){
      message = "Too low !";
    }else{
      message ="Too high !";
    }

    model.addAttribute("message", message);
    return "result";

  }


  @GetMapping("/newgame")
public  String newGame(Model model){
    initializeNumber(model); // Explicitly start a new game
    return "redirect:/";
  }
}
