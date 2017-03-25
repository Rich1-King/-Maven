package com.boot.model.vo;

import org.springframework.data.domain.PageRequest;

/**
 * Created by rich1 on 9/10/16.
 */
public class Filter extends PageRequest{

    public Filter(int page,int size){
        super(page,size);
    }
}
