import model.Node;

public class BinaryTree<T> {
    private Node<T> node;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(Node<T> node) {
        this.node = node;
    }

    public void insert(Node<T> newNode, String criterion) {
        T currentValue = node.getProperty(criterion);
        T newValue = newNode.getProperty(criterion);

        if (newValue.hashCode() < currentValue.hashCode()) {
            if (left == null) {
                left = new BinaryTree<>(newNode);
            } else {
                left.insert(newNode, criterion);
            }
        } else {
            if (right == null) {
                right = new BinaryTree<>(newNode);
            } else {
                right.insert(newNode, criterion);
            }
        }
    }

    public Node<T> getNode() {
        return node;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }
}
