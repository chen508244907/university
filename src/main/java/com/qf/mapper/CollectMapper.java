package com.qf.mapper;

import com.qf.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectMapper {
    Collect selectByUidAndM3Id(Collect collect);

    int add(Collect collect);

    List<Collect> findall(Collect collect);

    int del(Integer id);

    int delByUid(int id);
}
