package com.educative.datastructures.trie;

//Incomplete - not working
public class DictWord {
    private static int i = 0;
    public static Object isFormationPossible(String[] dict,String word) {
        Trie trie = new Trie();
        //insert dict into trie
        for(int i=0; i< dict.length; i++){
            trie.insert(dict[i]);
        }
        boolean isPossible = false;

        return isPossible;
    }

    public static boolean isPossible(Trie trie, String word){
        boolean isPossible = false;
        int index;
        TrieNode currNode = trie.getRoot();
        while(i<word.length()){
            if(currNode.children!=null){
                index = trie.getIndex(word.charAt(i));
                if(currNode.children[index]!=null){
                    currNode = currNode.children[index];
                    if(currNode.isEndWord){
                        isPossible = true;
                        if(i<word.length()-1)
                            isPossible = isPossible(trie, word.substring(i+1, word.length()));
                    }
                }else{
                    return false;
                }
                i++;
            }else{
                return false;
            }
        }
        return isPossible;
    }

}
