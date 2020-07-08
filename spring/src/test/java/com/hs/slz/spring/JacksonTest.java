package com.hs.slz.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * @author zhengsl26931
 */
public class JacksonTest {

    static String objJson = "{\"name\":\"Mahesh Kumar\",\"age\":21,\"verified\":false,\"marks\":[100,90,85]}";
    static String complexJson = "{\"message\":\"success\",\"code\":200,"
        + "\"customers\":[{\"name\":\"Mahesh Kumar\",\"age\":21,\"verified\":false,\"marks\":[100,90,85]},"
        + "{\"name\":\"zhangsan\",\"age\":88,\"verified\":true,\"marks\":[11,22,33]}]}";

    @Test
    public void sorting() {
        List<Customer> customers=new ArrayList<>();
        customers.add(new Customer("zhangsan",88));
        customers.add(new Customer("lisi",13));
        customers.add(new Customer("wangwu",33));
        Collections.sort(customers,(x,y)->{
            return x.age-y.age;
        });
        System.out.println(customers);
    }

    @Test
    public void parseObj() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(objJson, Customer.class);
        System.out.println(customer);
    }

    @Test
    public void parseComplexJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(complexJson, new TypeReference<Result>() {
        });
        List<Customer> customers = result.getCustomers();
        System.out.println(customers);
        System.out.println(result);
    }

    @Test
    public void parseComplexByStep() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(complexJson);
        String message = rootNode.get("message") != null ? rootNode.get("message").asText() : "";
        int code = rootNode.get("code") != null ? rootNode.get("code").asInt() : 0;
        List<Customer> customers=new ArrayList<>();
        JsonNode customersNode = rootNode.get("customers");
        for (int i = 0; i < customersNode.size(); i++) {
            Customer customer = new Customer();
            customer.setName(customersNode.get(i).get("name").asText());
            customer.setAge(customersNode.get(i).get("age").asInt());
            customer.setVerified(customersNode.get(i).get("verified").asBoolean());
            JsonNode marksNode = customersNode.get(i).get("marks");
            List<Integer> marks = new ArrayList<>();
            for (int j = 0; j < marksNode.size(); j++) {
                marks.add(marksNode.get(i).asInt());
            }
            customer.setMarks(marks);
            customers.add(customer);
        }
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setCustomers(customers);
        System.out.println(result);
    }




    static class Result {

        private String message;
        private int code;
        private List<Customer> customers;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public List<Customer> getCustomers() {
            return customers;
        }

        public void setCustomers(List<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public String toString() {
            return "Result{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", customers=" + customers +
                '}';
        }
    }

    static class Customer {
        public Customer(){}
        public Customer(String name,int age){
            this.name=name;
            this.age=age;
        }

        private String name;

        private int age;

        private boolean verified;

        private List<Integer> marks;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public boolean getVerified() {
            return this.verified;
        }

        public void setMarks(List<Integer> marks) {
            this.marks = marks;
        }

        public List<Integer> getMarks() {
            return this.marks;
        }

        @Override
        public String toString() {
            return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", verified=" + verified +
                ", marks=" + marks +
                '}';
        }
    }
}
