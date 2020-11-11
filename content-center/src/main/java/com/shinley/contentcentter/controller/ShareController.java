package com.shinley.contentcentter.controller;

import com.shinley.contentcentter.dao.ShareMapper;
import com.shinley.contentcentter.dto.ShareDto;
import com.shinley.contentcentter.entity.Share;
import com.shinley.contentcentter.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public ShareDto findById(@PathVariable Integer id) {
        return this.shareService.findById(id);
    }


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
