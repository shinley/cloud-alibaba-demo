package com.shinley.contentcentter.service;

import com.shinley.contentcentter.dao.ShareMapper;
import com.shinley.contentcentter.dto.ShareDto;
import com.shinley.contentcentter.dto.UserDto;
import com.shinley.contentcentter.entity.Share;
import com.shinley.contentcentter.feignapi.UserCenterFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserCenterFeignClient userCenterFeignClient;

    public ShareDto findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

//        UserDto userDto = restTemplate.getForObject(
//                "http://localhost:8081/users/{id}",
//                UserDto.class,
//                userId
//        );
        UserDto userDto = userCenterFeignClient.findById(userId);
        // 消息的装配
        ShareDto shareDto = new ShareDto();
        BeanUtils.copyProperties(share, shareDto);
        shareDto.setWxNickname(userDto.getWxNickname());
        return shareDto;
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
