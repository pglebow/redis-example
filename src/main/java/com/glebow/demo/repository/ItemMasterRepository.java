/**
 * 
 */
package com.glebow.demo.repository;

import java.util.List;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.query.Param;

import com.glebow.demo.domain.ItemMasterIdentifier;

/**
 * @author pglebow
 *
 */
public interface ItemMasterRepository extends KeyValueRepository<ItemMasterIdentifier, String> {

    List<ItemMasterIdentifier> findByItemMasterIdentifier(@Param("identifier") String actIdentifier);
}
