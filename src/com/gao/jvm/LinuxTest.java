package com.gao.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * User: wangchen.gpx
 * Date: 13-9-13
 * Time: 下午2:05
 */
public class LinuxTest {
    public static void main(String[] args) throws InterruptedException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new Date());
        String bash = "/bin/sh";
        String argument = "-c";
        String lsFile = "hadoop fs -ls /group/dbm/sas2/ok";
        String mkdir = "hadoop fs -mkdir /group/dbm/sas2/ok/" + today + "/";
        String mkfile = "hadoop fs -touchz /group/dbm/sas2/ok/" +today + "/";

        try {
            Runtime runtime = Runtime.getRuntime();
            if (!createPath(today, bash, argument, lsFile, mkdir, runtime)){
                return;
            }
            if (!createTableFile(100000, today, bash, argument, lsFile, mkfile, runtime))
                return;
        }catch (Exception e){
            return ;
        }
        return ;
    }

    private static boolean createTableFile(Integer tableid, String today, String bash, String argument, String lsFile, String mkfile, Runtime runtime) throws IOException, InterruptedException {
        BufferedReader bufferedReader = null;
        try {
            int result;

            String[] lsOkDirFile = {bash, argument, lsFile + "/" + today + "/"};
            Process lsOKFile = runtime.exec(lsOkDirFile);

            result = lsOKFile.waitFor();
            if (result != 0) {
                return false;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(lsOKFile.getInputStream()));
            String str = null;
            boolean dirIsExistone = false;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.equalsIgnoreCase(tableid.toString())){
                    dirIsExistone = true;
                    break;
                }
            }

            if (!dirIsExistone){
                String[] createFile = {bash, argument, mkfile + "/" +tableid};
                Process createDirProcess = runtime.exec(createFile);
                result = createDirProcess.waitFor();

                if (result != 0){
                    return false;
                }
            }
        } finally {
            bufferedReader.close();
        }
        return true;
    }

    private static boolean createPath(String today, String bash, String argument, String lsFile, String mkdir, Runtime runtime) throws IOException, InterruptedException {
        BufferedReader bufferedReader = null;
        try {
            String[] lsOkDir = {bash, argument, lsFile};
            Process process = runtime.exec(lsOkDir);

            int result = process.waitFor();
            if (result != 0) {
                return false;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = null;
            boolean dirIsExist = false;
            while ((s = bufferedReader.readLine()) != null) {
                if (s.equalsIgnoreCase(today)){
                    dirIsExist = true;
                    break;
                }
            }

            if (!dirIsExist){
                String[] createDir = {bash, argument, mkdir};
                Process createDirProcess = runtime.exec(createDir);
                result = createDirProcess.waitFor();

                if (result != 0){
                    return false;
                }
            }
        } finally {
            bufferedReader.close();
        }
        return true;
    }
}
