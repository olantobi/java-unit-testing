package com.liferon.springunittesting.controller;

import com.liferon.springunittesting.Type;
import com.liferon.springunittesting.service.CalculateArea;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AreaController {

    private final CalculateArea calculateArea;

    @GetMapping("api/area")
    @ResponseBody
    public ResponseEntity calculateArea(
        @RequestParam("type") String type,
        @RequestParam("param1") String param1,
        @RequestParam(value = "param2", required = false) String param2
                                       ) {
        try {
            Double area = calculateArea.calculateArea(
                Type.valueOf(type),
                Double.parseDouble(param1),
                Double.parseDouble(param2)
                                                     );
            return new ResponseEntity(area, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
