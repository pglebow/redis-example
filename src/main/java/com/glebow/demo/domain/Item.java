/**
 * 
 */
package com.glebow.demo.domain;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pglebow
 *
 */
@RedisHash("items")
@Data
@NoArgsConstructor
public class Item {

    @Id
    private String id; 

    @Indexed
    private String name;
    
    @Indexed
    private String description;    
    
    @LastModifiedDate
    private Date lastModified;
    
    @Indexed
    private Map<String, String> identifiers;
    
}
