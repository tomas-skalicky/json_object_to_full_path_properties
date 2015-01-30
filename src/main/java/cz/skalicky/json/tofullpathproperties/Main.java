package cz.skalicky.json.tofullpathproperties;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.google.common.collect.ImmutableSet;

import cz.skalicky.json.tofullpathproperties.model.ContactInfo;
import cz.skalicky.json.tofullpathproperties.model.Customer;
import cz.skalicky.json.tofullpathproperties.model.Person;
import cz.skalicky.json.tofullpathproperties.model.Phone;

public class Main {

    // @formatter:off
    private static final Set<Class<?>> terminals = ImmutableSet.<Class<?>>builder()
            .add(boolean.class)
            .add(Boolean.class)
            .add(short.class)
            .add(Short.class)
            .add(int.class)
            .add(Integer.class)
            .add(long.class)
            .add(Long.class)
            .add(String.class)
            .add(BigDecimal.class)
            .build();
    // @formatter:on

    public static void main(String[] args) {
        generateJsonObjectToConsole();
        generateFullPathsToConsole();
    }

    private static void generateJsonObjectToConsole() {
        System.out.println(JsonUtil.toFormattedString(mockPerson()));
    }

    private static Person mockPerson() {

        final Person person = new Person();
        person.setContactInfo(new ContactInfo());
        person.getContactInfo().setPrivatePhone(new Phone());
        return person;
    }

    private static final PropertyStack propertyStack = new PropertyStack();
    private static final List<String> fullPaths = new ArrayList<String>();

    private static void generateFullPathsToConsole() {
        propertyStack.add("tomas");
        generateFullPaths(Customer.class);
        Collections.sort(fullPaths);
        fullPaths.stream().forEach(System.out::println);
    }

    private static <T> void generateFullPaths(final Class<T> clazz) {

        final Set<Field> fields = getAllNotStaticFields(clazz);

        for (Field field : fields) {
            processField(field);
        }
    }

    private static <T> Set<Field> getAllNotStaticFields(final Class<T> clazz) {

        // @formatter:off
        return FieldUtils.getAllFieldsList(clazz).stream()
                .filter(f -> !Modifier.isStatic(f.getModifiers()))
                .collect(Collectors.toSet());
        // @formatter:on
    }

    private static void processField(final Field field) {

        final Class<?> fieldType = field.getType();

        if (Collection.class.isAssignableFrom(fieldType)) {
            @SuppressWarnings("unchecked")
            final Class<Collection<?>> collectionClass = (Class<Collection<?>>) fieldType;
            processCollectionField(collectionClass, field);

        } else if (fieldType.isArray()) {
            throw new RuntimeException("arrays are not support yet");

        } else {

            propertyStack.add(field.getName());

            if (terminals.contains(fieldType) || Enum.class.isAssignableFrom(fieldType)) {
                fullPaths.add(propertyStack.toString());
            } else {
                generateFullPaths(fieldType);
            }

            propertyStack.pollLast();
        }
    }

    private static <T extends Collection<?>> void processCollectionField(final Class<T> collectionClass,
            final Field field) {

        if (collectionClass.isAssignableFrom(List.class)) {
            Type genericType = field.getGenericType();

            if (genericType instanceof ParameterizedType) {
                final Class<?> firstArgumentType = (Class<?>) ((ParameterizedType) genericType)
                        .getActualTypeArguments()[0];

                propertyStack.add(field.getName() + "[0]");
                generateFullPaths(firstArgumentType);
                propertyStack.pollLast();

            } else {
                throw new RuntimeException("no support of non-generic lists");
            }

        } else {
            throw new RuntimeException("no support of type of field: " + field.getName());
        }
    }

}
