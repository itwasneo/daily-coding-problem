package com.itwasneo.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Day3<T> {
    public static class Node<T> {
        T val;
        Node<T> left;
        Node<T> right;

        Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final char LEFT_BRANCH = '/';
    private static final char RIGHT_BRANCH = '\\';

    private static final char LEAF = '#';

    public String serialize(Node<T> root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val.toString());
        if (root.left != null) {
            sb.append(LEFT_BRANCH);
            sb.append(serialize(root.left));
        }

        if (root.right != null) {
            sb.append(RIGHT_BRANCH);
            sb.append(serialize(root.right));
        } else {
            sb.append(LEAF);
        }
        return sb.toString();
    }

    private T readValue(BufferedReader br, int c) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            while (true) {
                c = br.read();
                if (c != LEFT_BRANCH && c != RIGHT_BRANCH && c != LEAF && c != -1) {
                    sb.append(c);
                } else {
                    break;
                }
            }
            return (T) sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void preorder(Node<T> root) {
        if (root.val != null) {
            System.out.print(root.val);
        }

        if (root.left != null) {
            System.out.print(", ");
            preorder(root.left);
        }

        if (root.right != null) {
            System.out.print(", ");
            preorder(root.right);
        }
    }

    public Node<T> deserialize(String str) {
        try {

            BufferedReader br = new BufferedReader(new StringReader(str));
            Node<T> root = new Node<>(null, null, null);
            while (true) {
                int c = br.read();
                if (c == -1) {
                    break;
                }
                if (c == LEFT_BRANCH) {
                    c = br.read();
                    root.left = new Node<>(readValue(br, c), null, null);

                } else if (c == RIGHT_BRANCH) {
                    c = br.read();
                    root.right = new Node<>(readValue(br, c), null, null);

                } else if (c == LEAF) {

                } else {
                    if (root.val == null) {
                        root.val = readValue(br, c);
                    }
                }
            }
            preorder(root);
            return root;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
