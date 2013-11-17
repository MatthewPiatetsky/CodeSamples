/**
 * This file contains the WordList class and the Node class.
 * The WordList class contains two trees, which are used to process input text.
 * This text is sorted and returned as a string representation showing the text and the number of occurences, with the most frequently occuring word displayed first. 
 * The Node class stores the information on the text for use by the trees including the word itself, the number of ocurrences and the left and right pointers in the tree.
 * Much of the code on trees is adapted from code shown in class and in the textbook.
 * 
 * Author: Matthew Piatetsky
 * Date:4/14/2012
 */

public class WordList
{
    // Creates the root nodes for the two trees
    private static WordList.Node root1;
    private static WordList.Node root2;

    // Constructor for the WordList. Sets both roots to null.
    public WordList()
    {
        root1 = null;
        root2 = null;
    }

    //This method inserts a word into the word list.
    public void insert(String word)
    {
        //check for an empty string
        if (!word.equals("")) 
        {
            //calls the insert method to insert a word into the tree
            root1 = insert(root1, word); 
        }
    }

    // Method for inserting a word into a tree as a text node. Its name is overloaded with the previous method.
    private WordList.Node insert(WordList.Node text, String word) {
        // Checks whether this is the first word being inserted
        if (text == null)  {
            return new WordList.Node(word); 
        }
        // Checks whether the word being inserted is smaller than the current node
        if (word.compareTo(text.word) < 0) {
            text.left = insert(text.left, word);
            return text;
        }
        // Checks whether the word being inserted is greater than the current node
        if (word.compareTo(text.word) > 0) {
            text.right = insert(text.right, word);
            return text;
        }
        text.count = text.count + 1; //increment count
        return text;
    }

    // This method calls the overloaded insert2 to insert each node into the second tree.
    public void insert2(WordList.Node text) {
        root2 = insert2(root2, text);
    }

    // Method for inserting words into tree sorted by the number of occurences of each word
    private WordList.Node insert2(WordList.Node text1, WordList.Node text2) {
        // Checks if this is the first word being inserted
        if (text1 == null) {
            text2.left = (text2.right = null);
            return text2;
        }
        // Recursively checks if the count for the word being inserted is larger than the current word
        if (text1.count < text2.count) {
            text1.left = insert2(text1.left, text2);
            return text1;
        }
        // Recursively checks if the count for the word being inserted is smaller than the current word
        if (text1.count > text2.count) {
            text1.right = insert2(text1.right, text2);
            return text1;
        }
        // Sorts words alphabetically if they have the same number of occurences
        if (text1.word.compareTo(text2.word) > 0) {
            text1.left = insert2(text1.left, text2);
            return text1;
        }if (text1.word.compareTo(text2.word) < 0) {
            text1.right = insert2(text1.right, text2);
            return text1;
        }
        return text1;
    }
    
    // Traverses the list with postorder traversal and uses insert2 to construct a new tree.
    private void traverseList(WordList.Node text)
    {
        if (text != null) {
            traverseList(text.left);
            traverseList(text.right);
            insert2(text);
        }
    }
    
    // Sorts the WordList using the traversal and toString methods
    public String getString()
    {
        traverseList(root1); // Inputs the first tree to be sorted
        return toString(root2); // Sorts the contents of the first tree and returns a string representation of the sorted tree
    }

    //Method for returning a string representation of contents of the tree
    private String toString(WordList.Node p) {
        if (p == null) { 
            return ""; 
        }
        return toString(p.left) + p + "\n" + toString(p.right); // Recursively builds up the string using the sorted tree
    }

    // Unit Test Main that tests whether the WordList works.
    public static void main(String[] args) {
        WordList Test = new WordList();
        Test.insert("It's");
        Test.insert("a");
        Test.insert("fez");
        Test.insert("I");
        Test.insert("wear");
        Test.insert("a");
        Test.insert("fez");
        Test.insert("now");
        Test.insert("fezzes");
        Test.insert("are");
        Test.insert("cool!");
        System.out.println(Test.getString());
    }

    // The class Node creates the necessary nodes to store information on the text being inserted into the trees.
    class Node
    {
        // Creates variables to keep track of the word being inserted, the number of occurences, and the left and right pointers. 
        String word;
        int count;
        Node left;
        Node right;

        // A constructor for the Node class that initializes the variables for word, count and the left and right pointers.
        public Node(String word)
        {
            this.word = word;
            this.count = 1;
            this.left = null;
            this.right = null;
        }

        // toString method for the text entries. It is used to display the words and their number of occurences when you build the concordance in the GUI.
        public String toString() {
            return this.word + "\t[" + this.count + "]";
        }
    }
}