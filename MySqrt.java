class MySqrt {
    public double BS(double start, double end, double x) {
        System.out.println(start+" "+end+" "+x);
        if(start > end) {
            return -1;
        }
        double mid = Math.floor((start+end)/2);
        if(mid*mid <= x && (mid+1)*(mid+1) > x) 
            return mid;
        else if(mid*mid > x) {
            return BS(start, mid-1, x);
        } else {
            return BS(mid+1, end, x);
        }
    }
    public int mySqrt(int x) {
        return (int) BS(0, x, x);
    }
}
