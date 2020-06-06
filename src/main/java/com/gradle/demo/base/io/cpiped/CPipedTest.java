package com.gradle.demo.base.io.cpiped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author guxc
 * @date 2020/6/6
 */
public class CPipedTest {

    public static void main(String[] args) throws IOException {
        CSender cSender = new CSender();
        CReceiver cReceiver = new CReceiver();
        PipedWriter pipedWriter = cSender.getPipedWriter();
        PipedReader pipedReader = cReceiver.getPipedReader();

        pipedReader.connect(pipedWriter);

        cSender.start();
        cReceiver.start();
    }
}
