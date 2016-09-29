/**
 * 
 */
package com.glebow.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glebow.demo.domain.ActIdentifier;
import com.glebow.demo.domain.Identifier;
import com.glebow.demo.domain.Item;
import com.glebow.demo.domain.ItemIdentifierType;
import com.glebow.demo.domain.ItemMasterIdentifier;
import com.glebow.demo.repository.ACTIdentifierRepository;
import com.glebow.demo.repository.ItemMasterRepository;
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
    private ItemRepository itemRepo; 
    
    @Autowired
    private ACTIdentifierRepository actRepo;
    
    @Autowired
    private ItemMasterRepository itemMasterRepo;
    
    /**
     * Default 
     */
    public InitController() {
    }
    
    
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> createDefaultData(@RequestParam("numItems") int numItems) {
        ResponseEntity<String> retVal = null;
        for (int i = 0; i < numItems; i++ ) {
            Item item = new Item();
            item.setName("Item_" + i);
            item.setDescription(item.getName());
            
            //item.setIdentifiers(m);
            item.setLastModified(new Date());
            
            item = itemRepo.save(item);

            ActIdentifier actId = new ActIdentifier();
            actId.setIdentifier("ACT_" + i);
            actId.setItem(item);
            
            actId = actRepo.save(actId);
            
            ItemMasterIdentifier itemMasterId = new ItemMasterIdentifier();
            itemMasterId.setIdentifier("ITEM_MASTER_" + i);
            itemMasterId.setItem(item);
            
            itemMasterId = itemMasterRepo.save(itemMasterId);
            
            log.info("Saved item " + item.getId() + " and associated it with ACT ID " + actId.getId());
        }
        
        retVal = ResponseEntity.ok("Created " + numItems + " records");
        
        return retVal;
    }

}
