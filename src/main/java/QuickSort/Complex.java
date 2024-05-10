package QuickSort;

public class Complex {
    private final double mRe;
    private final double mIm;
    public Complex(double re, double im) {
        mRe = re;
        mIm = im;
    }

    public double module() {
        return Math.sqrt(mRe * mRe + mIm * mIm);
    }

    @Override
    public String toString() {
        return  mRe + "+" + "i*" +mIm;
    }

}