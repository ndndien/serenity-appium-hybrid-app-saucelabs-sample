package com.appium.serenirybdd.data;

import com.appium.serenirybdd.constants.AutomationConstants;
import com.appium.serenirybdd.data.models.Customer;
import com.appium.serenirybdd.error_hanlders.AutomationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DataManager {

    private DataManager(){
        // do nothing
    }

    private static final Logger LOGGER = Logger.getLogger(DataManager.class);
    private static final String DATA_FILE_PATH = AutomationConstants.USER_DIR + "/src/test/java/com/appium/serenirybdd/data/user_data.json";
    private static final File DATA_FILE = new File(DATA_FILE_PATH);
    private static Customer customer;

    public static Customer getCustomer(){
        if (customer == null){
            ObjectMapper mapper = new ObjectMapper();
            try {
                customer = mapper.readValue(DATA_FILE, Customer.class);
            } catch (JsonMappingException je){
                LOGGER.debug(je.getMessage());
                throw new AutomationException("An error has occurred while mapping json file to Object. Please check path and try again");
            } catch (IOException e) {
                LOGGER.debug(e.getMessage());
                throw new AutomationException("An error has occurred while reading data file at " + DATA_FILE_PATH + " . Please check path and try again");
            }
        }
        return customer;
    }
}
