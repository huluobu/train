package com.carrot.train.test;

public class test {
    public static void main(String[] args) {
        UserDaoTest userDaoTest = new UserDaoTest();
        userDaoTest.queryUserByUsername();
        userDaoTest.queryUserByUsernameAndPassword();
        userDaoTest.saveUser();
    }
}
