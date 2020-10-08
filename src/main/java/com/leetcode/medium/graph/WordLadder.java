package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength("a", "c", Arrays.asList("a","b","c")));
        System.out.println(ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot")));
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "tog", "dot", "cog")));
        System.out.println(ladderLength("talk", "tail", Arrays.asList("talk","tons","fall","tail","gale","hall","negs")));
        System.out.println(ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordLst) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> container = new HashSet<>(wordLst);
        queue.add(beginWord);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                visited.add(word);
                for (int k = 0; k < word.length(); k++) {
                    char[] chars = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[k] = j;
                        String newWord = String.valueOf(chars);
                        if(container.contains(newWord) && !visited.contains(newWord)){
                            queue.add(newWord);
                            visited.add(newWord);
//                            container.remove(newWord);
                        }
                    }
                }
            }
            count ++;
            if(visited.contains(endWord)) {
                break;
            }
        }
        if(!visited.contains(endWord)){
            return 0;
        }
        return count == 0 ? 0 : count + 1;

    }
}
