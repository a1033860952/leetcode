import java.util.*;

class LockingTree {
    Map<Integer, List<Integer>> map; // 保存节点 u 与 u 的孩子节点
    Map<Integer, Integer> locked; // 保存上锁的节点 u 与 锁的所有者
    int[] parent; // 父节点数组

    public LockingTree(int[] parent) {
        map = new HashMap<>();
        locked = new HashMap<>();
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) {
            int fa = parent[i];
            map.computeIfAbsent(fa, k -> new ArrayList<>()).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!locked.containsKey(num) || locked.get(num) != user) return false;
        locked.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locked.containsKey(num)) return false;
        if (!searchCl(num)) return false;
        if (searchFa(num)) return false;
        unlockCl(num);
        locked.put(num, user);
        return true;
    }

    // 判断有没有上锁的祖先节点
    public boolean searchFa(int u) {
        if (locked.containsKey(u)) return true;
        if (u == -1) return false;
        return searchFa(parent[u]);
    }

    // 判断有没有上锁的子孙节点
    public boolean searchCl(int u) {
        if (locked.containsKey(u)) return true;
        if (!map.containsKey(u)) return false;
        boolean res = false;
        for (int cl : map.get(u)) res |= searchCl(cl);
        return res;
    }

    // 解锁所有已上锁的子孙节点
    public void unlockCl(int u) {
        if (locked.containsKey(u)) locked.remove(u);
        if (!map.containsKey(u) || locked.size() == 0) return;
        for (int cl : map.get(u)) unlockCl(cl);
    }
}