package com.ssafy.rualone.domain.attraction.api;

import com.ssafy.rualone.domain.attraction.application.AttractionService;
import com.ssafy.rualone.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.ssafy.rualone.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction-management")
@Slf4j
public class AttractionApi {
    private AttractionService attractionService;

    // TODO : 자료에 대한 validation처리가 필요함
    @GetMapping("/attraction")
    public ApiResult<Void> getAttraction(@RequestParam(value="sidoCode", required=false) String sidoCode,
                                         @RequestParam(value="gugunCode", required=false) String gugunCode,
                                         @RequestParam(value="contentTypeId", required=false) String contentTypeId){
        attractionService.findAllByCriteria(sidoCode, gugunCode, contentTypeId);
        return OK(null);
    }
}
