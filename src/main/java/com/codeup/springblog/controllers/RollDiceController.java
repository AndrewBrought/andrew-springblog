package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String viewRollDice() { return "roll-dice"; }



@GetMapping("/roll-dice/{n}")
public String viewResults(@PathVariable int n, Model model) {
    int diceRoll = (int) (Math.random() * 6) + 1;
    String message;

    if(diceRoll == n){
        message = "You nailed it!";
    } else {
        message = "Not so much...";
    }

    model.addAttribute("n", n);
    model.addAttribute("diceRoll", diceRoll);
    model.addAttribute("message", message);

        return "dice-outcome";
}

}