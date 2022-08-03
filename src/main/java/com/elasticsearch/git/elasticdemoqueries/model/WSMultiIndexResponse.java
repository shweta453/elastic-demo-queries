package com.elasticsearch.git.elasticdemoqueries.model;

import com.elasticsearch.git.elasticdemoqueries.entity.User;
import com.elasticsearch.git.elasticdemoqueries.entity.UserAddress;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class WSMultiIndexResponse extends RestResponse {

    private User user;
    private List<UserAddress> userAddresses = Collections.emptyList();
}