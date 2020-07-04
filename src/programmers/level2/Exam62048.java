package programmers.level2;

public class Exam62048 {

    public long solution(int w, int h) {
        long answer = (long) w * h;
        int gcdValue = gcd(w, h);
        answer = answer - (gcdValue * getOverlappingBlocks(w / gcdValue, h / gcdValue));
        return answer;
    }

    private int gcd(int w, int h) {
        if (w < h) {
            int temp = w;
            w = h;
            h = temp;
        }
        if (w % h == 0) return h;
        else return gcd((w % h), h);
    }

    private int getOverlappingBlocks(int w, int h) {
        return w + h - 1;
    }
}
