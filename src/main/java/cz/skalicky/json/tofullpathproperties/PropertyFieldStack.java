package cz.skalicky.json.tofullpathproperties;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class PropertyFieldStack extends ArrayDeque<PropertyField> {

    private static final long serialVersionUID = 1L;

    private static final String PROPERTY_SEPARATOR = ".";

    @Override
    public String toString() {

        return Arrays.stream(toArray(new PropertyField[size()])).map(f -> f.getName())
                .reduce("application", (a, b) -> StringUtils.join(Arrays.asList(a, b), PROPERTY_SEPARATOR));
    }

    public String toGermanString() {

        return Arrays
                .stream(toArray(new PropertyField[size()]))
                .map(f -> {
                    final String germanName = f.getGermanName();
                    if (germanName == null) {
                        throw new RuntimeException(String.format(
                                "field [%s] is not annotated with @German annotation", f.getName()));
                    }
                    return germanName;
                }).reduce("anwendung", (a, b) -> StringUtils.join(Arrays.asList(a, b), PROPERTY_SEPARATOR));
    }
}
