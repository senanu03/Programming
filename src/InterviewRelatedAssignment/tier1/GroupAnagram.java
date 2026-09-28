package InterviewRelatedAssignment.tier1;

import java.util.*;

public class GroupAnagram {


    private static List<List<String>> groupAnagrams(String[] str) {

        Map<String, List<String>> mp = new HashMap<>();

        for(String s : str){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if(!mp.containsKey(key)){
                mp.put(key, new ArrayList<>());
            }
//            List<String> list = mp.get(key);
//            list.add(s);
            //or
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(str));
    }


}
