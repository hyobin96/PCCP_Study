//풀이 시간 : 90분 + a
//시간복잡도 : O(L + N log N)
//코드 설명 : ArrayList를 이용해서 각 집합들을 배열에 집어넣음
//취약한 부분 : 딱 이런 문제가 젤 어려움.. 어떻게 잘라야할지도 잘 모르겠고, 자른다 한들 어떻게 집어넣야할지를 모르겠음

package PCCP;

import java.io.*;
import java.util.*;
class 카카오2019_problem2_튜플 {
    public int[] solution(String s) {
        String[] tmp = s.split("}"); //4
        int[] answer = new int[tmp.length];
        String[] arr = new String[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i].replaceAll("[{]", "");
        }

        List<String>[] arrList = new ArrayList[arr.length];
        for (int i = 0; i < arrList.length; i++) {
            arrList[i] = new ArrayList<>();
        }

        for(int i = 0; i < arr.length; i++) {
            int idx = 0;
            while(idx != arr[i].length()) {
                String a = "";
                for(int j = idx; j < arr[i].length(); j++) {
                    if(arr[i].charAt(j) == ',') {
                        idx = j + 1;
                        break;
                    }
                    a += arr[i].charAt(j);
                    idx++;
                }
                if(a.equals("")) continue;
                arrList[i].add(a);
            }
        }
        Arrays.sort(arrList, (a, b) -> a.size() - b.size());

        Set<String> set = new LinkedHashSet<>();

        for (List<String> list : arrList) {
            for(int i = 0; i < list.size(); i++) {
                set.add(list.get(i));
            }
        }

        int idx = 0;
        for(String a : set) {
            answer[idx++] = Integer.parseInt(a);
        }


        return answer;
    }
}