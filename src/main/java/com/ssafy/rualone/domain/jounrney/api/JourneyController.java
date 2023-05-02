package com.ssafy.rualone.domain.jounrney.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/journey")
public class JourneyController {
    @GetMapping("/search")
    public String search(){
        return "attraction/search-place";
    }
}
