package com.damifan.test.pattern.filter;

import java.util.List;

/**
 * @author wanglei
 * @create 2017/10/31 15:30
 * <p>
 * TODO
 */
public interface Criteria {
    /**
     * meetCriteria
     *
     * @param persons
     * @return
     */
    public List<Person> meetCriteria(List<Person> persons);

}
