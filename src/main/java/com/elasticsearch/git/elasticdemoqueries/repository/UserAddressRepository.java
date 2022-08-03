package com.elasticsearch.git.elasticdemoqueries.repository;

import com.elasticsearch.git.elasticdemoqueries.entity.UserAddress;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends ElasticsearchRepository<UserAddress, String> {

}
