package com.test.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LogReordering {

    public static void main(String[] args) {
        System.out.println(new LogReordering().reorderLines(5, Arrays.asList("a1 9 2 3 1",
            "g1 act cat", "zo4 4 7",
            "ab1 off key dog", "a8 act zoo")));
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<ContainerInt> numbersContainer = new LinkedList<>();
        List<Container> wordsContainer = new LinkedList<>();
        for (int i = 0; i < logLines.size(); i++) {

            String line = logLines.get(i);
            String[] words = line.split(" ");
            boolean isIntLine = true;
            for (int j = 1; j < words.length ; j++) {
                try{
                    Integer.parseInt(words[j]);
                } catch (Exception e){
                    isIntLine = false;
                }
            }
            if(isIntLine){

                List<Integer> numbers = new LinkedList<>();
                for (int j = 1; j < words.length ; j++) {
                    numbers.add(Integer.parseInt(words[j]));
                }
                numbersContainer.add(new ContainerInt(words[0], numbers));
            } else {

                List<String> words2 = new LinkedList<>();
                for (int j = 1; j < words.length ; j++) {
                    words2.add(words[j]);
                }
                wordsContainer.add(new Container(words[0], words2));
            }
        }

        Collections.sort(wordsContainer);

        List<String> result = new ArrayList<>();

        int i = 0;
        for (; i < wordsContainer.size() - 1; i++) {
            Container c = wordsContainer.get(i);
            Container c2 = wordsContainer.get(i + 1);
            String token = c.getIdentifier() + " " + c.toString();
            if(c.toString().equals(c2)){
                if(c.getIdentifier().compareTo(c2.getIdentifier()) < 0){
                    token = c2.getIdentifier() + " " + c2.toString();
                    i++;
                    result.add(token);
                }
            }
            token = c.getIdentifier() + " " + c.toString();
            result.add(token);
        }

        if(i < wordsContainer.size()){
            Container c = wordsContainer.get(i);
            String token = c.getIdentifier() + " " + c.toString();
            result.add(token);
        }

        for (int j = 0; j < numbersContainer.size(); j++) {
            ContainerInt c = numbersContainer.get(j);
            String token = c.getIdentifier() + " " + c.toString();
            result.add(token);
        }

        return result;
        // WRITE YOUR CODE HERE
    }

    class Container implements Comparable{
        String identifier;
        List<String> value;

        public Container(String identifier, List<String> value) {
            this.identifier = identifier;
            this.value = value;
        }

        public String getIdentifier() {
            return identifier;
        }

        public List<String> getValue() {
            return value;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value.size(); i++) {
                builder.append(value.get(i));
                builder.append(" ");
            }
            builder.replace(builder.length() - 1, builder.length(), "");
            return builder.toString();
        }

        @Override
        public int compareTo(Object o) {

            Container co = (Container)o;
            String s1 = co.toString();
            return toString().compareTo(s1);
        }
    }

    class ContainerInt{
        String identifier;
        List<Integer> value;

        public ContainerInt(String identifier, List<Integer> value) {
            this.identifier = identifier;
            this.value = value;
        }

        public String getIdentifier() {
            return identifier;
        }

        public List<Integer> getValue() {
            return value;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public void setValue(List<Integer> value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value.size(); i++) {
                builder.append(value.get(i));
                builder.append(" ");
            }
            builder.replace(builder.length() - 1, builder.length(), "");
            return builder.toString();
        }
    }




}
