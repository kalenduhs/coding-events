package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //private static List<String> events = new ArrayList<>();
    private HashMap<String, String> events = new HashMap<>();
//     events.put("Menteaship","A fun meetup for connecting with mentors");
//     events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
//     events.put("Javascripty", "An imaginary meetup for Javascript developers");

    @GetMapping
    public String methodName(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        events.put("Menteaship","A fun meetup for connecting with mentors");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        return "events/index";
    }

    @GetMapping("create")
    public String methodNameTwo(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String methodNameThree(@RequestParam String eventName, String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:/events"; //needs the /events
    }
}
