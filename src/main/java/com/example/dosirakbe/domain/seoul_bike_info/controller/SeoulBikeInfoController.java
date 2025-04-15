package com.example.dosirakbe.domain.seoul_bike_info.controller;

import com.example.dosirakbe.domain.seoul_bike_info.dto.response.SeoulBikeInfoResponse;
import com.example.dosirakbe.domain.seoul_bike_info.service.SeoulBikeInfoService;
import com.github.hyeonjaez.springcommon.response.ApiResponse;
import com.github.hyeonjaez.springcommon.response.ApiResponseUtil;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seoul-bike-info")
public class SeoulBikeInfoController {
    private final SeoulBikeInfoService seoulBikeInfoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SeoulBikeInfoResponse>>> getSeoulBikeListByAroundMe(@RequestParam(required = true) @NotNull BigDecimal myLatitude,
                                                                                               @RequestParam(required = true) @NotNull BigDecimal myLongitude) {
        List<SeoulBikeInfoResponse> seoulBikeListAroundMe = seoulBikeInfoService.getSeoulBikeListAroundMe(myLatitude, myLongitude);
        return ApiResponseUtil.ok("seoul bike list by around me retrieved successfully", seoulBikeListAroundMe);

    }
}
