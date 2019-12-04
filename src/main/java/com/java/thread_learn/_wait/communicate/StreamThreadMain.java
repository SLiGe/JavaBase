package com.java.thread_learn._wait.communicate;

import java.io.*;

/**
 * @author Gary
 * @since 2019/12/04 14:42
 */
public class StreamThreadMain {

    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream();
            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();
            pipedWriter.connect(pipedReader);
            StreamData streamData = new StreamData();
            outputStream.connect(inputStream);
            new WriteThread(outputStream, streamData, pipedWriter).start();
            Thread.sleep(2000);
            new ReadThread(inputStream, streamData, pipedReader).start();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class WriteThread extends Thread {
        private PipedOutputStream outputStream;
        private StreamData streamData;
        private PipedWriter pipedWriter;

        public WriteThread(PipedOutputStream outputStream, StreamData streamData, PipedWriter pipedWriter) {
            super();
            this.outputStream = outputStream;
            this.streamData = streamData;
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            streamData.writeMethod(outputStream);
            streamData.writeMethodByChar(pipedWriter);
        }
    }

    static class ReadThread extends Thread {
        private PipedInputStream inputStream;
        private StreamData streamData;
        private PipedReader pipedReader;

        public ReadThread(PipedInputStream inputStream, StreamData streamData, PipedReader pipedReader) {
            super();
            this.inputStream = inputStream;
            this.streamData = streamData;
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {
            streamData.readMethod(inputStream);
            streamData.readMethodByChar(pipedReader);
        }
    }
}
