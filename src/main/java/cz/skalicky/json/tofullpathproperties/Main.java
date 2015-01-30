package cz.skalicky.json.tofullpathproperties;

import cz.skalicky.json.tofullpathproperties.model.ContactInfo;
import cz.skalicky.json.tofullpathproperties.model.Person;
import cz.skalicky.json.tofullpathproperties.model.Phone;

public class Main {

    public static void main(String[] args) {
        
        System.out.println(JsonUtil.toFormattedString(mockPerson()));
    }
    
    private static Person mockPerson() {
        
        final Person person = new Person();
        person.setContactInfo(new ContactInfo());
        person.getContactInfo().setPrivatePhone(new Phone());
        return person;
    }
}
