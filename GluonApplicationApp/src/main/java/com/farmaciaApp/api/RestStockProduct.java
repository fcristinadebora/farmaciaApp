/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmaciaApp.api;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author debs
 */
public class RestStockProduct {
    
    public static JSONArray listStockProduct(){
        try { 
            return HttpConn.sendGet("http://debs-v31014isk:8080/farmacia/rest/StockProduct/getStockProduct");
        } catch (Exception ex) {
            Logger.getLogger(RestStockProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
