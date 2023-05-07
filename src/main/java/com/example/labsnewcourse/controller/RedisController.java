package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.*;
import com.example.labsnewcourse.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/employee")
    public EmployeeDocumentRedis createDocument(@RequestBody EmployeeRedisDTO employeeRedisDTO) {
        return redisService.createDocument(employeeRedisDTO);
    }

    @PutMapping("/employee")
    public EmployeeDocumentRedis updateDocument(@RequestBody EmployeeRedisDTO employeeRedisDTO, @RequestParam String id) {
        return redisService.updateDocument(id, employeeRedisDTO);
    }

    @GetMapping("/employee")
    public EmployeeDocumentRedis view(@RequestParam String id) {
        return redisService.find(id);
    }
    @DeleteMapping("/employee")
    public SuccessDTOResponse deleteDocument(@RequestParam String id) {
        redisService.delete(id);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}

