package com.dstealer.algrothims.filesplit;

import com.dstealer.algrothims.common.Pair;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class FileSpliterTest {

    @Test
    public void split() throws IOException {
        File file = new File(ClassLoader.getSystemClassLoader().getResource("bigtext.txt").getFile());
        FileSpliter spliter = new FileSpliter(file);
        List<Pair<Long>> split = spliter.split(3);
        split.forEach(p -> {
            System.out.println(p.get_1() + "-" + p.get_2());
        });
        split.forEach(p -> {
            try {
                System.out.println(new String(spliter.read(p)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}