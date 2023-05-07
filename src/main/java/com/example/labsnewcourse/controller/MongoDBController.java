package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.StudentMongoDTO;
import com.example.labsnewcourse.model.StudentMongoDocument;
import com.example.labsnewcourse.model.SuccessDTOResponse;
import com.example.labsnewcourse.model.BadResponseDTO;
import com.example.labsnewcourse.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/mongo")
public class MongoDBController {
    @Autowired
    private MongoDBService mongoDBService;

    @PostMapping("/student")
    public StudentMongoDocument createDocument(@RequestBody StudentMongoDTO studentMongoDTO) {
        return mongoDBService.create(studentMongoDTO);
    }

    @PutMapping("/student")
    public StudentMongoDocument updateDocument(@RequestBody StudentMongoDTO studentMongoDTO, @RequestParam String documentId) {
        return mongoDBService.update(documentId, studentMongoDTO);
    }

    @GetMapping("/student")
    public StudentMongoDocument findDocument(@RequestParam String documentId) {
        return mongoDBService.find(documentId);
    }

    @DeleteMapping("/student")
    public SuccessDTOResponse deleteDocument(@RequestParam String documentId) {
        mongoDBService.delete(documentId);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}
