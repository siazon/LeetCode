package com.siazon.others;

import com.siazon.tree.TreeNode;

public class DataCache {
    private static DataCache instance;

    public static synchronized DataCache getInstance() {
        if (instance == null)
            instance = new DataCache();
        return instance;
    }

    private DataCache() {
        tree = new TreeNode(30);
    }

    public TreeNode tree;
}
