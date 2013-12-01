package com.gao.forkjoin;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午10:47
 */
public class DocumentMock {
    //用来生成字符串的元数据
    private String[] words ={"the","hello","goodbye","packt", "java","thread","pool","random","class","main"};

    public String[][] generageDocument(int rows, int columns, String word) {
        Random random = new Random();
        int count = 0;
        String[][] result = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = random.nextInt(words.length);
                //统计所要查询的单词的个数,用来进行验证
                if (words[index].equals(word))
                    count++;
                result[i][j] = words[index];
            }
        }

        System.out.println("total count:" + count);
        return result;
    }
}
