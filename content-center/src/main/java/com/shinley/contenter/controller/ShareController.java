package com.shinley.contenter.controller;

import com.shinley.contenter.dao.ShareMapper;
import com.shinley.contenter.entity.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ShareController {

    @Autowired
    private ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> testInsert() {
        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("Xxx");
        share.setCover("xxx");
        share.setAuthor("大目");
        share.setBuyCount(1);
        this.shareMapper.insertSelective(share);
        List<Share> shares = this.shareMapper.selectAll();
        return shares;
    }
}
