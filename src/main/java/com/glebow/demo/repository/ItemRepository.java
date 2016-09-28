/**
 * 
 */
package com.glebow.demo.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

import com.glebow.demo.domain.Item;

/**
 * Items
 * @author pglebow
 *
 */
public interface ItemRepository extends KeyValueRepository<Item, String> {

}
