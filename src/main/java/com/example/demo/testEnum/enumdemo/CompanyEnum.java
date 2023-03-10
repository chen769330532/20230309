package com.example.demo.testEnum.enumdemo;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author Chenjl
 * @date 2020/8/21 15:17
 */

public enum CompanyEnum {

    Toutiao("Toutiao", new TouTiaoRun()),
    Tencent("Tencent", new TencentRun()),
    Baidu("Baidu", new BaiduRun());

    private String companyName;

    private CompanyRun companyRun;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyRun getCompanyRun() {
        return companyRun;
    }

    public void setCompanyRun(CompanyRun companyRun) {
        this.companyRun = companyRun;
    }

    CompanyEnum(String companyName, CompanyRun companyRun) {
        this.companyName = companyName;
        this.companyRun = companyRun;
    }

    public static CompanyRun match(String companyName){
        CompanyEnum[] values = CompanyEnum.values();
        for(CompanyEnum companyEnum :values){
            if(companyEnum.companyName.equals(companyName)){
                return companyEnum.companyRun;
            }
        }
        return null;
    }
}
