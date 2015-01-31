package cz.skalicky.json.tofullpathproperties;

import java.lang.reflect.Field;

/**
 * Wrapper of {@link Field} class.
 * <p>
 * Immutable class
 */
public class PropertyField {

    private final Field field;

    public PropertyField(final Field field) {
        this.field = field;
    }

    /**
     * Wraps the {@link Field#getName()} method.
     */
    public String getFieldName() {
        return field.getName();
    }

    /**
     * @return Same as {@link #getFieldName()}
     */
    public String getName() {
        return getFieldName();
    }

    /**
     * @return value of @{@link German} annotation if the field is annotated with this annotation.
     *         <code>null</code> otherwise
     */
    public String getGermanName() {
        final German annotation = field.getAnnotation(German.class);
        if (annotation == null) {
            return null;
        } else {
            return annotation.value();
        }
    }

}
