package com.ssafy.rualone.domain.attraction.api;

import com.ssafy.rualone.domain.attraction.application.AttractionService;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;
import com.ssafy.rualone.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.ssafy.rualone.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction-management")
@Slf4j
public class AttractionApi {
    private final AttractionService attractionService;

    // TODO : 자료에 대한 validation처리가 필요함
    @GetMapping("/attraction")
    public ApiResult<Void> getAttraction(@RequestParam(value="sidoCode", required=false) String sidoCode,
                                         @RequestParam(value="gugunCode", required=false) String gugunCode,
                                         @RequestParam(value="contentTypeId", required=false) String contentTypeId){
        attractionService.findAllByCriteria(sidoCode, gugunCode, contentTypeId);
        return OK(null);
    }
    @GetMapping("/sido")
    public ApiResult<List<Sido>> getSido() {
        return OK(attractionService.findSido());
    }
    @GetMapping("/gugun/{sidoCode}")
    public ApiResult<List<Gugun>> getGugun(@PathVariable int sidoCode) {
        return OK(attractionService.findGugunBySido(sidoCode));
    }
}
