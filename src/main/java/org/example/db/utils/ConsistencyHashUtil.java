package org.example.db.utils;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.zip.CRC32;

/**
 * @author liudaojian
 * Date: 2023/5/25 18:43
 * Description:
 */
@Component
public class ConsistencyHashUtil {

    private static final List<String> NODES = new LinkedList<>();

    private static final SortedMap<Long, String> VIRTUAL_NODE_LIST = new TreeMap<>();

    private static final int VIRTUAL_NODE_NUM = 64;

    static {

        NODES.add("0");
        NODES.add("1");

        for (String node : NODES) {

            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                long virtualHash = getHash(node + i);
                VIRTUAL_NODE_LIST.put(virtualHash, node);
            }

        }

    }

    public static String find(String key) {
        long hash = getHash(key);
        for (long k : VIRTUAL_NODE_LIST.keySet()) {
            if (hash < k) {
                return VIRTUAL_NODE_LIST.get(k);
            }
        }
        return NODES.get(0);
    }

    private static long getHash(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        return crc32.getValue();
    }

}
