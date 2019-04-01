package com.zyz.shopping.dao;

import com.zyz.shopping.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findByUserId(Integer userId);
}
