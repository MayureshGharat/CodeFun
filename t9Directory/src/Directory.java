import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mgharat
 * Date: 5/12/14
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class Directory {

    Map<Character, String> keyPad;
    DictionaryNode root;

    public Directory() {
        keyPad = new HashMap<>();
    }

    public boolean intialize() {

        keyPad.put('1',"");
        keyPad.put('2',"ABC");
        keyPad.put('3',"DEF");
        keyPad.put('4',"GHI");
        keyPad.put('5',"JKL");
        keyPad.put('6',"MNO");
        keyPad.put('7',"PQRS");
        keyPad.put('1',"TUV");
        keyPad.put('1',"WXYZ");

        return true;
    }

    //Using queue to store the intermediate stages
    public List<String> search(String number) {
        Queue<String> tempQueue = new ArrayDeque<>();
        List<String> words = new LinkedList<>();

        tempQueue.add("");

        for (int i = 0; i < number.length(); i++) {
            String key = keyPad.get(number.charAt(i));

            for (int qLength = tempQueue.size(); qLength > 0; qLength--) {
                String prefix = tempQueue.remove();

                for (int j = 0; j < key.length(); j++) {
                    String str = prefix + key.charAt(j);

                    if (searchDictionary(str)) {
                        words.add(str);
                    } else {
                        tempQueue.add(str);
                    }
                }
            }
        }

        return words;
    }

    private boolean searchDictionary(String str) {

        DictionaryNode currentNode = root;

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            currentNode = currentNode.getChild(index);
            if (currentNode == null) {
                return false;
            }
        }

        return currentNode.isWord();
    }

    public boolean insert(String input)
    {
      DictionaryNode dictionaryNode = root;

        for(int i = 0; i < input.length(); i++)
        {
            int index = input.charAt(i)- '0';
            if(dictionaryNode.getChild(index) == null)
            {
                dictionaryNode.setchild(index);
            }

            dictionaryNode = dictionaryNode.getChild(index);
        }

      dictionaryNode.setword();
      return true;
    }

}
