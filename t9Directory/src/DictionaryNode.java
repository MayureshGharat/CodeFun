/**
 * Created with IntelliJ IDEA.
 * User: mgharat
 * Date: 5/12/14
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class DictionaryNode {

    private boolean isWord;
    private DictionaryNode[] childNodes;

    public DictionaryNode() {
        childNodes = new DictionaryNode[26];
        isWord = false;
    }

    public boolean setchild(int i)
    {
        childNodes[i] = new DictionaryNode();

        return true;
    }

    public boolean setword()
    {
        isWord = true;

        return true;
    }

    public boolean isWord()
    {
        return isWord;
    }

    public DictionaryNode getChild(int index)
    {
        return childNodes[index];
    }
}
