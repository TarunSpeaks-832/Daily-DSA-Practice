class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()   //condition
        );
        // priorityqueue lo default ga min heap form ayipodhi kani dhanni max heap cheydaniki aa condition
        pq.addAll(map.entrySet()); //pq loki anni hashmap lo entries add chesam

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll();
            // okokka entry ni heap lonchi extract chestunnam
            // aa entry struture ey key value pair anduke map.entry anedhi daani datatype!!
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue())); 
            //idhi just string formation based on frequency anthe.. kakapothe kuncham proffesional ga chestunnam anthe..
        }
        return sb.toString();
    }
}

// Map.Entry<datatype a,datatype b>  idhi oka key value pair ki use chese structure anthe... 
// just to handle our char and int value easily 