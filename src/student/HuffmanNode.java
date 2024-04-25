package student;

public class HuffmanNode {
    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;

    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.zero = zero;
        this.one = one;
        this.data = null;
    }

    public HuffmanNode(Character data) {
        this.zero = null;
        this.one = null;
        this.data = data;
    }

    public HuffmanNode getZero() {
        return zero;
    }

    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    public HuffmanNode getOne() {
        return one;
    }

    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return zero == null && one == null && data != null;
    }

    public boolean isValidNode() {
        return (isLeaf() && zero == null && one == null && data != null) ||
                (!isLeaf() && zero != null && one != null && data == null);
    }

    public boolean isValidTree() {
        if (!isValidNode()) {
            return false;
        }
        if (isLeaf()) {
            return true;
        }
        return zero.isValidTree() && one.isValidTree();
    }
}
