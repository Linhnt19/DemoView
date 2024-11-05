package com.example.detest.service.impl;

import com.example.detest.entity.Status;
import com.example.detest.repository.StatusRepository;
import com.example.detest.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;
    @Override
    public List<Status> getAllStatues() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Integer id) {
        return statusRepository.findById(id).get();
    }

}
