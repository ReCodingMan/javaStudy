package java2.File;

import java.io.File;
import java.io.FileFilter;

/**
 * 创建过滤器 FileFilter 的实现类，重写过滤方法 accept，定义过滤规则
 */
public class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }else{
            return pathname.getName().toLowerCase().endsWith(".java");
        }
    }
}
