package divideAndConquer;

import javax.swing.*;
import java.awt.*;

public class BinaryTreeDrawing extends JFrame {

    private Node root;

    public BinaryTreeDrawing(Node root) {
        this.root = root;
        setTitle("Binary Tree Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int startX = getWidth() / 2;
        int startY = 50;
        int levelHeight = 80;
        int levelWidth = 40;
        drawNode(g, root, startX, startY, levelWidth, levelHeight);
    }

    private void drawNode(Graphics g, Node node, int x, int y, int levelWidth, int levelHeight) {
        g.setColor(Color.WHITE);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(node.getData(), x - 6, y + 5);

        if (node.getLeft() != null) {
            int leftX = x - levelWidth;
            int leftY = y + levelHeight;
            g.drawLine(x, y+15, leftX, leftY);
            drawNode(g, node.getLeft(), leftX, leftY, levelWidth / 2, levelHeight);
        }

        if (node.getRight() != null) {
            int rightX = x + levelWidth;
            int rightY = y + levelHeight;
            g.drawLine(x, y+15, rightX, rightY);
            drawNode(g, node.getRight(), rightX, rightY, levelWidth / 2, levelHeight);
        }
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        root.setLeft(new Node("B"));
        root.setRight(new Node("C"));
        root.getLeft().setLeft(new Node("D"));
        root.getLeft().setRight(new Node("E"));
        root.getRight().setLeft(new Node("F"));
        root.getRight().setRight(new Node("G"));

        BinaryTreeDrawing treeDrawing = new BinaryTreeDrawing(root);
        treeDrawing.setVisible(true);
    }
}

class Node {
    private String data;
    private Node left;
    private Node right;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
