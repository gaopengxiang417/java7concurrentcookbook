package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午9:11
 */
public class ProducerMock implements Runnable {

    private FileMock fileMock;

    private Buffer buffer;

    public ProducerMock(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (fileMock.hasMoreLines()) {
            String line = fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
