package playlist;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Main {
    public static int maiorSequenciaUnica(int n, int[] musicas) {
        HashSet<Integer> musicasUnicas = new HashSet<>();
        int maximoTamanho = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (musicasUnicas.contains(musicas[right])) {
                musicasUnicas.remove(musicas[left]);
                left++;
            }
            musicasUnicas.add(musicas[right]);
            maximoTamanho = Math.max(maximoTamanho, right - left + 1);
        }

        return maximoTamanho;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] musicas = new int[n];
        for (int i = 0; i < n; i++) {
            musicas[i] = in.nextInt();
        }
       

        int r = maiorSequenciaUnica(n, musicas);
        System.out.println(r);
    }
    
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    public static class FastReader {

        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf =0, ptrbuf =0;
        public FastReader(InputStream is)
        {
            this.is=is;
        }

        public int readByte() {
            if(lenbuf==-1)throw new InputMismatchException();
            if(ptrbuf>=lenbuf) {
                ptrbuf =0;
                try {
                    lenbuf = is.read(inbuf);
                }catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(lenbuf<=0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c>=33 && c<=126);
        }
        public boolean isEndOfLine(int c) {
            return c=='\n' || c=='\r' || c==-1;
        }

        public int skip() {
            int b;
            while((b=readByte())!=-1 && isSpaceChar(b));
            return b;
        }

        public  String next()
        {
            int b =skip();
            StringBuilder sb= new StringBuilder();
            while(!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b=readByte();
            }
            return sb.toString();
        }
        public String nextLine()
        {
            int c =skip();
            StringBuilder sb= new StringBuilder();
            while(!(isSpaceChar(c))) {
                sb.appendCodePoint(c);
                c=readByte();
            }
            return sb.toString();
        }
        public  int nextInt() {
            int num=0,b;
            boolean minus =false;
            while((b=readByte())!=-1 && !((b>='0'&&b<='9')|| b=='-'));
            if(b=='-') {
                minus =true;
                b=readByte();
            }
            while(true) {
                if(b>='0' && b<='9') {
                    num =(num<<3)+(num<<1)+(b-'0');
                }else {
                    return minus?-num:num;
                }
                b=readByte();
            }

        }

        public    long nextLong() {
            long num=0;int b;
            boolean minus =false;
            while((b=readByte())!=-1 && !((b>='0'&&b<='9')|| b=='-'));
            if(b=='-') {
                minus =true;
                b=readByte();
            }
            while(true) {
                if(b>='0' && b<='9') {
                    num =(num<<3)+(num<<1)+(b-'0');
                }else {
                    return minus?-num:num;
                }
                b=readByte();
            }

        }

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public char[] next(int n) {
            char buf[]=new char[n];
            int b=skip(),p=0;
            while(p<n && !(isSpaceChar(b))) {
                buf[p++]=(char)b;
                b=readByte();
            }
            return n ==p?buf:Arrays.copyOf(buf, p);
        }
        public char readChar() {
            return (char)skip();//uu
        }
    }
}
