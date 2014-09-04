package uk.police.data.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    
    private Util(){}
    
    /**
     * Return a String formatted as yyyy-MM
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        if(date == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }
}

