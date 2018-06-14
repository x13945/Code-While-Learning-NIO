import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile{
    public static void main(String[] args) throws Exception {
        FileInputStream fio = new FileInputStream("testin.txt");
        FileChannel fcin = fio.getChannel();


        FileOutputStream fout = new FileOutputStream("testout.txt");
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true){
            buffer.clear();

            int lenght = fcin.read(buffer);
            if(lenght == -1){
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }
    }
}