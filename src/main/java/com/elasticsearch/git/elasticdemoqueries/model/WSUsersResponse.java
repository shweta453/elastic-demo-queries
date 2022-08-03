package com.elasticsearch.git.elasticdemoqueries.model;

import com.elasticsearch.git.elasticdemoqueries.entity.User;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class WSUsersResponse extends RestResponse {
    private List<User> users = Collections.emptyList();
}