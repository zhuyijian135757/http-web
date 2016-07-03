package net.flyingfat.web.booter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Booter {

  private static Logger logger = LoggerFactory.getLogger(Booter.class);

  public static void main(String[] args) {
    EmbbedTomcat.main(args);
    logger.info("joy ads cmp server started... ");

  }
  
} 
