package com.foodtracker.foodtrackerapi.resources;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.foodtracker.foodtrackerapi.Constants;
import com.foodtracker.foodtrackerapi.models.BarcodeProduct;
import com.foodtracker.foodtrackerapi.services.BarcodeRestService;

import org.apache.logging.log4j.LogManager;

/**
 * Retrieve barcode information from Edamam API by barcode code.
 * @author Janina Mattes
 */
@RestController
@RequestMapping("/api/barcode/rest")
public class BarcodeRestResource {
    
    private static Logger logger = LogManager.getLogger(BarcodeRestResource.class);

    @Autowired
    BarcodeRestService barcodeService;

    @GetMapping(path = "/{barcodeCode}", produces = "application/json")
    public ResponseEntity<Optional<BarcodeProduct>> getProductFromBarcode(@PathVariable("barcodeCode") String barcodeCode) {
        Optional<BarcodeProduct> product = barcodeService.getProduct(Constants.EDAMAM_APP_ID, Constants.EDAMAM_BARCODE_API_KEY, barcodeCode);
        logger.debug("Retrieved product from Edamam API: " + product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
