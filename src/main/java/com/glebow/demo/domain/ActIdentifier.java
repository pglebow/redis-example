/**
 * 
 */
package com.glebow.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pglebow
 *
 */
@RedisHash("actIdentifiers")
@Data
@NoArgsConstructor
public class ActIdentifier implements Identifier {

    @Id
    private String id;

    @Indexed
    private String identifier;

    @Indexed
    @Reference
    private Item item;
}
