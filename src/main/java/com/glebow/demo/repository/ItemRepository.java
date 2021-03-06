/**
 * 
 */
package com.glebow.demo.repository;

import java.util.List;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.query.Param;

import com.glebow.demo.domain.Item;

/**
 * Items
 * 
 * @author pglebow
 *
 */
public interface ItemRepository extends KeyValueRepository<Item, String> {

    List<Item> findByName(@Param("name") String name);
}
