package com.example.dosirakbe.domain.salestore.controller;

import com.example.dosirakbe.domain.salestore.entity.SaleStore;
import com.example.dosirakbe.domain.salestore.service.SaleStoreService;
import com.github.hyeonjaez.springcommon.response.ApiResponse;
import com.github.hyeonjaez.springcommon.response.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName    : com.example.dosirakbe.domain.salestore.controller<br>
 * fileName       : SaleStoreController<br>
 * author         : yyujin1231<br>
 * date           : 11/08/24<br>
 * description    : 마감음식을 판매하는 가게 관련 정보를 처리하는 CRUD controller 클래스 입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 11/08/24        yyujin1231                최초 생성<br>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/salestores")
public class SaleStoreController {

    private final SaleStoreService saleStoreService;

    /**
     * 사용자의 현재 주소를 기반으로 마감음식을 판매하는 가게 목록을 조회합니다.
     * <p>
     * 이 메서드는 클라이언트의 주소 정보를 기반으로 데이터베이스에서
     * 마감음식을 판매하는 가게 목록을 검색하여 반환합니다.
     * </p>
     *
     * @param address 검색할 주소 문자열
     * @return 마감음식을 판매하는 가게 목록을 포함한 {@link ApiResponse} 형태의 {@link List}
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SaleStore>>> getStoresByAddress(@RequestParam("address") String address) {
        List<SaleStore> stores = saleStoreService.getSaleStoresByAddress(address);

        return ApiResponseUtil.ok("마감음식 판매 가게 반환", stores);
    }


}