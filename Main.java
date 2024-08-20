import static java.lang.Math.pow;



public class Main {
    public static void main(String[] args) {
        String password = "password";
        int langeHashwerte=6;
        long hv = rechnungHashwert(password , langeHashwerte);


        System.out.println(hv);


        String sha256Wert = org.apache.commons.codec.digest.DigestUtils.sha256Hex(String.valueOf(hv));
        System.out.println(sha256Wert);

    }

    static long rechnungHashwert (String s, int digits){
        long sum =0,
             mul =1;

        for( int i =0; i<s.length()-1; i++){
            if (i % 4==0){
                mul=1;
            }  mul *=64;

            sum+=(s.charAt(i)*mul);
        }

        long hv = sum;
        if( digits >= 1){
            hv = sum % (long)(pow(10,digits));
        }

    return hv;
    }
}