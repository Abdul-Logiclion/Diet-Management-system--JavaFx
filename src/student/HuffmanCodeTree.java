
package student;

import provided.BinarySequence;

public class HuffmanCodeTree {
    private HuffmanNode root;

    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    public HuffmanCodeTree(HuffmanCodeBook codebook) {
        this.root = new HuffmanNode(null, null);
        for (char c : codebook.getCharacterArray()) {
            BinarySequence seq = codebook.getSequence(c);
            put(seq, c);
        }
    }

    public boolean isValid() {
        return root.isValidTree();
    }

    public void put(BinarySequence seq, char letter) {
        HuffmanNode current = root;
        for (boolean bit : seq) {
            if (bit) {
                if (current.getOne() == null) {
                    current.setOne(new HuffmanNode(null, null));
                }
                current = current.getOne();
            } else {
                if (current.getZero() == null) {
                    current.setZero(new HuffmanNode(null, null));
                }
                current = current.getZero();
            }
        }
        current.setData(letter);
    }

    public String decode(BinarySequence s) {
        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;
        for (boolean bit : s) {
            if (bit) {
                current = current.getOne();
            } else {
                current = current.getZero();
            }
            if (current.isLeaf()) {
                decoded.append(current.getData());
                current = root;
            }
        }
        return decoded.toString();
    }
}
