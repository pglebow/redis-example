/**
 * 
 */
package com.glebow.demo.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
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
public class Item implements Identifier {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String description;

    @Indexed
    private Date lastModified;
}
