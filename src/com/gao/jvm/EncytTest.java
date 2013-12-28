package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-12-26
 * Time: 下午7:32
 */
public class EncytTest {
    public static void main(String[] args) {
        String str = "Name,CardNo,Descriot,CtfTp,CtfId,Gender,Birthday,Address,Zip,Dirty,District1,District2,District3,District4,District5,District6,FirstNm,LastNm,Duty,Mobile,Tel,Fax,EMail,Nation,Taste,Education,Company,CTel,CAddress,CZip,Family,Version,id";

        String[] strings = str.split(",");
        int count = 200000;
        for (String string : strings) {
            System.out.println(string + " string,");
        }
    }
}
