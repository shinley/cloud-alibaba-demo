package com.shinley.contentcentter.dao;

import com.shinley.contentcentter.entity.Share;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ShareMapper extends Mapper<Share> {
}