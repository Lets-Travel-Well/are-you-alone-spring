package com.ssafy.rualone.domain.jounrney.api;

import com.ssafy.rualone.domain.attraction.application.AttractionService;
import com.ssafy.rualone.domain.jounrney.application.JourneyService;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyCreateRequest;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathCreateRequest;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathDto;
import com.ssafy.rualone.domain.jounrney.dto.response.JourneyPlacePathResponse;
import com.ssafy.rualone.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ssafy.rualone.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/journey-management")
@Slf4j
public class JourneyApi {
    private final JourneyService journeyService;
    private final AttractionService attractionService;

    @PostMapping("/journey/path")
    public ApiResult<List<JourneyPlacePathDto>> findShortestPath(@RequestBody List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest){
        List<JourneyPlacePathDto> journeyPlacePathDto = journeyPlacePathCreateRequest.stream()
                .map(temp -> new JourneyPlacePathDto(attractionService.findByContentId(temp.getContentId())))
                .collect(Collectors.toList());
        return OK(journeyService.findShortestPath(journeyPlacePathDto));
    }

    @PostMapping("/journey")
    public ApiResult<Void> createJourney(@RequestBody JourneyCreateRequest journeyCreateRequest){
        log.info(journeyCreateRequest.toString());
        Long memberId = 0L;
        journeyService.save(journeyCreateRequest, memberId);
        return OK(null);
    }
}
