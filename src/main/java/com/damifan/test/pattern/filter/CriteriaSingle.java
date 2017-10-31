package com.damifan.test.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 * @create 2017/10/31 15:31
 * <p>
 * TODO
 */
public class CriteriaSingle implements Criteria {
    /**
     * meetCriteria
     *
     * @param persons
     * @return
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("SINGLE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
