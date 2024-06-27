package com.example.quick.controller;

import com.example.quick.Service.QuickService;
import com.example.quick.dto.ItemDto;
import com.example.quick.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class quickController {

    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy");
        return "2";
    }


    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);
        return "ok";
    }

    //@PostMapping은 @RequestBody필수
    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);

        boolean b = quickService.registerItem(item);
        if (b == true) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;

    }
}

    /*자 근데 데이터들은 제이슨 ({"id": "asfa"})으로 주고 받는데
    그걸 만들려면 DTO를 만들어야 한다 그래서 패키지를 또 만들고 이름은 DTO로 함.
     */
    /*자 만들고 나서 위 레지스터아이템을 @RequestBody String item 대신
    @RequestBody ItemDto item 로 한다 이때 반드시 치다가 나온걸 탭해준다 안그럼 없는 심볼이라 뜬다
     */
    /* 자이제 새롭게 보자. 리턴값을 제이슨형태로 보내야 되기 때문에 번거로우니 이번엔 리스폰스DTO를 만든다
    그리고 이번엔 public String registerItem대신 public ResponseDto registerItem 로 해준다
    이것도 마찬가지로 치다가 나온걸 탭해준다
    그리고 return을 지우고 대신 new ResponseDto(); 를 치고 Art+Enter 하고 두번째꺼치고 그 다음에 셋메시지와 라턴값입력
     */
    /*이제 스웨거에 다시 들어가면 제이슨형태로 나오고 리스폰스도 나온다
     */

    /*(7장) 자 이제 서비스를 만들고 컨트롤러를 서비스에다 호출를 해줘야 한다

     */
