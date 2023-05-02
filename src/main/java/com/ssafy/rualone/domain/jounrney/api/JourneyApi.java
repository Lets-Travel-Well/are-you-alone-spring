package com.ssafy.rualone.domain.jounrney.api;

import com.ssafy.rualone.domain.attraction.application.AttractionService;
import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.jounrney.application.JourneyService;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyCreateRequest;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathCreateRequest;
import com.ssafy.rualone.domain.jounrney.dto.response.JourneyPlacePathResponse;
import com.ssafy.rualone.domain.jounrney.entity.Journey;
import com.ssafy.rualone.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.rualone.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/journey-management")
@Slf4j
public class JourneyApi {
    private final JourneyService journeyService;
    private final AttractionService attractionService;

    @PostMapping("/journey/path")
    public ApiResult<List<JourneyPlacePathResponse>> findShortestPath(@RequestBody List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest){
        for(JourneyPlacePathCreateRequest temp : journeyPlacePathCreateRequest){
            AttractionInfo t =  attractionService.findByContentId(temp.getContentId());
            log.info(t.toString());
        }
        return OK(null);
    }

    @PostMapping("/journey")
    public ApiResult<Void> createJourney(@RequestBody JourneyCreateRequest journeyCreateRequest){
        log.info(journeyCreateRequest.toString());
        return OK(null);
    }
}
