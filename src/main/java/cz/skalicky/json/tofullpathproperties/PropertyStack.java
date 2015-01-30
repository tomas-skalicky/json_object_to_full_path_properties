package cz.skalicky.json.tofullpathproperties;

import java.util.ArrayDeque;

import org.apache.commons.lang3.StringUtils;

public class PropertyStack extends ArrayDeque<String> {

    private static final long serialVersionUID = 1L;
    
    private static final String PROPERTY_SEPARATOR = ".";

    @Override
    public String toString() {
        
        return StringUtils.join(toArray(), PROPERTY_SEPARATOR);
    }

}
