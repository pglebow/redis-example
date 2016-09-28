/**
 * 
 */
package com.glebow.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glebow.demo.domain.Item;
import com.glebow.demo.domain.ItemIdentifierType;
import com.glebow.demo.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pglebow
 *
 */
@Controller()
@RequestMapping(path = "/init")
@Slf4j
public class InitController {

    @Autowired
    private ItemRepository repo; 
    
    private final static int NUM_RECORDS = 20000;
    
    /**
     * Default 
     */
    public InitController() {
    }
    
    
    @GetMapping
    public void createDefaultData() {
        Set<Item> items = new HashSet<>(NUM_RECORDS);
        for (int i = 0; i < NUM_RECORDS; i++ ) {
            Item item = new Item();
            item.setName("Item_" + i);
            item.setDescription(item.getName());
            
            Map<String, String> m = new HashMap<>();
            m.put(ItemIdentifierType.ACT.toString(), "ACT_" + i);
            m.put(ItemIdentifierType.CGI.toString(), "CGI_" + i);
            m.put(ItemIdentifierType.EGI.toString(), "EGI_" + i);
            m.put(ItemIdentifierType.ITEM_MASTER.toString(), "ITEM_MASTER_" + i);
            m.put(ItemIdentifierType.PFI.toString(), "PFI_" + i);
            m.put(ItemIdentifierType.RETAIL_STYLE.toString(), "RETAIL_STYLE_" + i);

            item.setIdentifiers(m);
            item.setLastModified(new Date());
            
            items.add(item);
        }
        
        log.info("Starting save of " + items.size() + " items");
        repo.save(items);
        log.info("Finished save of " + items.size() + " items");
    }

}
