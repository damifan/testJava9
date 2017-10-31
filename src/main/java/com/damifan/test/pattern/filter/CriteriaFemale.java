package com.damifan.test.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 * @create 2017/10/31 15:31
 * <p>
 * TODO
 */
public class CriteriaFemale implements Criteria {
    /**
     * meetCriteria
     *
     * @param persons
     * @return
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> feMalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                feMalePersons.add(person);
            }
        }
        return feMalePersons;
    }
}
