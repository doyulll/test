package com.example.quick.Service;

import com.example.quick.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickService{
    public boolean registerItem(ItemDto itemDto){
        log.info("Service...");
        return true;
    }
}