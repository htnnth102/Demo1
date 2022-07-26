package JavaIOStream;

import java.io.*;


public class Demo {
    public static void main(String[] args) {
//        File file = new File("data.txt");
//        String content = "This is the text content";
//
//        try (OutputStream out = new FileOutputStream(file);
//             BufferedOutputStream bout = new BufferedOutputStream(out);) {
//
//            // if file doesn't exists, then create it
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            // get the content in bytes
//            bout.write(content.getBytes());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file = new File("data.txt");
        String content = "Ha Thi Ngan";
        long start = System.currentTimeMillis();
// ...
        try (FileWriter fw = new FileWriter(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            fw.write(content);
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
