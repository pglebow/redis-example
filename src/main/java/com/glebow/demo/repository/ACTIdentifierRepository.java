/**
 * 
 */
package com.glebow.demo.repository;

import java.util.List;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.query.Param;

import com.glebow.demo.domain.ActIdentifier;

/**
 * @author pglebow
 *
 */
public interface ACTIdentifierRepository extends KeyValueRepository<ActIdentifier, String> {

    List<ActIdentifier> findByActIdentifier(@Param("identifier") String actIdentifier);
}
