package com.example.AjiNavi.service;

import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements RegistService{
    @Override
    public String regist() {
        return "登録が完了しました";
    }
}
