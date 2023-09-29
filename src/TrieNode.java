
public class TrieNode {

	TrieNode children[] = new TrieNode[36];
	int index;

	public TrieNode() {

		index = -1;
		for (int i = 0; i < children.length; i++)
			children[i] = null;
	}

}
