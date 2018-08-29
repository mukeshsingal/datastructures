package leetcode;

public class Problem_56_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return new ArrayList<>();
        List<Interval> resList = new ArrayList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(int i = 0 ; i < intervals.size() ; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = start[0];
        for(int i = 0 ; i < end.length - 1 ; i++){
            if(end[i] < start[i + 1]){
                Interval it = new Interval(s, end[i]);
                resList.add(it);
                s = start[i + 1];
            }
        }
        resList.add(new Interval(s, end[end.length - 1]));
        return resList;
    }
}
