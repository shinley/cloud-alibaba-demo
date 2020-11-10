package com.shinley.contenter.dao;

import com.shinley.contenter.entity.Share;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ShareMapper extends Mapper<Share> {
}