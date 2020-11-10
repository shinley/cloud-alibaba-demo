package com.shinley.contenter.service;

import com.shinley.contenter.dao.ShareMapper;
import com.shinley.contenter.entity.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;

    public Share findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(
                "http://localhost:8081/users/{id}",
                String.class,
                1
        );
        return null;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(
                "http://localhost:8081/users/{id}",
                String.class,
                1
        );
        System.out.println(forObject);
    }
}
