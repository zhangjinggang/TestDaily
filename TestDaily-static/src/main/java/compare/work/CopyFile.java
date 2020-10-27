package compare.work;

import java.io.*;

public class CopyFile {

    //程序入口
    public static void main(String[] args) throws IOException {
        moveFiles("F:\\.m2\\repositoryTemp","H:\\lib\\temp");
    }




    public static boolean moveFiles(String oldPath, String newPath){
        boolean result = true;
        String[] filePaths = new File(oldPath).list();

        if (filePaths != null && filePaths.length > 0){
            if (!new File(newPath).exists()){
                if(!new File(newPath).mkdirs()){
                    System.out.println("文件夹创建失败");
                    return false;
                }
            }

            try{
                for (String filePath : filePaths) {
                    if(filePath.endsWith(".jar")){
                        copyFile(oldPath + File.separator + filePath, newPath + File.separator + filePath);
                    } else if (new File(oldPath + File.separator + filePath).isDirectory()){
                        moveFiles(oldPath + File.separator + filePath, newPath);
                    }
//                    else if (new File(oldPath + File.separator + filePath).isFile()){
//                        //复制文件到另一个目录
//                        copyFile(oldPath + File.separator + filePath, newPath + File.separator + filePath);
//                        //移动文件至另一个目录
//                        if(!new File(oldPath + File.separator + filePath).renameTo(new File(newPath + File.separator + filePath))){
//                            System.out.println(oldPath + File.separator + filePath +"文件复制失败");
//                            result = false;
//                            break;
//                        }
//                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[1024];

        while((in.read(buffer)) != -1){
            out.write(buffer);
        }
    }
}
