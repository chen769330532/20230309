package com.example.demo.testEnum.enumdemo;

/**
 * @author Chenjl
 * @date 2020/8/21 15:49
 */
public class TestCompanyEnum {

    public static void main(String[] args) {
        String toutiao="Toutiao";
        CompanyRun companyRun = CompanyEnum.match(toutiao);
        companyRun.run();
    }
}
