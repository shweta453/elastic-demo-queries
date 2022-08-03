package com.elasticsearch.git.elasticdemoqueries.repository;

import com.elasticsearch.git.elasticdemoqueries.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

}
