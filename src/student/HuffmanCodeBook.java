package  student;

import provided.BinarySequence;

public class HuffmanCodeBook {
    private static final int MAX_CHARACTERS = 256; // Maximum number of characters

    private BinarySequence[] codebook; // Array to store binary sequences

    public HuffmanCodeBook() {
        this.codebook = new BinarySequence[MAX_CHARACTERS]; // Initialize the codebook
    }

    // Custom hash function
    private int hash(char c) {
        return (int) c; // Simple casting to integer
    }

    public void addSequence(char c, BinarySequence seq) {
        int index = hash(c); // Get the index using the custom hash function
        codebook[index] = seq; // Store the binary sequence at the calculated index
    }

    public boolean contains(char letter) {
        int index = hash(letter); // Get the index using the custom hash function
        return codebook[index] != null; // Check if the index contains a binary sequence
    }

    public boolean containsAll(String letters) {
        for (char c : letters.toCharArray()) {
            if (!contains(c)) {
                return false;
            }
        }
        return true;
    }

    public BinarySequence getSequence(char c) {
        int index = hash(c); // Get the index using the custom hash function
        return codebook[index]; // Return the binary sequence at the calculated index
    }

    public BinarySequence encode(String s) {
        StringBuilder encoded = new StringBuilder();
        for (char c : s.toCharArray()) {
            BinarySequence seq = getSequence(c);
            if (seq != null) {
                encoded.append(seq.toString());
            } else {
                // Handle the case where character is not in the codebook
            }
        }
        return new BinarySequence(encoded.toString());
    }

    public char[] getCharacterArray() {
        int count = 0;
        // Count the number of non-null entries in the codebook
        for (BinarySequence seq : codebook) {
            if (seq != null) {
                count++;
            }
        }
        char[] charArray = new char[count];
        int index = 0;
        // Iterate over the codebook array to populate the character array
        for (int i = 0; i < codebook.length; i++) {
            if (codebook[i] != null) {
                charArray[index++] = (char) i; // Convert index back to character
            }
        }
        return charArray;
    }

}
