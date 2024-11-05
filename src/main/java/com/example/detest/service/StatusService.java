package com.example.detest.service;

import com.example.detest.entity.Status;

import java.util.List;

public interface StatusService {

    List<Status> getAllStatues();
    Status findById(Integer id);

}
