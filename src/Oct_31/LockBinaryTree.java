package Nov_31_10;

class LockBT {
    public LockBT left;
    public LockBT right;
    public LockBT parent;
    boolean isLocked;

    boolean is_lock() {
        return isLocked;
    }

    boolean lock() {

        if(canLock()) {
            isLocked = true;
            return true;
        }
        return false;
    }

    boolean canLock() {

        if(isLocked)

            return false;

        boolean element = true;
        if(parent != null)
            element = element && parent.canLock();
        if(left!= null)
            element = element && left.canLock();
        if(right != null)
            element = element && right.canLock();

        return element;

    }

    boolean unlock() {
        isLocked = false;
        return false;
    }

}
public class LockBinaryTree {

    public static void  main(String args[]) {

        LockBT root = new LockBT();
        LockBT node1 = new LockBT();
        LockBT node2 = new LockBT();
        LockBT node3 = new LockBT();

        root.left = node1;
        root.right = node2;
        node1.left = node3;

        System.out.println(node1.lock());
        System.out.println(node1.unlock());
        System.out.println(root.lock());

    }


}
