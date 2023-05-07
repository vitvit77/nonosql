package com.example.labsnewcourse.service;

import com.example.labsnewcourse.model.*;
import com.example.labsnewcourse.repository.RedisObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisService {
    @Autowired
    public RedisObjectRepository redisObjectRepository;

    public void executeRedisCommand(RedisObjectDTO redisObjectDTO, Operation operation){
        switch (operation) {
            case CREATE:
//                RedisObject redisObject = new RedisObject();
//                redisObject.setId(redisObjectDTO.getId());
//                redisObject.setName(redisObjectDTO.getName());
//                redisObject.setNumber(redisObjectDTO.getNumber());
//                redisObjectRepository.save(redisObject);
                break;
            case DELETE:
                redisObjectRepository.deleteById(redisObjectDTO.getId());
                break;
            case UPDATE:
//                Optional<RedisObject> optionalRedisObject = redisObjectRepository.findById(redisObjectDTO.getId());
//                if (optionalRedisObject.isPresent()) {
//                    RedisObject redisObjectToUpdate = optionalRedisObject.get();
//                    redisObjectToUpdate.setId(redisObjectDTO.getId());
//                    redisObjectToUpdate.setName(redisObjectDTO.getName());
//                    redisObjectToUpdate.setNumber(redisObjectDTO.getNumber());
//                    redisObjectRepository.save(redisObjectToUpdate);
//                }
                break;
        }
    }

//    public RedisObjectDTO findRedisEntity(String id) {
//        Optional<RedisObject> optionalRedisObject = redisObjectRepository.findById(id);
//        if (optionalRedisObject.isPresent()) {
//            RedisObject redisObject = optionalRedisObject.get();
//            RedisObjectDTO redisObjectDTO = new RedisObjectDTO();
//            redisObjectDTO.setId(redisObject.getId());
//            redisObjectDTO.setName(redisObject.getName());
//            redisObjectDTO.setNumber(redisObject.getNumber());
//            return redisObjectDTO;
//        }
//        return null;
//    }

    public EmployeeDocumentRedis createDocument(EmployeeRedisDTO employeeRedisDTO) {
        EmployeeDocumentRedis employeeDocumentRedis = new EmployeeDocumentRedis();
        employeeDocumentRedis.setName(employeeRedisDTO.getName());
        employeeDocumentRedis.setAge(employeeRedisDTO.getAge());
        employeeDocumentRedis.setDepartment(employeeRedisDTO.getDepartment());
        employeeDocumentRedis.setSalary(employeeRedisDTO.getSalary());
        return redisObjectRepository.save(employeeDocumentRedis);
    }

    public EmployeeDocumentRedis updateDocument(String id, EmployeeRedisDTO employeeRedisDTO) {
        Optional<EmployeeDocumentRedis> optionalEmployeeDocumentRedis = Optional.ofNullable(this.find(id));
        if (optionalEmployeeDocumentRedis.isPresent()) {
            EmployeeDocumentRedis employeeDocumentRedis = new EmployeeDocumentRedis();
            employeeDocumentRedis.setId(id);
            employeeDocumentRedis.setName(employeeRedisDTO.getName());
            employeeDocumentRedis.setAge(employeeRedisDTO.getAge());
            employeeDocumentRedis.setDepartment(employeeRedisDTO.getDepartment());
            employeeDocumentRedis.setSalary(employeeRedisDTO.getSalary());
            return redisObjectRepository.save(employeeDocumentRedis);
        }
        return null;
    }

    public EmployeeDocumentRedis find(String id) {
        Optional<EmployeeDocumentRedis> optionalEmployeeDocumentRedis = redisObjectRepository.findById(id);
        if (optionalEmployeeDocumentRedis.isPresent()) {
            EmployeeDocumentRedis employeeDocumentRedis = optionalEmployeeDocumentRedis.get();
            return employeeDocumentRedis;
        }
        return null;
    }

    public void delete(String id) {
        redisObjectRepository.deleteById(id);
    }
}
