package com.qf.service;

import com.qf.pojo.Collect;

import java.util.List;

public interface CollectService {
    Collect selectByUidAndM3Id(Collect collect);

    int add(Collect collect);

    List<Collect> findall(Integer uid, Integer sid);
}
