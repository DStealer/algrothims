package com.dstealer.algrothims.filesplit;

import com.dstealer.algrothims.common.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 文件分割器
 */
public class FileSpliter {

    private final RandomAccessFile file;

    public FileSpliter(File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(Objects.requireNonNull(file), "r");
    }

    /**
     * 拆分文件
     *
     * @param slot
     * @return
     * @throws IOException
     */
    public List<Pair<Long>> split(int slot) throws IOException {
        List<Pair<Long>> slots = new ArrayList<>(slot);
        long stepLen = this.file.length() / slot;
        long position = 0L;
        long headerPosition;
        while ((headerPosition = detectLineHeader(position + stepLen)) != -1) {
            slots.add(new Pair<>(position, headerPosition));
            position = headerPosition;
        }
        if (position < this.file.length()) {
            slots.add(new Pair<>(position, this.file.length()));
        }
        return slots;
    }

    /**
     * 拆分文件
     *
     * @param slot
     * @return
     * @throws IOException
     */
    public byte[] read(Pair<Long> slot) throws IOException {
        byte[] bytes = new byte[(int) (slot.get_2() - slot.get_1())];
        this.file.seek(slot.get_1());
        this.file.read(bytes);
        return bytes;
    }

    /**
     * 检测一行的行首位置
     *
     * @param startPosition
     * @return
     * @throws IOException
     */
    private long detectLineHeader(long startPosition) throws IOException {
        this.file.seek(startPosition);
        int c = -1;
        boolean eol = false;

        while (!eol) {
            switch (c = this.file.read()) {
                case -1:
                case '\n':
                    eol = true;
                    break;
                case '\r':
                    eol = true;
                    long cur = this.file.getFilePointer();
                    if ((this.file.read()) != '\n') {
                        this.file.seek(cur);
                    }
                    break;
                default:
                    break;
            }
        }
        if (c == -1) {
            return -1;
        } else {
            return this.file.getFilePointer();
        }
    }
}
