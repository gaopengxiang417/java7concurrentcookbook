package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午8:52
 */
public class FileMock {

    private String[] contents;

    private int index ;

    public FileMock(int size, int length) {
        contents = new String[size];

        for (int i = 0; i < size; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < length; j++) {
                int ch = (int) (Math.random() * 255);
                stringBuffer.append((char) ch);
            }
            contents[i] = stringBuffer.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines(){
        return index < contents.length;
    }

    public String getLine() {
        if (hasMoreLines()) {
            return contents[index++];
        }
        return null;
    }


}
