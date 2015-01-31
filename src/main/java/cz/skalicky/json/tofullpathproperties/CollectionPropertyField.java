package cz.skalicky.json.tofullpathproperties;

import java.lang.reflect.Field;

public class CollectionPropertyField extends PropertyField {

    private static final String INDEX_SUFFIX = "[0]";

    public CollectionPropertyField(final Field field) {
        super(field);
    }

    @Override
    public String getName() {
        return super.getName() + INDEX_SUFFIX;
    }

    @Override
    public String getGermanName() {
        return super.getGermanName() + INDEX_SUFFIX;
    }

}
