package com.chenx.util;

import com.chenx.common.util.BCryptUtil;

public class BCryptUtilTest {
    public static void main(String[] args) {
        String password = "111111";
        String hash = BCryptUtil.hashpw(password, BCryptUtil.gensalt());
        String hash1 = BCryptUtil.hashpw(password, BCryptUtil.gensalt(12));
        System.out.println(hash);
        System.out.println(hash1);

        System.out.println(BCryptUtil.checkpw(password, hash));
        System.out.println(BCryptUtil.checkpw(password, hash1));

    }
}
