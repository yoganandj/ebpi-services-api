package com.ebpi.sample.services.platform.resource;

import com.yoganand.platform.services.ebpi.common.resource.Hr;
import com.yoganand.platform.services.ebpi.common.v1.Person;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

public class HrIml implements Hr {
    public static Map<String,Person> personMap = new HashMap<String, Person>();
    static{
        DatatypeFactory datatypeFactory = null;
        try {
            datatypeFactory = DatatypeFactory.newInstance();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(System.currentTimeMillis());
            XMLGregorianCalendar dateTime = datatypeFactory.newXMLGregorianCalendar(gc);
            Person.Address address = new Person.Address();
            address.setHouseNo(123);
            address.setPostCode("560103");

            Person person  = new Person();
            person.setId("901");
            person.setBalance(1000);
            person.setAccountNumber("AxisBank01");
            person.setName("yoganand");
            person.setDateOfBirth(dateTime);
            person.setAddress(address);

            personMap.put(person.getId(),person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response getHr(HttpServletResponse httpServletResponse) {

        List<Person> personList = new ArrayList<Person>();

        for(String id :personMap.keySet()){
            personList.add(personMap.get(id));
        }

        return Response.ok(personList).build();
    }

    public Response putHr(Person person, HttpServletResponse httpServletResponse) {

        personMap.put(person.getId(),person);

        return Response.noContent().build();
    }

    public Response getHrByPersonId(String personId, HttpServletResponse httpServletResponse) {

        return Response.ok(personMap.get(personId)).build();
    }

    public Response getHrWithdrawByPersonIdAndAmount(String personId, String amount, javax.servlet.http.HttpServletResponse httpServletResponse) {
        Person person = personMap.get(personId);
        double balance = person.getBalance();
        if(balance>0){
            balance = balance - Double.parseDouble(amount);
            person.setBalance(balance);
        }
        return Response.ok(balance).build();
    }
}
